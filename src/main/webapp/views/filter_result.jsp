<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh mục: ${category}</h2>
<p>Màu: ${color}</p>
<p>Kích thước: ${size}</p>
<h3>Danh sách sản phẩm:</h3>
<ul>
    <c:forEach var="item" items="${products}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>