<html>
 
<head>
 
    <title>Registration Form</title>
 
    <script type="text/javascript">
        function validate_form() {
            if (document.emp.emp_name.value == "") {
                alert("Please fill in the 'Your Employee Name' box.");
                return false;
            }
            if (document.emp.num.value == "") {
                alert("Enter citizen Number");
                return false;
            }
            
 
 
 
            if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(document.emp.email_id.value)) {
                alert("You have entered an invalid email address!")
                return (false)
            }
        }
 
        function isNumberKey(evt) {
            var charCode = (evt.which) ? evt.which : event.keyCode;
            if (charCode != 46 && charCode > 31 &&
                (charCode < 48 || charCode > 57)) {
                alert("Enter Number");
                return false;
            }
            return true;
        }
 
 
        //-->
    </script>
 
</head>
 
<body bgcolor="#FFFFFF">
    <form name="emp" action="EmployeeMainServlet" onsubmit="return validate_form();" method="post" ENCTYPE="multipart/form-data" >
        <table align="center" width=40% width="100%" cellspacing="2" cellpadding="2" border="5">
            <tr>
                <td colspan="2" align="center"><b>Employee Registration Form.</b></td>
 
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Employee Name<span style="color:red">*</span></td>
 
                <td width="57%"><input type="text"  name="emp_name" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Citizen Number<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="text" value="" name="num" onkeypress="return isNumberKey(event)" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Address</td>
 
                <td width="57%"><textarea rows="4" maxlen="200" name="address" cols="20"></textarea></td>
            </tr> <tr>
 
            <td align="left" valign="top" width="41%">Contact Number</td>
            <td width="57%">
                <input type="text" value="" onkeypress="return isNumberKey(event)" name="txtFName1" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Job Location</td>
                <td width="57%"><select name="JobLocation">
<option value="Default">Default</option>
<option value="Kathmandu">Kathmandu</option>
<option value="Pokhara">Pokhara</option>
<option value="Butwal">Butwal</option>
<option value="Biratnagar">Biratnagar</option>
<option value="Hetuda">Hetuda</option>
 
</select></td>
 
 
            </tr>
 
            <tr>
                <td align="left" valign="top" width="41%">Designation</td>
                <td width="57%">
                    <select name="Designation">
<option value="Default">Default</option>
<option value="Systems Engineer">Systems Engineer</option>
<option value="Senior Systems Engineer">Senior Systems Engineer</option>
<option value="Technology Analyst">Technology Analyst</option>
<option value="Technology Lead">Technology Lead</option>
<option value="Project Manager">Project Manager</option>
 
 
</select></td>
 
 
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Email<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="text" value="" name="email_id" size="24"></td>
            </tr>
             <tr>
                <td align="left" valign="top" width="41%">Password<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="password" value="" name="Password" size="24"></td>
            </tr>
             <tr>
                <td align="left" valign="top" width="41%">UPLOAD IMAGE<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="file" value="" name="image" size="24"></td>
            </tr>
 
            <tr>
                <td colspan="2">
                    <p align="center">
                        <input type="submit" value="insert" name="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="  Reset All   " name="B5"></td>
            </tr>
            
 
        </table>
    </form>
</body>
 
</html>