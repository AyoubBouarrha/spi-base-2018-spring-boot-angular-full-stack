angular.module('spiApp')
  .factory('enseignantSvc', ['$http', function ($http) {
    var factory = {};

    factory.getEnseignants = function (callback) {
      var endPoint = "http://localhost:8090/enseignants"
      $http.get(endPoint).then(function (response) {
        callback(response.data);
      });
    }


    factory.saveEnseignant = function (enseignant, callback) {
      var endPoint = "http://localhost:8090/enseignants"
      $http.post(endPoint, enseignant).then(function (response) {
        callback(response.data);
      });
    }

    factory.getEnseignantById = function (idEnseignant, callback) {
      var endPoint = "http://localhost:8090/enseignants/" + idEnseignant
      $http.get(endPoint).then(function (response) {
        callback(response.data);
      });
    }


    factory.deleteEnseignantById = function (idEnseignant, callback) {
      var endPoint = "http://localhost:8090/enseignants/" + idEnseignant
      $http.delete(endPoint).then(function (response) {
        callback(response.data);
      });
    }

    factory.updateEnseignant = function (enseignant, callback) {
      var endPoint = "http://localhost:8090/enseignants/"
      $http.put(endPoint, enseignant).then(function (response) {
        callback(response.data);
      });
    }

    factory.getEnseignantsCount = function (callback) {
      var endPoint = "http://localhost:8090/enseignants/count"
      $http.get(endPoint).then(function (response) {
        callback(response.data);
      });
    }

    return factory;

  }])