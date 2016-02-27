<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="ashken">

        <title>MY FILES</title>

        <link href="${pageContext.request.contextPath}/resources/template/css/style.default.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/template/css/morris.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/template/css/select2.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/resources/template/css/style.datatables.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        
        <script type="text/javascript">
			var contextPath="${pageContext.request.contextPath}";
		</script>
    </head>

    <body>
		<header>
			<div class="headerwrapper">
				<div class="header-left">
                    <a href="index.html" class="logo">
                        <!--img src="images/logo.png" alt="" /--> 
                    </a>
                    <div class="pull-right">
                        <a href="" class="menu-collapse">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div>
                </div><!-- header-left -->
				
				<div class="header-right">
					<div class="pull-right">
					    
						<div class="btn-group btn-group-option">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                              <i class="fa fa-caret-down"></i>
                            </button>
                            <ul class="dropdown-menu pull-right" role="menu">
                              <li><a href="${pageContext.request.contextPath}/settingspage"><i class="glyphicon glyphicon-cog"></i> Settings</a></li>
                              <li class="divider"></li>
                              <li><a href="${pageContext.request.contextPath}/logout"><i class="glyphicon glyphicon-log-out"></i>Sign Out</a></li>
                            </ul>
                        </div><!-- btn-group -->
                        
					</div><!-- pull-right -->
				</div><!-- header-right -->
			
			</div><!-- header-wrapper -->
		</header>
        
		<section>
			<div class="mainwrapper">
				<div class="leftpanel">
					<jsp:include page="usersidemenu.jsp" />
				</div><!--left-panel-menu-->
				
				<div class="mainpanel">
						
					<div class="contentpanel">
						<div class="row row-stat">
							<div class="col-md-12">
								
							<div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">Change your password</h4>
                            </div>
                            <div class="panel-body">
                              <div class="col-md-4 col-md-offest-4">
                                <form id="passwordsform">
	                        		<div class="input-group form-group mb15">
	                            		<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                            		<input type="password" class="form-control" name="password" placeholder="Type new password" required id="password">
	                        		</div><!-- input-group -->
	                        		<div class="input-group form-group mb15">
	                            		<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                            		<input type="password" class="form-control" name="confirm" placeholder="Repeat your new password" required data-rule-equalTo="#password">
	                        		</div><!-- input-group -->
                        
	                        		<div class="clearfix">
		                            	<div class="pull-right">
		                                	<button type="submit" class="btn btn-primary">Change </button>
		                            	</div>
	                        		</div>                      
                   				 </form>
                   				 </div>
                            </div><!-- panel-body -->
                        </div><!-- panel -->
							</div>
						</div>
						
					   
					</div><!--content-panel -->
				</div><!--mainpanel-->
			</div><!--mainwrapper-->
		</section>
		
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/modernizr.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/pace.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/retina.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery.cookies.js"></script>
		
		<script src="${pageContext.request.contextPath}/resources/template/js/flot/jquery.flot.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/flot/jquery.flot.resize.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/flot/jquery.flot.spline.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery.sparkline.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/morris.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/raphael-2.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/bootstrap-wizard.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/select2.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/template/js/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/template/js/jquery.dataTables.min.js"></script>
		
        <script src="${pageContext.request.contextPath}/resources/template/js/custom.js"></script>
		<script src="${pageContext.request.contextPath}/resources/custom/js/settings.js"></script>

    </body>
</html>

