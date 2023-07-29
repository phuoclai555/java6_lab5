var app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
  $scope.reset = function () {
    $scope.form = { gender: true, country: "VN" };
    $scope.key = null;
  };
  $scope.load_all = function () {
    var url = `${host}/students`;
    $http
      .get(url)
      .then((resp) => {
        $scope.items = resp.data;
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };
  $scope.import = function (files) {
    console.log(files[0]);
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
          console.log(student);
          var url = "http://localhost:8080/rest/students";
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
