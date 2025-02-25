package com.backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import com.bank.application.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@MultipartConfig
public class createaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		customerinformation cif = new customerinformation();
DAO dao =new DAO();
		cif.fullname = request.getParameter("fullname");
		System.out.println(cif.fullname);
		cif.address = request.getParameter("address");
		System.out.println(cif.address);
		cif.phoneno = (String) request.getParameter("phoneno");
		System.out.println(cif.phoneno);
		cif.emailid = (String) request.getParameter("emailid");
		System.out.println(cif.emailid);
		cif.accounttype = (String) request.getParameter("accounttype");
		System.out.println(cif.accounttype);
		cif.amount = Integer.parseInt(request.getParameter("Amount")); 
			System.out.println(cif.amount);
		String dat = (String) request.getParameter("date");
		System.out.println(dat);
		SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd");
		
	try { 
		cif.date=dateformat.parse(dat);
		System.out.println(cif.date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		cif.idproof = (String) request.getParameter("idproof");
	System.out.println(cif.idproof);
  //   ServletFileUpload sf =new ServletFileUpload(new DiskFileItemFactory());
     Part filePart = request.getPart("uploadfile"); 
     //GETTING FILE NAME
     System.out.println(filePart);
       
     
     String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();  
    
     System.out.println(fileName);
   
     customerinformation c =new customerinformation();
    
         InputStream fileContent = filePart.getInputStream();

             File file1 =new File("D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Temporaryserver\\"+fileName);
             BufferedImage imBuff = ImageIO.read(fileContent);
           if( c.photoformatchecker(fileName)) { 
             ImageIO.write(imBuff,"jpg", file1); 
       cif.filename="D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Temporaryserver\\"+fileName;
             System.out.println(cif.filename); 		}
           else {
        	   ImageIO.write(imBuff,"png", file1); 
               cif.filename="D:\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Temporaryserver\\"+fileName;
                     System.out.println(cif.filename);
           }
   try {
	   dao.createaccinfo(cif);
	dao.createaccount(cif);
	HttpSession session =request.getSession();
	session.setAttribute("customername",cif.fullname);
	session.setAttribute("accno",cif.accountno);
	session.setAttribute("password",cif.password);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   fileContent.close();
   
   
   response.sendRedirect("confirmation.jsp");
     
     
     
   /*  try {
				cif.filename =  sf.parseRequest(request);
			for(FileItem f:cif.filename) {
				
				
						f.write(new File(+ f.getName()));
						System.out.println("file uploaded successfully");		
			} }
			catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					
				
					
				
			}
        	
        	 
		
}
