package com.careservices.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContactExcel {
	public static void main(String args[]) throws IOException {


		Session session = HibernateSessionFactory.getSession();
		FileInputStream file = new FileInputStream(new File("C:/Users/JARVIS/Documents/contact.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row;

		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // points to the starting of excel i.e excel first row
			row = (Row) sheet.getRow(i); // sheet number

			Long contact_number =null;
			if (row.getCell(0) == null) {
				contact_number =  null;
			} else
				contact_number = (long) row.getCell(0).getNumericCellValue();
			
			Integer uploaded_by;
			if (row.getCell(1) == null) {
				uploaded_by =  null;
			} else
				uploaded_by = (int) row.getCell(1).getNumericCellValue();
			
			CareUser u = new CareUserDAO().findById(uploaded_by);


			Transaction t = session.beginTransaction();

			Contact c = new Contact();
			c.setContactNumber(contact_number);
			c.setCareUser(u);
			System.out.println("sone Successfully");

			session.save(c);

			t.commit();
		}
		file.close();
	}

}
