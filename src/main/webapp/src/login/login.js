'use strict';

angular.module('lacos').controller('LoginCtrl',
		function($scope, LoginLogoutSrv) {

			
			
			
			$scope.login = function(email, password) {
				LoginLogoutSrv.login(email, password);
			};

			

		});
