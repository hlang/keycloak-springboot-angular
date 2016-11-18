var secDemoApp = angular.module('secDemoApp', []);

secDemoApp.controller('secController', function ($scope, $http, keycloak) {

    $scope.comments = [];
    $scope.formData = {};
    $scope.user = {
        name: 'ahh',
        isUser: false,
        isAdmin: false
    };
    $scope.isTokenExpired = keycloak.isTokenExpired;
    $scope.token = keycloak.token;

    $scope.getComment = function () {
        $http.get('/api/comment').success(function (data) {
            $scope.comments = data;
        })
    };

    $scope.logout = function () {
        keycloak.logout();
    };

    $scope.addComment = function () {
        $http.post('/api/comment',
            $scope.formData.comment
        ).then(function successCallback(response) {
                $scope.getComment();
            },
            function errorCallback(response) {

            });
    };

    $scope.deleteComment = function (comment) {
        $http.delete("/admin/comment/" + comment.id)
            .then(function successCallback(response) {
                $scope.getComment();
            }, function errorCallback(response) {
                comment.status = response.status;
            });
    };

    keycloak.loadUserInfo().success(function (userInfo) {
        $scope.user.name = userInfo.name;
        $scope.$apply();
    });
    $scope.user.isUser = keycloak.hasRealmRole("user");
    $scope.user.isAdmin = keycloak.hasRealmRole("admin");

    $scope.getComment();

});

secDemoApp.factory('authInterceptor', function ($q, keycloak) {
    return {
        request: function (config) {
            var deferred = $q.defer();
            if (keycloak.token) {
                keycloak.updateToken(5).success(function () {
                    config.headers = config.headers || {};
                    config.headers.Authorization = 'Bearer ' + keycloak.token;

                    deferred.resolve(config);
                }).error(function () {
                    deferred.reject('Failed to refresh token');
                });
            }
            return deferred.promise;
        }
    };
});

secDemoApp.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');

});

angular.element(document).ready(function () {
    window._keycloak = Keycloak();

    secDemoApp.factory('keycloak', function ($window) {
        return $window._keycloak;
    });

    window._keycloak
        .init({
            onLoad: 'login-required'
        })
        .success(function () {

            angular.bootstrap(document, ['secDemoApp']);
        });

});

