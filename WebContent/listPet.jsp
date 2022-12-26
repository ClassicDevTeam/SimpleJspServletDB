<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Pets</title>
</head>
<body>
    <table border=1>
        <thead>
        	<tr>
        		<th colspan=4> Pet List </th>
        	</tr>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Owner</th>
                <th>FavoritFoodList</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pets}" var="pet">
                <tr>
                    <td><c:out value="${pet.getPetName()}" /></td>
                    <td><c:out value="${pet.getAge()}" /></td>
                    <td><c:out value="${pet.getOwner()}" /></td>
                    <td><c:out value="${pet.getFavoriteFoodListString()}" /></td>                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="PetController?action=insert">Add Pet</a></p>
    <p><a href="UserController?action=listUser">Owner</a></p>
	<p><a href="FoodController?action=listFood">Food</a></p>
</body>
</html>