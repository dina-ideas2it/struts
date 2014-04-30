'use strict';

gaApp.directive('contactFinder', function($rootScope, $compile) {
    return {
        restrict : 'A',
        controller : function($scope, ContactService) {
        	$scope.enteredContact =[];
        	$scope.enteredContactId =[];
        	$scope.enteredText ="";
            $scope.getContactInfo = function(searchParam, inputId , splitedString) {
            	ContactService.search.searchContacts({
                	userId : $rootScope.user.id,
                	userName : searchParam
                }, function(data) {
                	var responseDate = angular.fromJson(angular.toJson(data));
                	$scope.contacts=responseDate;
                }, function(err) {
                    console.log('Error');
                });
            };
            $scope.traverseSuggestionList = function($event){
            	var keyCode = $event.keyCode;
            	if(getSuggestion(keyCode, $scope.suggestionSpanId)){
            		console.log($('#'+$scope.suggestionSpanId+' ul li.selected'));
            		var suggesstionResult = $scope.$eval($('#'+$scope.suggestionSpanId+' ul li.selected').attr('selected-suggestion'));
            		console.log(suggesstionResult);
            	}
            }
        },
        link : function($scope, element, iAttrs) {
            $scope.$watch(function() {
            	return $scope.$eval(iAttrs.ngModel);
            }, function(newvalue) {
            	alert(newvalue);
            	if (newvalue != undefined) {
            		if(iAttrs.suggestion == "yes"){
            			console.log(newvalue);
            			if(newvalue.indexOf(" with ") > -1){
                			var newString =newvalue.substring(newvalue.indexOf(" with ")+6,newvalue.length);
                			var splitedString = newvalue.substring(0,newvalue.indexOf(" with ")+6);
                			$scope.getContactInfo(newString, iAttrs.id,splitedString);
                		}
            		}
            		else if(iAttrs.suggestion == "no"){
            			
            		}
            		
                }
            }, true);
        },
    };
});

gaApp.directive('myCustomer', function() {
	return {
	       template : '<ul class="list-group padding-left-7_5"><li selected-suggestion={{contact}} ng-click="getselectedSuggestionDetails(contact)" class="list-group-item link list-group-contact border-top-none border-right-none border-bottom-none padding-right-clear border-radius-none padding-left-7_5 border-left-none" style="background-color:F2F2F2;" ng-repeat="contact in suggestionList" ><a href="#" class="pull-left m-r-sm"> <img src="/images/avatar-orange.png" height="50" width="50" class="background-image img-curve-sm">	<p class="overlay-text left-20">{{contact.firstLast}}</p> </a><a class="clear align-contact-list"><mediumText class="block top-2 pos-rel line-height-09"><img src="/images/avatar-online.png" height="10" width="10"/>{{contact.name}}</mediumText><subtitle class="full-width pull-left font-size-12 pos-rel top-4 line-height-09">{{contact.email}}</subtitle><subtitle class="font-size-12 pos-rel top-4">	Registered in Groupagendas</subtitle> </a></li></ul>',
	       controller : function($scope, ContactService) {
	        	$scope.getselectedSuggestionDetails = function(suggestionId){
	        		alert(suggestionId);
	        	};
	        },
	       link : function($scope, element, iAttrs) {
	    	   $scope.suggestionList=[];
	    	   $scope.suggestionSpanId = iAttrs.id;
	    	   $scope.$watch(iAttrs.suggestionList, function(value) {
	   			var val = value || null;
	   			if (val) {
	   				$scope.suggestionList = $scope.$eval(iAttrs.suggestionList);
	   				console.log($scope.suggestionList);
	   			}
	   		});
	        },
	    };
    });
function getSuggestion(key, suggestionSpanId){
	console.log(suggestionSpanId);
	    if (key == 40 || key == 38) {
	    	if ($('#'+suggestionSpanId+' ul li').hasClass("selected")) {
	            var sel = $("#"+suggestionSpanId+" ul li.selected");

	            sel.removeClass('selected');
	            // check if this is a last element in the list
	            // if so then add selected class to the first element in the list
	            if (key == 40) {
	                if (sel.next().length == 0) {
	                    $("#"+suggestionSpanId+" ul li:first").addClass("selected");
	                } else {
	                    sel.next().addClass('selected');
	                    // remove class selected from previous item
	                }
	            } else {
	                if (sel.prev().length == 0) {
	                    $("#"+suggestionSpanId+" ul li:last").addClass("selected");
	                } else {
	                    sel.prev().addClass('selected');
	                    // remove class selected from previous item
	                }
	            }
	        } else {
	            $("#"+suggestionSpanId+" ul li:first").addClass("selected");
	        }
	    	return false;
	    }else if(key == 13){
	    	return true;
	    }
	   
	
}








