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
<title>Add new user</title>
</head>
<body>

    <form method="POST" action='UserController' name="frmAddUser">
    	<table>
    	<tr>
	    	<th>
	    		Name :
	    	</th>
	    	<th>
			    <input
            type="text" name="Name"
            value="<c:out value="${user.Name}" />" /> 
	    	</th>
    	</tr>
    	<tr>
    		<th>
	    		Age :
	    	</th>
	    	<th>
		    	<input
            type="text" name="Age"
            value="<c:out value="${user.Age}" />" />
	    	</th>
    	</tr>
    	<tr>
    		<th>
	    		PetList :
	    	</th>
	    	<th>
		    	<input
            type="text" name="PetList"
            value="<c:out value="${user.PetList}" />" />
	    	</th>
    	</tr>
    	<tr>
    		<th>
	    		ShoppingCart :
	    	</th>
	    	<th>
		    	<input
            type="text" name="ShoppingCart"
            value="<c:out value="${user.ShoppingCart}" />" />
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