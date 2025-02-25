package com.backend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.application.DAO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;


public class printstatement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("called the printstatement");
			HttpSession session =request.getSession();
		Long accno=Long.parseLong(session.getAttribute("accno").toString());
		String name=(String)session.getAttribute("name");
		String pass =(String)session.getAttribute("password");
		DAO dao =new DAO();
	customerinformation custom=	dao.displayinfo(accno,name);	
	
		Document document =new Document();
		PdfWriter writer; 
		writer =PdfWriter.getInstance(document,new FileOutputStream("D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\PDFoutput\\"+accno+".pdf"));
		writer.open();
		document.open();
     
		
  
        // Create a font for the center heading
		 Font font0 = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
        Font font = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Font font1 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Font font2 = new Font(Font.FontFamily.HELVETICA,14,Font.NORMAL);
        
        Paragraph bankname =new Paragraph(custom.bankname,font0);
        bankname.setAlignment(Element.ALIGN_CENTER);
        document.add(bankname);
        document.add(new Paragraph("\n"));
          
        LocalDateTime ldt =LocalDateTime.now();
        DateTimeFormatter dtfformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                             String formateddate = dtfformat.format(ldt); 
       /*  Paragraph par=new Paragraph("Date and Time :"+formateddate,font1);
         par.setAlignment(Element.ALIGN_RIGHT);
                           document.add(par);
                             document.add(new Paragraph("\n"));*/
           
                             Phrase phrase =new Phrase();
           Chunk chunk1=new Chunk("Date and Time : ",font1);
           Chunk chunk2=new Chunk(formateddate,font2);
           phrase.add(chunk1);
           phrase.add(chunk2);
          Paragraph par =  new Paragraph(phrase);
          par.setAlignment(Element.ALIGN_RIGHT);
           document.add(par);

             Chunk chunk3 =new Chunk("Customer Name : ",font1);
             Chunk chunk4 =new Chunk(custom.fullname,font2);
             
             Phrase phrase1 =new Phrase();
             phrase1.add(chunk3);
             phrase1.add(chunk4);
             document.add(new Paragraph(phrase1));
                             
       //document.add(new Paragraph("Customer Name :"+custom.fullname,font1));
        
      //  document.add(new Paragraph("Customer Accountnumber: "+custom.accountno,font1));
        Chunk chunk5 =new Chunk("Customer Accountnumber : ",font1);
        Chunk chunk6 =new Chunk(Long.toString(custom.accountno),font2);
        Phrase phrase2 =new Phrase();
        phrase2.add(chunk5);
        phrase2.add(chunk6);
        document.add(new Paragraph(phrase2));
        
        
      //  document.add(new Paragraph("Phone no: "+custom.phoneno,font1));
        Chunk chunk7 =new Chunk("Customer Phone Number : ",font1);
        Chunk chunk8 =new Chunk(custom.phoneno,font2);
        Phrase phrase3 =new Phrase();
        phrase3.add(chunk7);
        phrase3.add(chunk8);
        document.add(new Paragraph(phrase3));
        
     //   document.add(new Paragraph("Email-id: "+custom.emailid,font1));
        Chunk chunk9 =new Chunk("Customer Email-id : ",font1);
        Chunk chunk10 =new Chunk(custom.emailid,font2);
        Phrase phrase4 =new Phrase();
        phrase4.add(chunk9);
        phrase4.add(chunk10);
        document.add(new Paragraph(phrase4));
        
      //  document.add(new Paragraph("Address: "+custom.address,font1));
        Chunk chunk11 =new Chunk("Customer Address : ",font1);
        Chunk chunk12 =new Chunk(custom.address,font2);
        Phrase phrase5 =new Phrase();
        phrase5.add(chunk11);
        phrase5.add(chunk12);
        document.add(new Paragraph(phrase5));
        
        document.add(new Paragraph("\n"));
        
        // Create a paragraph for the center heading
        Paragraph heading = new Paragraph("10 Transactions of the Customer", font);
        heading.setAlignment(Element.ALIGN_CENTER);

        // Add the center heading to the PDF document
        document.add(heading);

        // Create a line separator
        document.add(new Paragraph("\n"));
       Chunk line =new Chunk(new LineSeparator());
       line.setLineHeight(1);
       document.add(line);
       document.add(new Paragraph("\n"));
        
     //   document.add(new Paragraph("---------------------------------------------------"));

        // Create a table with three columns
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
     table.setSpacingBefore(15);
        // Create table headers
        PdfPCell headerCell = new PdfPCell(new Phrase("S.NO",font1));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setBorderWidth(1);
        headerCell.setPadding(5);
        table.addCell(headerCell);
        
        headerCell = new PdfPCell(new Phrase("DATE AND TIME",font1));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setBorderWidth(1);
        headerCell.setPadding(5);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("WITHDRAW",font1));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setBorderWidth(1);
        headerCell.setPadding(5);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("DEPOSIT",font1));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setBorderWidth(1);
        headerCell.setPadding(5);
        table.addCell(headerCell);
        
     

         String url="jdbc:mysql://localhost:3306/BankingApplication";
         String username="root";
         String password="2001";
         Connection con =DriverManager.getConnection(url,username,password);
       // Execute a SQL query to retrieve data from the MySQL database
     String query="select DATE_FORMAT(date_time,'%d-%m-%Y ' ' %H:%i:%s'),withdraw,deposit from transaction_info where accountnumber=?"
     		+ " order by date_time desc limit 10";
         PreparedStatement pst =con.prepareStatement(query);
         pst.setLong(1,custom.accountno);
        ResultSet rs= pst.executeQuery();
        int i=1;    
        while (rs.next()) {
            	 PdfPCell cell;
            	 cell=new PdfPCell(new Phrase(Integer.toString(i)));
            	 cell.setBorderWidth(1);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setPadding(5);
            	 table.addCell(cell);
             
               cell = new PdfPCell(new Phrase(rs.getString(1)));
                cell.setBorderWidth(1);
            cell.setPadding(8);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString(2)));
                cell.setBorderWidth(1);
               cell.setPadding(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString(3)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(5);
                cell.setBorderWidth(1);
                table.addCell(cell);
                
                i++;
            }
       
        
    //   document.add(new Paragraph(dao.getDeposit(accno)));

        // Add the table to the PDF document
        document.add(table);
        document.add(new Paragraph("\n"));
        Chunk chunk13 =new Chunk("Total Withdrawal : ",font1);
        Chunk chunk14 =new Chunk(Integer.toString(dao.getWithdraw(accno)),font2);
        Phrase phrase6 =new Phrase();
        phrase6.add(chunk13);
        phrase6.add(chunk14);
        document.add(phrase6);
   
        document.add(new Paragraph("\n"));
        Chunk chunk15 =new Chunk("Total Deposit : ",font1);
        Chunk chunk16 =new Chunk(Integer.toString(dao.getDeposit(accno)),font2);
        Phrase phrase7 =new Phrase();
        phrase7.add(chunk15);
        phrase7.add(chunk16);
        document.add(phrase7);
        
        document.add(new Paragraph("\n"));
        Chunk chunk17 =new Chunk(custom.accounttype+"Balance is : ",font1);
        Chunk chunk18 =new Chunk(Integer.toString(dao.getAmount(accno,pass)),font2);
        Phrase phrase8 =new Phrase();
        phrase8.add(chunk17);
        phrase8.add(chunk18);
       Paragraph parlast =new Paragraph(phrase8);
       parlast.setAlignment(Element.ALIGN_RIGHT);
       System.out.println(Element.ALIGN_RIGHT);
        document.add(parlast);
        
    // Close the PDF document
        document.close();

        // Close the PDF writer
        writer.close();}
                         catch(Exception e) {
                        	 e.printStackTrace();
                         }

        System.out.println("PDF generated successfully!");
        response.sendRedirect("PDFdownload.jsp");
    }
}

