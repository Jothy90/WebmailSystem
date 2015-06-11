<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from bucketadmin.themebucket.net/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 18 Oct 2014 09:19:39 GMT -->
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="images/favicon.html">

    <title>Login</title>

    <!--Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-reset.css" rel="stylesheet">
    <link href="resources/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/style-responsive.css" rel="stylesheet"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form method="post" class="form-signin" action="login">
        <h2 class="form-signin-heading">sign in now</h2>

        <div class="login-wrap">
            <div class="user-login-info">
                <input type="text" name="userName" class="form-control" placeholder="User Name" autofocus>
                <input type="password" name="password" class="form-control" placeholder="Password">
            </div>
            <button class="btn btn-lg btn-login btn-block" type="submit">Sign in</button>

            <div class="registration">
                Don't have an account yet?
                <a data-toggle="modal" href="#myModal">
                    Create an Account
                </a>
            </div>

        </div>
    </form>
    <form action="registerMe" class="form-signin" method="post">
        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal"
             class="modal fade">
            <div class="modal-dialog">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Create Account</h4>
                        </div>
                        <div class="modal-body">
                            <p>Enter your personal details below.</p>
                            <input type="text" name="firstName" placeholder="First Name" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                            <input type="text" name="lastName" placeholder="Last Name" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                            <input type="text" name="address" placeholder="Address" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                            <input type="text" name="mobile" placeholder="Mobile" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                            <input type="text" name="userName" placeholder="User Name" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                            <input type="password" name="password" placeholder="Password" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                            <input type="password" name="passwordRe" placeholder="Re-type Password" autocomplete="off"
                                   class="form-control placeholder-no-fix">

                        </div>
                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                            <button class="btn btn-success" type="submit">Submit</button>
                        </div>
                    </div>

            </div>
        </div>
    </form>
        <!-- modal -->



</div>


<!-- Placed js at the end of the document so the pages load faster -->

<!--Core js-->
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

</body>

<!-- Mirrored from bucketadmin.themebucket.net/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 18 Oct 2014 09:19:39 GMT -->
</html>