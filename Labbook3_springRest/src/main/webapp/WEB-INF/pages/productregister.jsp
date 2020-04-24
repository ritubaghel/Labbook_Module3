<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<form method="get" action="processregister">

<label>ProdId</label>
<div>
<input type="number" name="prodid">
</div>

<label>ProdName</label>
<div>
<input type="text" name="prodname">
</div>

<label>ProdPrice</label>
<div>
<input type="text" name="prodprice">
</div>

<input type="submit" value="Add product">

</form>
</body>
</html>
