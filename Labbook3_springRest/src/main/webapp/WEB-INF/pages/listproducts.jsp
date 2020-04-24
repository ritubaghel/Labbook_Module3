<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h2>Record of all Products</h2>
<table border="1">
<tr>
<th>
ProductId
</th>

<th>
ProductName
</th>

<th>
ProductPrice
</th>
</tr>
<c:forEach items="${products}" var="product">
<tr>
<td>Id is  <c:out value="${product.prodId}"/></td>
<td>Name is <c:out value="${product.prodName}"/></td>
<td>Price is  <c:out value="${product.prodPrice}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>