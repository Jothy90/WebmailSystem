<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

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
            <a class="navbar-brand" href="#">kmail</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Kashing
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="login.jsp">Sign Out</a></li>
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
                    <a href="compose.jsp" class="btn btn-compose">
                        Compose Mail
                    </a>
                    <ul class="nav nav-pills nav-stacked mail-nav">
                        <li class="active"><a href="mail.html"> <i class="fa fa-inbox"></i> Inbox <span
                                class="label label-danger pull-right inbox-notification">9</span></a></li>
                        <li><a href="#"> <i class="fa fa-envelope-o"></i> Send Mail</a></li>
                        <li><a href="#"> <i class="fa fa-certificate"></i> Important</a></li>
                        <li><a href="#"> <i class="fa fa-file-text-o"></i> Drafts <span
                                class="label label-info pull-right inbox-notification">123</span></a></li>
                        <li><a href="#"> <i class="fa fa-trash-o"></i> Trash</a></li>
                    </ul>
                </div>
            </section>
        </div>
        <div class="col-sm-9">
            <section class="panel">
                <header class="panel-heading wht-bg">
                    <h4 class="gen-case">Inbox (34)
                        <form action="#" class="pull-right mail-src-position">
                            <div class="input-append">
                                <input type="text" class="form-control " placeholder="Search Mail">
                            </div>
                        </form>
                    </h4>
                </header>
                <div class="panel-body minimal">
                    <div class="mail-option">
                        <div class="chk-all">
                            <div class="pull-left mail-checkbox ">
                                <input type="checkbox" class="">
                            </div>

                            <div class="btn-group">
                                <a data-toggle="dropdown" href="#" class="btn mini all">
                                    All
                                    <i class="fa fa-angle-down "></i>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="#"> None</a></li>
                                    <li><a href="#"> Read</a></li>
                                    <li><a href="#"> Unread</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="btn-group">
                            <a data-original-title="Refresh" data-placement="top" data-toggle="dropdown" href="#"
                               class="btn mini tooltips">
                                <i class=" fa fa-refresh"></i>
                            </a>
                        </div>


                        <ul class="unstyled inbox-pagination">
                            <li><span>1-50 of 124</span></li>
                            <li>
                                <a class="np-btn" href="#"><i class="fa fa-angle-left  pagination-left"></i></a>
                            </li>
                            <li>
                                <a class="np-btn" href="#"><i class="fa fa-angle-right pagination-right"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="table-inbox-wrap ">
                        <table class="table table-inbox table-hover">
                            <tbody>
                            <tr class="unread">
                                <td class="inbox-small-cells">
                                    <input type="checkbox" class="mail-checkbox">
                                </td>
                                <td class="inbox-small-cells"><i class="fa fa-star"></i></td>
                                <td class="view-message  dont-show"><a href="mail_view.html">ABC Company</a></td>
                                <td class="view-message "><a href="mail_view.html">Lorem ipsum dolor imit set.</a></td>
                                <td class="view-message  inbox-small-cells"><i class="fa fa-trash-o"></i></td>
                                <td class="view-message  text-right">12.10 AM</td>
                            </tr>
                            </tbody>
                        </table>

                    </div>
                </div>
            </section>
        </div>
    </div>


    <!-- Main component for a primary marketing message or call to action -->


</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery-1.11.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>

<script src="resources/js/jquery.icheck.js"></script>


</body>
</html>

