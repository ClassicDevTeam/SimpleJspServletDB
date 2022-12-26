<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
        	<tr>
        		<th colspan=4> Owner List </th>
        	</tr>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>PetList</th>
                <th>ShoppingCart</th>                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.getName()}" /></td>
                    <td><c:out value="${user.getAge()}" /></td>
                    <td><c:out value="${user.getPetListString()}" /></td>
                    <td><c:out value="${user.getShoppingCartString()}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UserController?action=insert">Add Owner</a></p>
    <p><a href="PetController?action=listPet">Pet</a></p>
	<p><a href="FoodController?action=listFood">Food</a></p>
</body>
</html>