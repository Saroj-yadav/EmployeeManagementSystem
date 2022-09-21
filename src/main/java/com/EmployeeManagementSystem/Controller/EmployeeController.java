package com.EmployeeManagementSystem.Controller;

import java.io.File;
import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import com.EmployeeManagementSystem.model.Employee_Detail;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.EmployeeManagementSystem.dao.EmployeeDao;
import com.EmployeeManagementSystem.model.Employee_Detail;

/**
 * Servlet implementation class EmployeeMainServlet
 */
@WebServlet("/EmployeeMainServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/Employee_Form.jsp";
	 private static String LIST_USER = "/listEmployee.jsp";
	 private static String UPDATE = "/update.jsp";
	 private EmployeeDao dao;
	 private static final String SAVE_DIR="images";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	//ServletContext context=config.getServletContext();
    	dao=new EmployeeDao();
    	//context.setAttribute("employeeDao", employeeDao);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getParameter("parm");
		
		String forward;
		if(path.equalsIgnoreCase("addUser"))
		{
			forward=INSERT;
			RequestDispatcher patcher=request.getRequestDispatcher(forward);
			patcher.include(request, response);
			
			
		}
		if(path.equalsIgnoreCase("viewEmployee"))
		{
			forward=LIST_USER;
			RequestDispatcher patcher=request.getRequestDispatcher(forward);
			
			request.setAttribute("employeeList", dao.getAllUsers());
			patcher.forward(request, response);
			//request.setAttribute("user", dao.)
		}
		if(path.equalsIgnoreCase("edit"))
		{
			forward=UPDATE;
			String london_metId=request.getParameter("londonmet_id");
			Employee_Detail employee=dao.getUserById(london_metId);
			request.getSession().setAttribute("london_metId",london_metId );
			request.setAttribute("employee", employee);
			RequestDispatcher dispatcher=request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
		if(path.equalsIgnoreCase("delete"))
		{
			
			String london_metId=request.getParameter("londonmet_id");
			dao.deleteById(london_metId);
			RequestDispatcher view =
					 request.getRequestDispatcher(LIST_USER);
					  request.setAttribute("employeeList", dao.getAllUsers());
					  view.forward(request, response);
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		String url=request.getParameter("submit");
		if(url.equalsIgnoreCase("insert"))
		{
		 String employee_Name=request.getParameter("emp_name");
		 long citizen_Number=Long.valueOf(request.getParameter("num"));
		 String address=request.getParameter("address");
		 long contact_Number=Long.valueOf(request.getParameter("txtFName1"));
		 String job_Location=request.getParameter("JobLocation");
		 String designation=request.getParameter("Designation");
		 String email=request.getParameter("email_id");
		 String passWord=request.getParameter("Password");

		 String savePath = "C:" + File.separator + SAVE_DIR;
         File fileSaveDir=new File(savePath);
         if(!fileSaveDir.exists()){
             fileSaveDir.mkdir();
         }
         Part part=request.getPart("image");
         String fileName=extractFileName(part);
         part.write(savePath + File.separator + fileName);
         String filePath= savePath + File.separator + fileName ;
         Employee_Detail employee=new Employee_Detail(employee_Name,citizen_Number,address,
        		 contact_Number,job_Location,designation,email,passWord,filePath);
         dao.insertEmployeeToDatabase(employee);
	}
		if(url.equalsIgnoreCase("update"))
		{
			
			String id=request.getSession(false).getAttribute("london_metId").toString();
			
			String employee_Name=request.getParameter("emp_name");
			 long citizen_Number=Long.valueOf(request.getParameter("num"));
			 String address=request.getParameter("address");
			 long contact_Number=Long.valueOf(request.getParameter("txtFName1"));
			 
			 String email=request.getParameter("email_id");
			 
			 Employee_Detail employee=new Employee_Detail();
			 employee.setEmployee_Name(employee_Name);
			 employee.setCitizen_Number(citizen_Number);
			 employee.setAddress(address);
			 employee.setContact_Number(contact_Number);
			 employee.setEmail(email);
			 employee.setId(id);
			 dao.updateEmployee(employee);
			 
			 RequestDispatcher view =
					 request.getRequestDispatcher(LIST_USER);
					  request.setAttribute("employeeList", dao.getAllUsers());
					  view.forward(request, response);


			
		}
	}

}
