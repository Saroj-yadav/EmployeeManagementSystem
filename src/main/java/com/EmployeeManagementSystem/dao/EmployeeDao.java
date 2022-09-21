package com.EmployeeManagementSystem.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.EmployeeManagementSystem.model.Employee_Detail;


public class EmployeeDao {
	/*
	 * private static final String
	 * dbUrl="jdbc:mysql://localhost:3306/employeemangementsystem"; private static
	 * final String dbUsername="root"; private static final String
	 * dbPassword="root";
	 */
private static final String INSERT_EMPLOYEE_RECORD="insert into employee_record values(?,?,?,?,?,?,?,?,?,?)";
private static final String VIEW_ALL_EMPLOYEE="select * from employee_record";
private static final String UPDATE_EMPLOYEE="update employee_record set name=?,Citizen_Number=?,"
		+ "Address=?,Contact_Number=?,Email=? where London_MetId=?";
private static final String DELETE_EMPLOYEE="delete from employee_record where London_MetId=?";
private static final String ROW_COUNT="select count(*) from employee_record";
private static String lastInsertId;
private Connection con=DatabaseConnectivity.getDatabaseConeection();
/*
 * public static Connection getDatabaseConeection() { Connection
 * connection=null;
 * 
 * 
 * try {
 * 
 * Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().
 * newInstance();
 * connection=DriverManager.getConnection(dbUrl,dbPassword,dbPassword);
 * 
 * } catch (InstantiationException | IllegalAccessException |
 * IllegalArgumentException | InvocationTargetException | NoSuchMethodException
 * | SecurityException | ClassNotFoundException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } catch (SQLException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * 
 * return connection; }
 */
private void addEmployee(Employee_Detail employee,String london_MetId)
{
	
	try {
		
		//Connection con=getDatabaseConeection();
		System.out.println("Hello");
		PreparedStatement insertStatement;
		insertStatement = con.prepareStatement(INSERT_EMPLOYEE_RECORD);
		insertStatement.setString(1, london_MetId);
		insertStatement.setString(2,employee.getEmployee_Name());
		insertStatement.setLong(3, employee.getCitizen_Number());
		insertStatement.setString(4, employee.getAddress());
		insertStatement.setLong(5, employee.getContact_Number());
		insertStatement.setString(6,employee.getJob_Location() );
		insertStatement.setString(7,employee.getDesignation());
		insertStatement.setString(8, employee.getEmail());
		insertStatement.setString(9, employee.getPassword());
		insertStatement.setString(10, employee.getImage());
		insertStatement.executeUpdate();
		PreparedStatement st=con.prepareStatement("select London_MetId from employee_record where London_MetId=(select max(London_MetId) from employee_record)");
		
		ResultSet res=st.executeQuery();
		  while(res.next()) { 
			 lastInsertId=res.getString(1);
			  employee.setId(lastInsertId);
		  
		  }
		  employee.setId(london_MetId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void insertEmployeeToDatabase(Employee_Detail employee)
{
	
	try {
		//Connection con1=getDatabaseConeection();
		//PreparedStatement rowCountStatement=con1.prepareStatement(ROW_COUNT);
		PreparedStatement rowCountStatement=con.prepareStatement(ROW_COUNT);
		ResultSet rowCountResultsSet=rowCountStatement.executeQuery();
		rowCountResultsSet.next();
		int rowCountValue=rowCountResultsSet.getInt(1);
		if(rowCountValue==0)
		{
			
			this.addEmployee(employee,employee.getId());
			
		}
		else
		{
			
			 
			   //String lastInsertId=employee.getId();
			
			  String partialString=lastInsertId.substring(0, 7); 
		int x=Integer.valueOf(lastInsertId.substring(7, 10));
			 
			 x=x+1;
				
				  String updatedlondon_metId=partialString+x;
				 
				 
				 
			this.addEmployee(employee,updatedlondon_metId);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.println(e.getLocalizedMessage());
		
	}
	
}
public List<Employee_Detail> getAllUsers() {
	 List<Employee_Detail> employeeList = new ArrayList<>();
	 try {
		// Connection con=getDatabaseConeection();
	 PreparedStatement statement = con.prepareStatement(VIEW_ALL_EMPLOYEE);
	 ResultSet rs = statement.executeQuery();
	 while (rs.next()) {
	 Employee_Detail employee = new Employee_Detail();
	employee.setId(rs.getString(1));
	 employee.setEmployee_Name(rs.getString(2));
	 employee.setCitizen_Number(rs.getLong(3));
	 employee.setAddress(rs.getString(4));
	 employee.setContact_Number(rs.getLong(5));
	 employee.setJob_Location(rs.getString(6));
	 employee.setDesignation(rs.getString(7));
	 employee.setEmail(rs.getString(8));
	 employee.setPassword(rs.getString(9));
	 employee.setImage(rs.getString(10));
	 employeeList.add(employee);
	 
	 
	 }
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 return employeeList;
	 }
public Employee_Detail getUserById(String londonMet_id) {
Employee_Detail employee = new Employee_Detail();
try {
	//Connection connection=getDatabaseConeection();
//PreparedStatement preparedStatement = connection.prepareStatement("select * from employee_record where London_MetId=?");
PreparedStatement preparedStatement = con.prepareStatement("select * from employee_record where London_MetId=?");
preparedStatement.setString(1,londonMet_id);
ResultSet rs = preparedStatement.executeQuery();
if (rs.next()) {
	employee.setId(rs.getString(1));
	 employee.setEmployee_Name(rs.getString(2));
	 employee.setCitizen_Number(rs.getLong(3));
	 employee.setAddress(rs.getString(4));
	 employee.setContact_Number(rs.getLong(5));
	 employee.setJob_Location(rs.getString(6));
	 employee.setDesignation(rs.getString(7));
	 employee.setEmail(rs.getString(8));
	 employee.setPassword(rs.getString(9));
	 employee.setImage(rs.getString(10));
}
} catch (SQLException e) {
e.printStackTrace();
}
return employee;
}
public void updateEmployee(Employee_Detail employee)
{
	//Connection con=getDatabaseConeection();
	//Connection con=getDatabaseConeection();
	try {
		PreparedStatement st=con.prepareStatement(UPDATE_EMPLOYEE);
		st.setString(1, employee.getEmployee_Name());
		st.setLong(2, employee.getCitizen_Number());
		st.setString(3, employee.getAddress());
		st.setLong(4, employee.getContact_Number());
		st.setString(5, employee.getEmail());
		st.setString(6, employee.getId());
		st.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void deleteById(String londonmetid)
{
	//Connection con=getDatabaseConeection();
	try {
		PreparedStatement deleteStatement=con.prepareStatement(DELETE_EMPLOYEE);
		deleteStatement.setString(1, londonmetid);
		deleteStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
