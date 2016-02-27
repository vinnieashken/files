
jQuery(document).ready(function(){
	
	
	
	function getAbsolutePath() {
	    var loc = window.location;
	    var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
	    return loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
	}
	
	
	$("#registerform").validate ({
    	
		rules:{
			username: {
					remote: contextPath + "/register/check/username"
                },
                email: {
					remote: contextPath + "/register/check/email"
                }
  		    
		},
		messages:{
			 username:{
				  remote: "That username is already taken"
			  },
			  email:{
				  remote: "That email is already taken"
			  },
			  
	      confirm:{
	    	  equalTo: "Please enter the same password"
	      }
		},
		
	     highlight: function(element) {
	          jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	      },
	      success: function(element) {
	          jQuery(element).closest('.form-group').removeClass('has-error');
	             
	      },
	         
	        submitHandler: function(form) {

	        	var t = $("#registerform").serialize();
	
	  		    $.ajax( {
	  				url: contextPath + '/doRegister/',
	  				data:t,
	  				type:'POST',
	  				success:function(data) {
	  			
	  					$("#registerform")[0].reset();
	  					location.href = getAbsolutePath();
	  				},
	  				error:function(e)
	  				{
	  					alert("error: "+ e);
	  				}
	  				});
	        }
    });
	
});