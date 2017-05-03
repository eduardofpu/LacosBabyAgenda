'use strict';

angular.module('lacos')
  .service('httpRequestInterceptor', function ($q, $cookies,$location) {  
  return {
    request: function (config) {    	 
      config.headers['X-XSRF-TOKEN'] = $cookies.get('XSRF-TOKEN');     
      return config;
    },    
    responseError: function(rejection) {
        if (rejection.status === 401) {         	
        	$location.url('/error');         	
        	//$location.url('/login');
        	//$location.port();
        	//$location.host();
        	//$location.protocol();
        	//$location.path();
        	//$location.search();
        	//$location.hash();        	
        }
        return $q.reject(rejection);       
     }
   };  
});
