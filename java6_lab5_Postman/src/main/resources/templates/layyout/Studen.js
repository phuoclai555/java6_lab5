let host = "http://localhost:8080/rest";
const app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
  $scope.form = {};
  $scope.items = [];
  $scope.reset = function () {
    $scope.form = {};
    $scope.form.gender = 1;
    $scope.load_all();
  };
  $scope.load_all = function () {
    $scope.items = [];
    var url = `${host}/students`;
    $http
      .get(url)
      .then((resp) => {
        $scope.items = resp.data;
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };
  $scope.load_all();
  $scope.edit = function (email) {
    var url = `${host}/students/${email}`;
    $http
      .get(url)
      .then((resp) => {
        $scope.form = resp.data;
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };

  $scope.create = function () {
    var item = angular.copy($scope.form);
    var url = `${host}/students`;
    $http
      .post(url, item)
      .then((resp) => {
        $scope.load_all();
        $scope.reset();
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };

  $scope.update = function () {
    var item = angular.copy($scope.form);
    var url = `${host}/students/${$scope.form.email}`;

    $http
      .put(url, item)
      .then((resp) => {
        $scope.load_all();
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };
  $scope.delete = function (email) {
    var url = `${host}/students/${email}`;

    $http
      .delete(url)
      .then((resp) => {
        $scope.load_all();
        $scope.reset();
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("fail", error);
      });
  };

  $scope.import = function (files) {
    var reader = new FileReader();
    reader.onloadend = async () => {
      var workbook = new ExcelJS.Workbook();
      await workbook.xlsx.load(reader.result);
      const worksheet = workbook.getWorksheet("Sheet1");
      worksheet.eachRow((row, index) => {
        if (index > 1) {
          let gen;
          if (true && row.getCell(4).value) {
            gen = 1;
          } else {
            gen = 0;
          }

          let student = {
            email: row.getCell(1).value,
            fullname: row.getCell(2).value,
            marks: +row.getCell(3).value,
            gender: gen,
            country: row.getCell(5).value,
          };
          var url = `${host}/students`;
          $http
            .post(url, student)
            .then((resp) => {
              $scope.load_all();
              $scope.reset();
              console.log("Success", resp);
            })
            .catch((error) => {
              console.log("fail", error);
            });
        }
      });
    };
    reader.readAsArrayBuffer(files[0]);
  };
});
