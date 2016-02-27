
jQuery(document).ready(function(){
	
	
	var table;
	
    // data tables
	var datatabletoServer = function(sSource, aoData, fnCallback) {
 
 	//extract name/value pairs into a simpler map for use later
	var paramMap = {};
	
	for ( var i = 0; i < aoData.length; i++) {
		paramMap[aoData[i].name] = aoData[i].value;
	}
	
	//page calculations
	var pageSize = paramMap.iDisplayLength;
	var start = paramMap.iDisplayStart;
	var pageNum = (start == 0) ? 1 : Math.floor( (start / pageSize)) + 1; // pageNum is 1 based
	
	//alert("page size "+ pageSize);

	// extract sort information
	var sortCol = paramMap.iSortCol_0;
	var sortDir = paramMap.sSortDir_0;
	var sortName = paramMap['mDataProp_' + sortCol];

	//create new json structure for parameters for REST request
	var restParams = new Array();
	restParams.push({"name" : "page.size", "value" : pageSize + 1});
	restParams.push({"name" : "page.page", "value" : pageNum });
	restParams.push({"name" : "sort", "value" : sortName });
	restParams.push({"name" : sortName + ".dir", "value" : sortDir });

	//if we are searching by name, override the url and add the name parameter
	var url = sSource;
	if (paramMap.sSearch != '') {
		url = contextPath + '/userfiles/search/';
		restParams.push({ "name" : "name", "value" : paramMap.sSearch});
	}

	//finally, make the request
	$.ajax({
		"dataType" : 'json',
		"type" : "GET",
		"url" : url,
		"data" : restParams,
		"success" : function(data) {
		//data.iTotalRecords = data.totalCount;
		//data.iTotalDisplayRecords = data.totalCount;
			//alert("Data "+ data.aaData.names);
		fnCallback(data);
		
		}
	});
};
		
 table = $('#filestable').DataTable( {
        "processing": true,
        "serverSide": true,
        "bAutoWidth":false,
        "sAjaxSource": contextPath + '/userfiles/list/',
        "sAjaxDataProp" :'aaData',
        "aoColumns" : [
         {
            mDataProp : 'id'
            	
        }, 
        {
            mDataProp : 'name'
        } , 
        {
            mDataProp : 'visible'
        }, 
        {
        	//"atargets": [4],
        	"mData":null,
        	"mRender": function (data, type, full) {
        	
                return '\
                <div class="btn-group">\
                <button type="button" class="btn btn-xs btn-primary">Actions</button>\
                <button type="button" class="btn btn-xs btn-primary dropdown-toggle" data-toggle="dropdown">\
                  <span class="caret"></span>\
                  <span class="sr-only">Toggle Dropdown</span>\
                </button>\
                <ul class="dropdown-menu pull-right" role="menu">\
                  <li><a href="'+contextPath+'/download/'+data.id+'" >Download</a></li>\
                  <li><a href="#" id="publicize">Publicize</a></li>\
                  <li><a href="#" id="privatize">Privatize</a></li>\
                  <li class="divider"></li>\
                  <li><a href="#" id="delete">Delete</a></li>\
                </ul>\
                </div>';
            }
        }
        
        ],
       
       "fnServerData" : datatabletoServer
    } );
 
  	//file actions
 	$('#filestable tbody').on( 'click', '#publicize', function () {
 		var rdata = table.row( $(this).parents('tr') ).data();
 		if(confirm("Are you sure you want to make this file visible to all users?"))
     	{
	        	$.ajax({
					//"dataType" : 'json',
					"type" : "POST",
					"url" : contextPath + '/status/'+rdata.id,
					"data" : null,
					"success" : function(data) {
						table.ajax.reload();
					},
					"error":function(jqXHR,textStatus,error)
					{
						alert("An error occured while processing the file "+ jqXHR.status+" " + textStatus);
					}
				});
     	}
 		else
     	{
     		return false;
     	}
     
	} );
 	
 	$('#filestable tbody').on( 'click', '#privatize', function () {
 		var rdata = table.row( $(this).parents('tr') ).data();
 		if(confirm("Are you sure you want to make this file private?"))
     	{
	        	$.ajax({
					//"dataType" : 'json',
					"type" : "POST",
					"url" : contextPath + '/status/'+rdata.id,
					"data" : null,
					"success" : function(data) {
						table.ajax.reload();
					},
					"error":function(jqXHR,textStatus,error)
					{
						alert("An error occured while processing the file "+ jqXHR.status+" " + textStatus);
					}
				});
     	}
 		else
     	{
     		return false;
     	}
     
	} );
 	
 	$('#filestable tbody').on( 'click', '#delete', function () {
 		var rdata = table.row( $(this).parents('tr') ).data();
 		if(confirm("Are you sure you want to delete this file?"))
     	{
	        	$.ajax({
					//"dataType" : 'json',
					"type" : "POST",
					"url" : contextPath + '/delete/'+rdata.id,
					"data" : null,
					"success" : function(data) {
						table.ajax.reload();
					},
					"error":function(jqXHR,textStatus,error)
					{
						alert("An error occured while deleting the file "+ jqXHR.status+" " + textStatus);
					}
				});
     	}
 		else
     	{
     		return false;
     	}
     
	} );
 	
 	

 	$("#browser").addClass("active");
 	$("#browser > ul > #userfiles").addClass("active");
	
});