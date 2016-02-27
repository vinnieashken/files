<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<div class="media profile-left">
 
                       
</div>
<h5 class="leftpanel-title" >Navigation</h5>
    <ul class="nav nav-pills nav-stacked" id="sidenav">
    				
		<li class="" id="uploader"><a href="${pageContext.request.contextPath}/uploads"><i class="glyphicon glyphicon-cloud-upload"></i> <span>UPLOADER</span></a></li>
 		
 		<li class="parent" id="browser"><a href=""><i class="glyphicon glyphicon-folder-open"></i> <span>BROWSER</span></a>
      		<ul class="children">
          		<li id="userfiles"><a href="${pageContext.request.contextPath}/myfiles">My files</a></li>
          		<li id="files"><a href="${pageContext.request.contextPath}/publicfiles">Public files</a></li>                  
           </ul>
 		</li>
</ul>
