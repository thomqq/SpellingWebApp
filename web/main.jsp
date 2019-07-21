<%--
  Created by IntelliJ IDEA.
  User: tkudas
  Date: 19.07.2019
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link href="css/main.css">
    <title>Spelling App</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 col-sm-12 blue d-flex justify-content-center align-items-center">
            <jsp:include page="${requestScope.get('header')}"/>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 col-sm-12 blue d-flex justify-content-center align-items-center">
            <jsp:include page="${requestScope.get('menu')}"/>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-sm-12 yellow d-flex justify-content-center align-items-center">
            <p>Content</p>
        </div>
        <div class="col-lg-4 col-sm-12 orange d-flex justify-content-center align-items-center">
            <p>Sidebar</p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 col-sm-12 lightblue d-flex justify-content-center align-items-center">
            <jsp:include page="${requestScope.get('footer')}"/>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
