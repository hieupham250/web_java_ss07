<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chi tiết san phẩm</title>
</head>
<body>
<h2>Chi tiết sản phẩm</h2>
<img src="${product.image}" width="150"/>
<h3>${product.name}</h3>
<p>Giá: ${product.price}</p>
<p>Tồn kho: ${product.stock}</p>
<p>Mô tả: ${product.description}</p>
<a href="products">Quay lại danh sách</a>
</body>
</html>
