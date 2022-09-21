package com.EmployeeManagementSystem.Controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.oreilly.servlet.MultipartRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String SAVE_DIR="images";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String employee_Name=request.getParameter("emp_name");
		 long citizen_Number=Long.valueOf(request.getParameter("num"));
		 String address=request.getParameter("address");
		 long contact_Number=Long.valueOf(request.getParameter("txtFName1"));
		 String job_Location=request.getParameter("JobLocation");
		 String designation=request.getParameter("Designation");
		 String email=request.getParameter("email_id");
		 String password=request.getParameter("password");
		 String savePath = "C:" + File.separator + SAVE_DIR;
         File fileSaveDir=new File(savePath);
         if(!fileSaveDir.exists()){
             fileSaveDir.mkdir();
         }
         Part part=request.getPart("image");
         String fileName=extractFileName(part);
         part.write(savePath + File.separator + fileName);
         String filePath= savePath + File.separator + fileName ;
         
	
		 

	}
}
