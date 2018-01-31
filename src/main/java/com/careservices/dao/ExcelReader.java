package com.careservices.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExcelReader {
	public static void main(String args[]) throws IOException {

		

		Session session = HibernateSessionFactory.getSession();
		FileInputStream file = new FileInputStream(new File("C:/Users/JARVIS/Documents/care_user.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row;

		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // points to the starting of excel i.e excel first row
			row = (Row) sheet.getRow(i); // sheet number

			String code;
			if (row.getCell(1) == null) {
				code = "000";
			} else
				code = row.getCell(1).toString();

			String email;
			if (row.getCell(2) == null) {
				email = "default";
			} // suppose excel cell is empty then its set to 0 the variable
			else
				email = row.getCell(2).toString(); // else copies cell data to name variable

			Long mobile;
			if (row.getCell(3) == null) {
				mobile = null;
			} else 
				mobile = (long) row.getCell(3).getNumericCellValue();		

			String name;
			if (row.getCell(4) == null) {
				name = "null";
			} else
				name = row.getCell(4).toString();

			String password;
			if (row.getCell(5) == null) {
				password = "null";
			} else
				password = row.getCell(5).toString();

			String user_type;
			if (row.getCell(6) == null) {
				user_type = "null";
			} else
				user_type = row.getCell(6).toString();

			Transaction t = session.beginTransaction();

			CareUser cu = new CareUser();
			cu.setCode(code);
			cu.setEmail(email);
			cu.setMobile(mobile);
			cu.setName(name);
			cu.setPassword(password);
			cu.setUserType(user_type);

			System.out.println(cu.getId() + " " + cu.getCode() + " " + cu.getEmail() + " " + cu.getMobile() + " "
					+ cu.getName() + " " + cu.getPassword() + " " + cu.getUserType());
			session.save(cu);

			t.commit();
		}
		file.close();
	}

}
