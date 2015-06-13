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
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-wysihtml5.css" />

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
                        <li><a href="inbox"> <i class="fa fa-inbox"></i> Inbox </a></li>
                        <li><a href="outbox"> <i class="fa fa-envelope-o"></i> Send Mail</a></li>
                        <li><a href="#"> <i class="fa fa-certificate"></i> Important</a></li>
                        <li><a href="#"> <i class="fa fa-file-text-o"></i> Drafts </a></li>
                        <li><a href="#"> <i class="fa fa-trash-o"></i> Trash</a></li>
                    </ul>
                </div>
            </section>
        </div>
        <div class="col-sm-9">
            <section class="panel">
                <header class="panel-heading wht-bg">
                    <h4 class="gen-case"> Compose Mail
                        <form action="#" class="pull-right mail-src-position">
                            <div class="input-append">
                                <input type="text" class="form-control " placeholder="Search Mail">
                            </div>
                        </form>
                    </h4>
                </header>
                <div class="panel-body">
                    <div class="compose-btn pull-right">
                        <button type="submit" class="btn btn-primary btn-sm" onclick="return submitIt()"><i class="fa fa-check"></i> Send</button>
                        <button class="btn btn-sm"><i class="fa fa-times"></i> Discard</button>
                        <button class="btn btn-sm">Draft</button>
                    </div>
                    <div class="compose-mail">
                        <form role="form-horizontal" method="post" action="sent">
                            <div class="form-group">
                                <label for="source" class="">To:</label>
                                <select class="form-control"  style="width: 300px" id="source">
                                    <c:forEach items="${emails}" var="name" varStatus="count">
                                    <option value="<c:out value="${count}"/>"><c:out value="${name}"/></option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="to" tabindex="1" id="to" class="form-control">

                                <div class="compose-options">
                                    <a onclick="$(this).hide(); $('#cc').parent().removeClass('hidden'); $('#cc').focus();" href="javascript:;">Cc</a>
                                    <a onclick="$(this).hide(); $('#bcc').parent().removeClass('hidden'); $('#bcc').focus();" href="javascript:;">Bcc</a>
                                </div>
                            </div>

                            <div class="form-group hidden">
                                <label for="cc" class="">Cc:</label>
                                <input type="text" tabindex="2" id="cc" class="form-control">
                            </div>

                            <div class="form-group hidden">
                                <label for="bcc" class="">Bcc:</label>
                                <input type="text" tabindex="2" id="bcc" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="subject" class="">Subject:</label>
                                <input type="text" name="subject" tabindex="1" id="subject" class="form-control">
                            </div>

                            <div class="compose-editor">
                                <textarea class="wysihtml5 form-control" name="body" rows="9"></textarea>
                                <%--<input type="file" class="default">--%>
                            </div>
                            <div class="compose-btn">
                                <button class="btn btn-primary btn-sm" type="submit" onclick="return submitIt()"><i class="fa fa-check"></i> Send</button>
                                <button class="btn btn-sm"><i class="fa fa-times"></i> Discard</button>
                                <button class="btn btn-sm">Draft</button>
                            </div>

                        </form>
                    </div>
                </div>
            </section>
        </div>
    </div>


<!-- Main component for a primary marketing message or call to action -->


</div>

<!--jQuery Flot Chart-->
<script type="text/javascript" src="resources/js/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-wysihtml5.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery-1.11.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>

<script src="resources/js/jquery.icheck.js"></script>

<script type="text/javascript">
    //wysihtml5 start

    $('.wysihtml5').wysihtml5();

    //wysihtml5 end
</script>
<script type="text/javascript">
    function submitIt(){
        var e = document.getElementById("source");
        var strUser = e.options[e.selectedIndex].text;
        document.getElementById("to").value=strUser;
        return true;
    }

</script>

</body>
</html>

