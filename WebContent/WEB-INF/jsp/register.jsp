<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>CREATE ACCOUNT</title>

        <link href="${pageContext.request.contextPath}/resources/template/css/style.default.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/template/css/morris.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/template/css/select2.css" rel="stylesheet" />
        
         <script type="text/javascript">
			var contextPath="${pageContext.request.contextPath}";
		</script>
		
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="signin">
        
        
        <section>
            
            <div class="panel panel-signup">
                <div class="panel-body">
                    <div class="logo text-center">
                        <img src="images/logo-primary.png" alt="Chain Logo" >
                    </div>
                    <br />
                    <h4 class="text-center mb5">Create a new account</h4>
                    <p class="text-center">Please enter your credentials below</p>
                    
                    <div class="mb30"></div>
                    
                    <form id="registerform">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="input-group form-group mb15">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input type="text" class="form-control" placeholder="Enter Username" name="username" id="username" required>
                                    <span id="user-result"></span>
                                </div><!-- input-group -->
                            </div>
                            <div class="row">
                            <div class="col-sm-6">
                                <div class="input-group form-group mb15">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                    <input type="email" class="form-control" placeholder="Enter Email Address" name="email" required>
                                </div><!-- input-group -->
                            </div>
                        </div><!-- row -->
                        <br />
                            <div class="col-sm-6">
                                <div class="input-group form-group mb15">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input type="password" class="form-control" placeholder="Enter Password" name="password" id="password" required>
                                </div><!-- input-group -->
                            </div>
                            <div class="col-sm-6">
                                <div class="input-group form-group mb15">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input type="password" class="form-control" placeholder="Repeat Password" name="cpassword" id="confirm_password" required data-rule-equalTo="#password">
                                </div><!-- input-group -->
                            </div>
                        </div><!-- row -->
                        <br />
                        <div class="clearfix">
                            <div class="pull-left">
                                <div class="ckbox ckbox-primary mt5">
                                    <input type="checkbox" id="agree" value="1">
                                    <label for="agree">I agree with <a href="">Terms and Conditions</a></label>
                                </div>
                            </div>
                            <div class="pull-right">
                                <button type="submit" class="btn btn-success">Create New Account <i class="fa fa-angle-right ml5"></i></button>
                            </div>
                        </div>
                    </form>
                    
                </div><!-- panel-body -->
                <div class="panel-footer">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-primary btn-block">Already a Member? Sign In</a>
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
		
		<script src="${pageContext.request.contextPath}/resources/template/js/flot/jquery.flot.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/flot/jquery.flot.resize.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/flot/jquery.flot.spline.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/jquery.sparkline.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/morris.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/raphael-2.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/bootstrap-wizard.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/template/js/select2.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/template/js/jquery.validate.min.js"></script>

        <script src="${pageContext.request.contextPath}/resources/template/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/resources/custom/js/register.js"></script>


    </body>
</html>
    