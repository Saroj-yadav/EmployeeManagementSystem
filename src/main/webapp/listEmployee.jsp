<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="EUCKR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>LIST ALL EMPLOYEE </title>
</head>
<body>
	


 <table border=1>
 <thead>
 <tr>
 <th>Name</th>
 <th>CitizenNUmber</th>
 <th>Address</th>
 <th>ContactNumber</th>
 <th>JOBLOcation</th>
 <th>Desigination</th>
  <th>Email</th>
 
 <th colspan=2>Action</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items="${employeeList}" var="employee">
 <tr>
 <td><c:out value="${employee.getEmployee_Name()}" /></td>
 <td><c:out value="${employee.getCitizen_Number()}" /></td>
 <td><c:out value="${employee.getAddress()}" /></td>
 <td><c:out value="${employee.getContact_Number()}" /></td>
 <td><c:out value="${employee.getJob_Location()}" /></td>
 <td><c:out value="${employee.getDesignation()}" /></td>
 <td><c:out value="${employee.getEmail()}" /></td>


 
 <td><a href="EmployeeMainServlet?parm=edit&londonmet_id=<c:out
value="${employee.getId()}"/>">Update</a></td>
 <td><a href="EmployeeMainServlet?parm=delete&londonmet_id=<c:out
value="${employee.getId()}"/>">Delete</a></td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 
</body>
</html>