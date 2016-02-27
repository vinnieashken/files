<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SIGN IN</title>

        <link href="${pageContext.request.contextPath}/resources/template/css/style.default.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="signin">
    
        <section>
            
            <div class="panel panel-signin">
                <div class="panel-body">
                    <div class="logo text-center">
                        <!--img src="images/logo-primary.png" alt="Chain Logo" -->
						<h4 class="text-center mb5">FileShare</h4>
                    </div>
                    <br />
                    
                    <p class="text-center">Sign in to your account</p>
                    
                    <div class="mb30">
                    	<c:if test="${param.error != null}">
	      						<h4 class="text-center mb5">Invalid Credentials!</h4>
	   					</c:if>
	   					
	   					<h4 class="text-center mb5"></h4>		
                    </div>
                    
                    <form action="${pageContext.request.contextPath}/" method="post">
                        <div class="input-group mb15">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" name="username" placeholder="Username" required>
                        </div><!-- input-group -->
                        <div class="input-group mb15">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" name="password" placeholder="Password" required>
                        </div><!-- input-group -->
                        
                        <div class="clearfix">
                            <div class="pull-right">
                                <button type="submit" class="btn btn-success">Sign In <i class="fa fa-angle-right ml5"></i></button>
                            </div>
                        </div>                      
                    </form>
                    
                </div><!-- panel-body -->
                <div class="panel-footer">
                    <a href="${pageContext.request.contextPath}/register" class="btn btn-primary btn-block">Not yet a Member? Create Account Now</a>
                </div><!-- panel-footer -->
            </div><!-- panel -->
            
        </section>


        <script src="${pageContext.request.contextPath}/resources/template/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/modernizr.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/pace.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/retina.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery.cookies.js"></script>

        <script src="${pageContext.request.contextPath}/resources/template/js/custom.js"></script>

    </body>
</html>

