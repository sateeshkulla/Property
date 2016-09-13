$(document).ready(function() {
		$(".login").click(function() {
				var email = $("#email").val();
				var password = $("#password").val();
					$.get("api/V1/property", function(data) {
						var tableHtml = "";
						$.each(data, function() {
							tableHtml += '<tr><td>' + this.name
									   + '</td><td>' + this.owner.firstName
									   + '</td><td>' + this.location.streetName
									   + '</td><td>' + this.location.zipCode
									   + '</td><td>' + this.availability
									   + '</td><td>' + this.pricing.monthlyRent
									  + '</td></tr>';
					    });
						$('#root').load("assets/mainpage.html"); 
						setTimeout(function(){
							 $('#propertylist').append(tableHtml);
						}, 1000);
					});
		});
});

$(document).on('click', '.addc', function(){
	$('#root').load("assets/property.html"); 
});

$(document).on('click', '.propertysave', function(){
	//$(".propertysave").click(function() {
	var datastring = $("#propertycreate").toDeepJson();
$.ajax({
        type: "POST",
        url: "api/V1/property",
        //dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(datastring),
        async: false,
        success: function(response) {
        	$('#root').load("assets/mainpage.html", function( response, status, xhr ) {
        		  if ( status == "error" ) {
        			    var msg = "Sorry but there was an error: ";
        			    alert(response);
        			    $( "#error" ).html( msg + xhr.status + " " + xhr.statusText );
        			  }
        			}); 
        },
        complete: function(response, textStatus) {
           console.log(textStatus);
          },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        },
    });
});

(function( $ ){
	  $.fn.toDeepJson = function() {
	    function parse(val){
	      if (val == ""){ return null; }
	      if (val == "true"){ return true; }
	      if (val == "false"){ return false; }
	      return val;
	    }
	    function toNestedObject(obj, arr){
	      var key = arr.shift();
	      if (arr.length > 0) {
	        obj[key] = toNestedObject(obj[key] || {}, arr);
	        return obj;
	      }
	      return key;
	    }
	    if (this.length == 1){
	      return $.makeArray(this[0].elements)
	      .filter(function(e){
	          return e.name != "" && (e.type == 'radio' ? e.checked : true);
	      })
	      .map(function(e){
	          var names = e.name.split('.');
	          if (e.type == 'checkbox') {
	            e.value = e.checked;
	          }
	          names.push(parse(e.value));
	          return names;
	      })
	      .reduce(toNestedObject, {});
	    } else {
	      throw({error:"Can work on a single form only"})
	    }
	  };

	  $.flatten = function (obj){
	    var ret = {}
	    for (var key in obj){
	      if (typeof obj[key] == 'object'){
	        var fobj = $.flatten(obj[key]);
	        for (var extkey in fobj){
	          ret[key+"."+extkey] = fobj[extkey];
	        }
	      } else {
	        ret[key] = String(obj[key]);
	      }
	    }
	    return ret;
	  }
	})( jQuery );