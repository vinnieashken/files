

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
		url = contextPath + '/publicfiles/search';
		restParams.push({ "name" : "name", "value" : paramMap.sSearch});
	}

	//finally, make the request
	$.ajax({
		"dataType" : 'json',
		"type" : "GET",
		"url" : url,
		"data" : restParams,
		"success" : function(data) {
	
		fnCallback(data);
		
		}
	});
};
		
 table = $('#filestable').DataTable( {
        "processing": true,
        "serverSide": true,
        "bAutoWidth":false,
        "sAjaxSource": contextPath + '/publicfiles/list',
        "sAjaxDataProp" :'aaData',
        "aoColumns" : [
         {
            mDataProp : 'id'
            	
        }, 
        {
            mDataProp : 'name'
        } ,
        {
        	//"atargets": [4],
        	"mData":null,
        	"mRender": function (data, type, full) {
        	
                return '\
                <a href="'+contextPath+'/download/'+data.id+'" class="btn btn-xs btn-primary"><i class="glyphicon glyphicon-cloud-download"></i>Download</a>\
                ';
            }
        }
        
        ],
       
       "fnServerData" : datatabletoServer
    } );

 	$("#browser").addClass("active");
 	$("#browser > ul > #files").addClass("active");
	
});