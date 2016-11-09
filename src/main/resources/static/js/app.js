var secDemoApp = angular.module('secDemoApp', []);

secDemoApp.controller('secController', function ($scope, $http) {

    $scope.greeting = {id: 'xxx', content: 'Hello World!'};
    $scope.comments= [];

    $scope.greet = function() {
        $scope.greeting.content += " more";
    };

    $scope.getComment = function() {
        $http.get('/api/comment').success(function (data) {
            $scope.comments = data;
        })
    };
});