'use strict';

angular.module('lacos')
  .controller('userPerCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH ) {

    $scope.m = {};
    $scope.ms = [];

    $scope.permissao = {};
    $scope.showAddEditUser = false;


    ngNotify.config({
      theme: 'pastel'
    });


    // Manage CRUD operations.
      var mUrl =  SERVICE_PATH.PRIVATE_PATH + '/userpermission';




    RestSrv.find(mUrl,function(data) {
      $scope.ms = data;
      ngNotify.set('Entrada com sucesso.', 'success');     


    });   



  


  });
