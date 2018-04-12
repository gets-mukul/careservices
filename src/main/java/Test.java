
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
import com.careservices.dao.Contact;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.HibernateSessionFactory;
import com.careservices.dao.Segment;

public class Test {

	public static void main(String[] args) throws ParseException  {
		
		//setNewObject();   //persist new object details to care_user table
		//getUserDetails(); // get data of any user from table
		//hqlDemo();			// test HQL
		
	
	}

	private static void hqlDemo() {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		// select * from contact where contact_number = mobile;
		String hql = "from CareUser where id='1'";
		Query query = session.createQuery(hql);
		List<CareUser> careObj = query.list();
		for (CareUser careUser : careObj) {
			String name = careUser.getName();
			String email = careUser.getEmail();
			long mobile = careUser.getMobile();
			String userType = careUser.getUserType();
			System.out.println("name: " + name);
			System.out.println("email: " + email);
			System.out.println("mobile: " + mobile);
			System.out.println("user type: " +userType);
			
			}
		
	}

	private static void getUserDetails() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		
		CareUserDAO daoObj = new CareUserDAO();
		CareUser careObj = daoObj.findById(5);
		String name = careObj.getName();
		String email = careObj.getEmail();
		long mobile = careObj.getMobile();
		String password = careObj.getPassword();
		String userType = careObj.getUserType();
		System.out.println("name: " + name);
		System.out.println("email: " + email);
		System.out.println("mobile: " + mobile);
		System.out.println("user type: " +userType);
		
		

	}

	private static void setNewObject() {
		// TODO Auto-generated method stub
		
		long mobile = 789654123;
		Session session = HibernateSessionFactory.getSession();
		 CareUser careObj = new CareUser();
		 careObj.setCode("22");
		 careObj.setEmail("abc@ss.ss");
		 careObj.setMobile(mobile);
		 careObj.setName("mmm");
		 careObj.setPassword("sdf");
		 careObj.setUserType("ADMIN");
		 
		 Transaction orgTransaction = null;
			try {
				orgTransaction = session.beginTransaction();
				session.save(careObj);
				orgTransaction.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				orgTransaction.rollback();
			
		

	}
		
	}
	}
