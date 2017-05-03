'use strict';

angular.module('lacos')
  .controller('pedidoCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH ) {


  $scope.cliente = {};
  $scope.clientes = [];
  //   Tras os campos dos apartamentos cadastrados
  //  var apUrl =  SERVICE_PATH.PRIVATE_PATH + '/apartamento/ordenarapartamentos';
  var clienteUrl =  SERVICE_PATH.PRIVATE_PATH  + '/clientes';

 //Tras os campos apartamentos cadastrados ordenados


  RestSrv.find(clienteUrl,function(data) {
  $scope.clientes = data;
  ngNotify.set('Clientes conectado com sucesso.', 'success');
  });
  $scope.m = {};
  $scope.ms = [];
  $scope.permissao = {};
  $scope.permissions = [];
  $scope.showAddEditUser = false;
 
      
  
  ngNotify.config({
     theme: 'pastel'
   });



    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;

    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.m = {};
    };

    // Manage CRUD operations.
      var mUrl =  SERVICE_PATH.PRIVATE_PATH  + '/pedidos';




    $scope.editMorador = function(m) {

      $scope.m = angular.copy(m);
      $scope.show();
    };






      $scope.deletePedido = function(m) {

    
          RestSrv.delete(mUrl, m, function() {

              $scope.ms.splice($scope.ms.indexOf(m), 1);
              ngNotify.set('Pedido: \'' + m.valorTotal + '\' Excluido com sucesso.', 'success');

            });
         

      };




    $scope.saveMorador = function(m) {

      if (m.id ) {

        RestSrv.edit(mUrl, m, function() {



          for (var i = 0; i < $scope.ms.length; i++) {
            if ($scope.ms[i].id === m.id) { //=== verifica id e o objeto
              $scope.ms[i] = m;
            }
          }

          $scope.hide();// para esconder o forme
          ngNotify.set('Pedido: \'' + m.valorTotal + '\' Alterado com sucesso.', 'failure');


        });


      } else {


        RestSrv.add(mUrl, m, function(newMorador) {
        	
          $scope.ms.push(newMorador);
          $scope.hide();
          ngNotify.set('Pedido \'' + m.valorTotal + '\' added.', 'success');


        });
      }
    };
    
    
    


    RestSrv.find(mUrl,function(data) {
      $scope.ms = data;
      ngNotify.set('Entrada com sucesso.', 'success');




    });


    var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

      RestSrv.find(permissionUrl, function(data) {


          $scope.permissions = data;


   });


  });
