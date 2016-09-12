$(document).ready(function() {
		$(".login").click(function() {
				var email = $("#email").val();
				var password = $("#password").val();
					$.get("api/V1/property", function(data) {
						var tableHtml = "";
						$.each(data, function() {
							tableHtml += '<tr><td>' + this.name 
									//  + '</td><td>' + this.content 
									 // + '</td><td>' + this.UID 
									  //+ '</td><td>' + this.content 
									  //+ '</td><td>' + this.content 
									  //+ '</td><td>' + this.content 
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
	var datastring = $("#propertycreate").serializeArray();
	var rawData = {};
    $.each(datastring, function() {
        if (rawData[this.name] !== undefined) {
            if (!rawData[this.name].push) {
            	rawData[this.name] = [o[this.name]];
            }
            rawData[this.name].push(this.value || '');
        } else {
        	rawData[this.name] = this.value || '';
        }
    });
$.ajax({
        type: "POST",
        url: "api/V1/property",
        //dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(rawData),
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


