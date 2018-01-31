package com.careservices.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ScripCodeExcelReader {
	public static void main(String args[]) throws IOException, ParseException {

		

		Session session = HibernateSessionFactory.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		FileInputStream file = new FileInputStream(new File("C:/Users/JARVIS/Downloads/CRM_ALL_SECRIP.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row;

		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // points to the starting of excel i.e excel first row
			row = (Row) sheet.getRow(i); // sheet number

			String symbol;
			if (row.getCell(0) == null) {
				symbol = "default";
			} else
				symbol = row.getCell(0).toString();

			String expiry;
			if (row.getCell(1) == null) {
				expiry = null ;
			} // suppose excel cell is empty then its set to 0 the variable
			else
				expiry = row.getCell(1).toString(); // else copies cell data to name variable
			Date expiry1 = sdf.parse(expiry);
			
			Integer mkt_Lot;
			if (row.getCell(2) == null) {
				mkt_Lot = null;
			} else 
				mkt_Lot = (int) row.getCell(2).getNumericCellValue();		

			Transaction t = session.beginTransaction();

			ScripCode sc = new ScripCode();
			sc.setSymbol(symbol);
			sc.setExpiry( expiry1); 
			sc.setMktLot(mkt_Lot);
			System.out.println(sc.getSymbol() + " " + sc.getExpiry() + " " + sc.getMktLot());
			session.save(sc);

			t.commit();
		}
		file.close();
	}

}
