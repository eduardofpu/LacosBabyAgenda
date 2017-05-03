  'use strict';

angular.module('lacos')
  .service('HttpRequestSrv', function($http, ngNotify) {
    return function(url, method, data, callback) {
      var requestParams = {
        method: method,
        url: url,
        headers: { 'Content-Type': 'application/json' },
        data: data
      };

      $http(requestParams).then(
        function successCallback(response) {
        	
        callback && callback(response.data);
       
        },
        function errorCallback(response) {     
        	
       	 ngNotify.set('Atenção : ' + response.data.message+ '', 'error', { type: 'failure', duration: 9000 });
        // ngNotify.set('' + response.data.message+ '', 'error');
        // ngNotify.set('Error: ' + response.statusText + '.', 'error');
        });
    };
})
  .service('RestSrv', function(HttpRequestSrv) {
    var restFactory = {};
    
 // Aadd a new data.
    restFactory.add = function(url, data, callback) {
      HttpRequestSrv(url, 'POST', data, callback);
    };

    // Find all data.
    restFactory.find = function(url, callback) {
      HttpRequestSrv(url, 'GET', {}, callback);
    };
    
    restFactory.findCadastro = function(url,callback) {
        HttpRequestSrv(url, 'GET', {}, callback);
      };

    

    // Edit a data.
    restFactory.edit = function(url, data, callback) {
      HttpRequestSrv(url, 'PUT', data, callback);
    };

    // Delete a data.
    restFactory.delete = function(url, data, callback) {
      HttpRequestSrv(url, 'DELETE', data, callback);
    };

    return restFactory;



 

  });
