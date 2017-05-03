'use strict';

angular.module('lacos')
  .filter('formatPermission', function() {
    return function(input) {
      switch (input) {
        case 'ROLE_ADMIN':
          return 'Administrador';
        break;
        case 'ROLE_USER':
          return 'Usuario';
        break;
        
        case 'ROLE_VISITANTE':
            return 'Visitante';
          break;


        default:
          return 'Unknown';
        break;
      };


    };



  });
