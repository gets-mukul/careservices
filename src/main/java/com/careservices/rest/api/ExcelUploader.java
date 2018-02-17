/**
 * 
 */
package com.careservices.rest.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.Contact;
import com.careservices.dao.HibernateSessionFactory;

/**
 * @author JARVIS
 *
 */
@Path("/excel")
public class ExcelUploader {

	@Path("/upload/{user_id}")
	@POST
	public Response excelFileUploader(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail, @PathParam("user_id") Integer userId)
			{
		System.out.println("gpt file "+fileDetail.getFileName());
		String uploadedFileLocation = "F:\\excel\\" + UUID.randomUUID().toString() + System.currentTimeMillis()
				+ fileDetail.getFileName();

		try {
			writeToFile(uploadedInputStream, uploadedFileLocation);
		} catch (IOException e) {

			e.printStackTrace();
		}

		
		try {
			FileInputStream fis = new FileInputStream(new File(uploadedFileLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			Integer number_of_sheet = workbook.getNumberOfSheets();
			for (int i = 0; i < number_of_sheet; i++) {
				XSSFSheet spreadsheet = workbook.getSheetAt(i); // spreadsheet
				Iterator<Row> rowIterator = spreadsheet.iterator();

				while (rowIterator.hasNext()) {

					Row row = rowIterator.next();
					Cell cell = row.getCell(0);
					if (cell != null) {

						String mobile = null;

						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							mobile = cell.getNumericCellValue() + "";
							mobile = mobile.toString().replaceAll(" ", "");
							break;

						case Cell.CELL_TYPE_STRING:
							mobile = cell.getStringCellValue();
							mobile = mobile.replaceAll(" ", "");
							break;
						}
						if(mobile!=null)
						{
							insertContactInDB(mobile,userId);
						}	
					}
				}

			}
			fis.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		return Response.status(200).entity("file uploaded").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	private void insertContactInDB(String mobile, Integer userId) {
		String mobileTrimeedd = mobile.trim().replace(" ", "");
		mobileTrimeedd= 	mobileTrimeedd.replaceAll("[\\D]", "");
		System.out.println(">>>"+mobileTrimeedd);
		CareUserDAO dao = new CareUserDAO();
		CareUser cu = dao.findById(userId);
		Long mobileNum = null;
		try {
			mobileNum = Long.parseLong(mobileTrimeedd);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		if(mobileNum!=null)
		{
			Session session = HibernateSessionFactory.getSession();
			//select * from contact where contact_number = mobile;
			String hql = "from Contact c where c.contactNumber=:mob";
			Query query = session.createQuery(hql);
			query.setLong("mob", mobileNum);
			List<Contact> contacts =  query.list();
			if(contacts.size()>0)
			{
				
			}
			else
			{
				Contact contact = new Contact();
				contact.setUploadedBy(cu);
				contact.setContactNumber(mobileNum);
				Timestamp uploadedAt = new Timestamp(System.currentTimeMillis());
				contact.setUploadedAt(uploadedAt );
				Transaction orgTransaction = null;
				try {
					orgTransaction = session.beginTransaction();
					session.save(contact);
					orgTransaction.commit();
				} catch (HibernateException e) {
					e.printStackTrace();
					if (orgTransaction != null)
						orgTransaction.rollback();
				} finally {
					
				}			
			}	
				
		}
		else
		{
			System.out.println("mobile is null");
		}	
		
		
		
	}

	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws IOException {

		OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(uploadedFileLocation));
		while ((read = uploadedInputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();

	}
}
