var secDemoApp = angular.module('secDemoApp', []);

secDemoApp.controller('secController', function ($scope, $http, keycloak) {

    $scope.comments= [];
    $scope.user = {
        name: 'ahh',
        isUser: false,
        isAdmin: false
    };
    $scope.isTokenExpired = keycloak.isTokenExpired;
    $scope.token = keycloak.token;

    $scope.getComment = function() {
        $http.get('/api/comment').success(function (data) {
            $scope.comments = data;
        })
    };

    $scope.logout = function() {
        keycloak.logout();
    };

    $scope.deleteComment = function (id) {
        $http.delete("/admin/comment/" + id)
            .then(function successCallback(response) {
                $scope.getComment();
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

// use bearer token when calling backend
secDemoApp.config(['$httpProvider', function($httpProvider) {
    var token = window._keycloak.token;
    $httpProvider.defaults.headers.common['Authorization'] = 'BEARER ' + token;
}]);


angular.element(document).ready(function() {
    window._keycloak = Keycloak();

    secDemoApp.factory('keycloak', function($window) {
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

