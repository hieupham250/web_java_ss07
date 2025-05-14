<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="cart">🛒 Giỏ hàng</a>

<c:forEach var="p" items="${products}">
    <div style="border:1px solid gray; padding:10px; margin:10px;">
        <img src="${p.image}" width="150"/>
        <h3>${p.name}</h3>
        <p>Giá: ${p.price}</p>
        <p>Tồn kho: ${p.stock}</p>
        <form action="products/add-to-cart" method="post">
            <input type="hidden" name="id" value="${p.id}"/>
            Số lượng: <input type="number" name="quantity" min="1" value="1"/>
            <button type="submit">Thêm vào giỏ hàng</button>
        </form>
        <a href="details?id=${p.id}">Xem chi tiết</a>
    </div>
</c:forEach>
</body>
</html>
