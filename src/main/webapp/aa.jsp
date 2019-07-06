<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 2019/7/2
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/file/upload" enctype="multipart/form-data" method="post" >
    文件:<input type="file" name="file"/>
    姓名:<input type="text" name="name"/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
