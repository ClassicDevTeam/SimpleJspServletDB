<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new pet</title>
</head>
<body>

    <form method="POST" action='PetController' name="frmAddPet">  
    	<table>
    	<tr>
	    	<th>
	    		Name :
	    	</th>
	    	<th>
			    <input
	            type="text" name="Name"
	            value="<c:out value="${pet.petName}" />" /> 
	    	</th>
    	</tr>
    	<tr>
    		<th>
	    		Age :
	    	</th>
	    	<th>
		    	<input
	            type="text" name="Age"
	            value="<c:out value="${pet.age}" />" />
	    	</th>
    	</tr>
    	<tr>
    		<th>
	    		Owner :
	    	</th>
	    	<th>
		    	<input
	            type="text" name="Owner"
	            value="<c:out value="${pet.ownerName}" />" />
	    	</th>
    	</tr>
    	<tr>
    		<th>
	    		FavoriteFoodList :
	    	</th>
	    	<th>
		    	<input
	            type="text" name="favoritFoodList"
	            value="<c:out value="${pet.foodList}" />" />
	    	</th>
    	</tr>
    	<tr>
        	<th colspan=2> <input
            type="submit" value="Submit" /> </th>
        </tr>
    	</table>       	     
    </form>
</body>
</html>