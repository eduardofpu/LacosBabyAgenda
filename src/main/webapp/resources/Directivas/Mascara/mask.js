'use strict';

angular.module('lacos')  //  <script src="js/jquery.mask.js"></script>

      .directive('mask',function() {
         return {
             restrict: 'A',
                  link: function postLink(scope,element,attrs) {

            element.mask(attrs.mask);

               }
          };
 });
