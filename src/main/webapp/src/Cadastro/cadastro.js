'use strict';

angular.module('lacos')
  .controller('cadastroCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.user = {};
    $scope.users = [];

    $scope.permissao = {};
    $scope.permissions = [];
    $scope.showAddEditUser = false;

    ngNotify.config({
      theme: 'pastel'
    });

      $scope.msg = 'Para se cadastrar digite  os dados requeridos nos campos abaixo!'

    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.user = {};
    };

    // Manage CRUD operations.
    var userUrl =  SERVICE_PATH.PUBLIC_PATH + '/visitantes';

    $scope.updateLinkImageEdit = function(file){
        var arq = file.split(',');
        $scope.userEdit.mimeType = arq[0];
        $scope.userEdit.file = arq[1];
    };




    $scope.updateLinkImage = function(file){
        var arq = file.split(',');
        $scope.user.mimeType = arq[0];
        $scope.user.file = arq[1];
    };


    $scope.saveUser = function(user) {

      if (user.id ) {

        RestSrv.edit(userUrl, user, function() {
          delete user.password;

          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) { //=== verifica id e o objeto
              $scope.users[i] = user;
            }


          }
          $scope.hide();// para esconder o forme
          ngNotify.set('User \'' + user.name + '\' Editado com sucesso.', 'success');
        });


      } else {



        RestSrv.add(userUrl, user, function(newCadastro) {
          $scope.users.push(newCadastro);
          $scope.hide();
          ngNotify.set('User \'' + user.name + '\' Salvo com sucesso.', 'success');


        });
      }
    };



    RestSrv.find(userUrl,function(data) {
      $scope.users = data;
      ngNotify.set('Conectado com sucesso.', 'success');
    });


    // Request all data (permission and user).

   var permissionUrl =  SERVICE_PATH.PUBLIC_PATH   + '/permisvisit/findRole/ROLE_VISITANTE';
     RestSrv.findCadastro(permissionUrl, function(data) {
         $scope.permissions = data;
  });

  });
