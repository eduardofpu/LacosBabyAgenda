'use strict';

angular.module('lacos')
  .controller('UserCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.user = {};
    $scope.users = [];
    $scope.permissions = [];
    $scope.showAddEditUser = false;

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
    var userUrl = SERVICE_PATH.PRIVATE_PATH + '/user';
    //var userUrl = SERVICE_PATH.PUBLIC_PATH  + '/user';


    $scope.updateLinkImage = function(file){
        var arq = file.split(',');
        $scope.user.mimeType = arq[0];
        $scope.user.file = arq[1];
    };


    $scope.editUser = function(user) {
      $scope.user = angular.copy(user);
      $scope.show();
    };


  	$scope.deleteUser = function(user) {


  	RestSrv.delete(userUrl, user, function() {
          $scope.users.splice($scope.users.indexOf(user), 1);
          ngNotify.set('Usuário \'' + user.name + '\' Deletado com sucesso.', 'success');
        });



  	};

    $scope.saveUser = function(user) {
      if (user.id) {
        RestSrv.edit(userUrl, user, function() {
          delete user.password;

          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) {
              $scope.users[i] = user;
            }
          }

          $scope.hide();
          ngNotify.set('Usuário: \'' + user.name + '\' Alterado com sucesso.', 'failure');
        });
      } else {
        RestSrv.add(userUrl, user, function(newUser) {
          $scope.users.push(newUser);
          $scope.hide();
          ngNotify.set('Usuário: \'' + user.email + '\' Salvo com sucesso.', 'success');
        });
      }
    };


    RestSrv.find(userUrl,function(data) {
      $scope.users = data;
      ngNotify.set('Entrada com sucesso.', 'success');


    });

    var permissionUrl =  SERVICE_PATH.PRIVATE_PATH  + '/permission';

    RestSrv.find(permissionUrl, function(data) {


        $scope.permissions = data;


 });


  });
