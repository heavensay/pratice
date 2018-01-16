<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>第三方oauth认证</title>
</head>
<body>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">实现第三方认证</h3>
    </div>
    <div class="panel-body">
        <p>
            <a href="#" th:href="@{/authenticate}" class="btn btn-large btn-success">请求授权</a>
        </p>
    </div>
</div>


</body>
</html>