<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Giỏ hàng</h2>
<a href="products">← Quay lại danh sách</a>

<table border="1" cellpadding="5">
    <tr>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Thành tiền</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="item" items="${cartItems}">
        <tr>
            <td>${item.product.name}</td>
            <td>${item.product.price}</td>
            <td>${item.quantity}</td>
            <td>${item.totalPrice}</td>
            <td>
                <a href="increase?id=${item.product.id}">Tăng</a>
                <a href="decrease?id=${item.product.id}">Giảm</a>
                <a href="remove?id=${item.product.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Tổng cộng: ${total}</h3>
</body>
</html>