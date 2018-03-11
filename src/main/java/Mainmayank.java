
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.careservices.dao.ClientTrail;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.EmployeeTaskDAO;
import com.careservices.dao.HibernateSessionFactory;

import javafx.scene.control.Separator;

public class Mainmayank {

	public static void main(String[] args) {
		// sessionSave();
		testHQL();

	}

	private static void testSQL() {
		// TODO Auto-generated method stub

	}

	private static void testForLoop() {
		long time = System.currentTimeMillis();
		List<EmployeeTask> tasks = new EmployeeTaskDAO().findAll();
		for (EmployeeTask t : tasks) {

		}

	}

	private static void testHQL() {
		StringBuffer string = new StringBuffer();
		Session session = HibernateSessionFactory.getSession();
		//String sql = "select contactNumber from Contact FULL JOIN EmployeeTask ON EmployeeTask.contact=Contact.id where EmployeeTask.status!='INCOMPLETE' AND EmployeeTask.status!='TRIAL'AND EmployeeTask.status!='NOT_TRADE'";
		Query query = session.createQuery("from EmployeeTask where status!='INCOMPLETE' AND status!='NOT_TRADE' AND status!='TRIAL' ");
		
		List<EmployeeTask> list = query.list();  
		Integer listSize = list.size();
		System.out.println("size"+listSize);
		
		for (EmployeeTask object : list) {
			
			
			String mobile = object.getContact().getContactNumber().toString();
			string.append(mobile+",");
		}
		System.out.println(string);
		String str = string.substring(0, (string.length() -1));
		System.out.println(str);
	}

	private static void sessionSave() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		ClientTrail ct = new ClientTrail();
		Transaction orgTransaction = null;
		try {
			orgTransaction = session.beginTransaction();
			session.save(ct);
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (orgTransaction != null)
				orgTransaction.rollback();
		}
	}
}
