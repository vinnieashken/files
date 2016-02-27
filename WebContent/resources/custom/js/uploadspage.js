jQuery(document).ready(function(){
	
	$('#filedropzone').dropzone({ 
	    url: contextPath + "/upload",
	    maxFilesize: 100,
	    paramName: "fileUpload",
	    maxThumbnailFilesize: 5,
	    init: function() {
	      
	      this.on('success', function(file, json) {
	      });
	      
	      this.on('addedfile', function(file) {
	        
	      });
	      
	      this.on('drop', function(file) {
	        alert('file');
	      }); 
	    }
	  });
	
	$("#uploader").addClass("active");
	
});