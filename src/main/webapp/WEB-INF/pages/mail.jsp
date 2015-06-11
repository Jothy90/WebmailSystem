<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>kmail</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="resources/js/html5shiv.js"></script>
    <script src="resources/js/respond.min-1.4.2.js"></script>

    <!--icheck-->
    <link href="resources/css/minimal.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/style3860.css?v=1" rel="stylesheet">
    <link href="resources/css/style-responsive.css" rel="stylesheet"/>


    <link href="resources/css/bootstrap-reset.css" rel="stylesheet">
    <link href="resources/css/font-awesome.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/style-responsive.css" rel="stylesheet"/>

</head>

<body style="margin-top:60px">


<!-- Fixed navbar -->
<div id="dic_bubble" class="selection_bubble fontSize13 noSelect"
     style="z-index: 9999; border: 1px solid rgb(74, 174, 222); visibility: hidden;"></div>
<div class="navbar navbar-default  navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="inbox">kmail</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.userName}
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="logout">Sign Out</a></li>
                        <li class="divider"></li>
                        <li><a href="#">About kmail</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
<!-- /Fixed navbar -->


<div class="container">
<div class="row"><br/><br/><br/></div>


    <div class="row">
        <div class="col-sm-3">
            <section class="panel">
                <div class="panel-body">
                    <a href="compose"  class="btn btn-compose">
                        Compose Mail
                    </a>
                    <ul class="nav nav-pills nav-stacked mail-nav">
                        <li class="active"><a href="inbox"> <i class="fa fa-inbox"></i> Inbox  <span class="label label-danger pull-right inbox-notification">9</span></a></li>
                        <li><a href="outbox"> <i class="fa fa-envelope-o"></i> Send Mail</a></li>
                        <li><a href="#"> <i class="fa fa-certificate"></i> Important</a></li>
                        <li><a href="#"> <i class="fa fa-file-text-o"></i> Drafts <span class="label label-info pull-right inbox-notification">123</span></a></li>
                        <li><a href="#"> <i class="fa fa-trash-o"></i> Trash</a></li>
                    </ul>
                </div>
            </section>
        </div>
        <div class="col-sm-9">
            <section class="panel">
                <header class="panel-heading wht-bg">
                    <h4 class="gen-case"> View Message
                        <form action="#" class="pull-right mail-src-position">
                            <div class="input-append">
                                <input type="text" class="form-control " placeholder="Search Mail">
                            </div>
                        </form>
                    </h4>
                </header>
                <div class="panel-body ">

                    <div class="mail-header row">
                        <div class="col-md-8">
                            <h4 class="pull-left"> ${email.subject} </h4>
                        </div>
                        <div class="col-md-4">
                            <div class="compose-btn pull-right">
                                <a href="mail_compose.html" class="btn btn-sm btn-primary" ><i class="fa fa-reply"></i> Reply</a>
                                <button class="btn  btn-sm tooltips" data-original-title="Print" type="button" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-print"></i> </button>
                                <button class="btn btn-sm tooltips" data-original-title="Trash" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-trash-o"></i></button>
                            </div>
                        </div>

                    </div>
                    <div class="mail-sender">
                        <div class="row">
                            <div class="col-md-8">
                                <c:choose>
                                    <c:when test="${email.sendTo==user.userName}">
                                        <strong> ${email.sendFrom}</strong>
                                        to
                                        <strong>me</strong>
                                    </c:when>
                                    <c:otherwise>
                                        <strong>me</strong>
                                        to
                                        <strong>${email.sendTo}</strong>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-md-4">
                                <p class="date"> ${email.date}</p>
                            </div>
                        </div>
                    </div>
                    <div class="view-mail">
                        <p> ${email.message}</p>
                    </div>
                    <div class="compose-btn pull-left">
                        <a href="mail_compose.html" class="btn btn-sm btn-primary" ><i class="fa fa-reply"></i> Reply</a>
                        <button class="btn btn-sm " ><i class="fa fa-arrow-right"></i> Forward</button>
                        <button class="btn  btn-sm tooltips" data-original-title="Print" type="button" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-print"></i> </button>
                        <button class="btn btn-sm tooltips" data-original-title="Trash" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-trash-o"></i></button>
                    </div>
                </div>
            </section>
        </div>
    </div>


</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery-1.11.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>

<script src="resources/js/jquery.icheck.js"></script>



</body>
</html>

