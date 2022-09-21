<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

 <%session.setAttribute("londonmet_id",session.getAttribute("london_metId") ); %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <form name="emp" action="EmployeeMainServlet" onsubmit="return validate_form();" method="post" ENCTYPE="multipart/form-data" >
        <table align="center" width=40% width="100%" cellspacing="2" cellpadding="2" border="5">
            <tr>
                <td colspan="2" align="center"><b>UPDATE Form.</b></td>
 
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Employee Name<span style="color:red">*</span></td>
 
                <td width="57%"><input type="text" value="<c:out value="${employee.getEmployee_Name()}" />"  name="emp_name" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Citizen Number<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="text" value="${employee.getCitizen_Number()}" name="num" onkeypress="return isNumberKey(event)" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Address</td>
 
                <td width="57%"><textarea rows="4" maxlen="200" name="address"  cols="20">${employee.getAddress()}</textarea></td>
            </tr> <tr>
 
            <td align="left" valign="top" width="41%">Contact Number</td>
            <td width="57%">
                <input type="text" value="${employee.getContact_Number()}" onkeypress="return isNumberKey(event)" name="txtFName1" size="24"></td>
            </tr>
                <tr>
                <td align="left" valign="top" width="41%">Job Location</td>
                <td width="57%"><select name="JobLocation">
<option value="${category.id}"
                    <c:if test="${category.id eq selectedCatId}">selected="selected"</c:if>
                    >
                    ${category.name}
                </option>
 
</select></td>
 
           
            <tr>
                <td align="left" valign="top" width="41%">Email<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="text" value="${employee.getEmail()}" name="email_id" size="24"></td>
            </tr>
           
 
            <tr>
                <td colspan="2">
                    <p align="center">
                        <input type="submit" value="update" name="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="  Reset All   " name="B5"></td>
            </tr>
            
 
        </table>
    </form>
</body>

</html>