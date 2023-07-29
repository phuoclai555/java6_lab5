const app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
  var url = "http://localhost:8080/api/file/images";
  $scope.url = function (filename) {
    return `${url}/${filename}`;
  };

  $scope.list = function () {
    $http
      .get(url)
      .then((resp) => {
        $scope.filenames = resp.data;
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };
  $scope.list();

  $scope.delete = function (filename) {
    $http
      .delete(`${url}/${filename}`)
      .then((resp) => {
        $scope.list();
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };

  $scope.upload = function (files) {
    let form = new FormData();

    for (var i = 0; i < files.length; i++) {
      form.append("files", files[i]);
    }

    $http
      .post(url, form, {
        transformRequest: angular.identity,
        headers: { "Content-Type": undefined },
      })
      .then((resp) => {
        $scope.list();
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };
});
