<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Foods</title>
</head>
<body>
    <table border=1>
        <thead>
        	<tr>
        		<th colspan=3> Food List </th>
        	</tr>
            <tr>
                <th>Name</th>
                <th>Produce Date</th>
                <th>Expired Date</th>                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${foods}" var="food">
                <tr>
                    <td><c:out value="${food.getFoodName()}" /></td>                    
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${food.getDoP()}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${food.getDoE()}" /></td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="FoodController?action=insert">Add Food</a></p>
    <p><a href="PetController?action=listPet">Pet</a></p>
	<p><a href="UserController?action=listUser">User</a></p>
</body>
</html>