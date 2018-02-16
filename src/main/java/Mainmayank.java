

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

public class Mainmayank {

	public static void main(String[] args) {
		//sessionSave();
		testHQL();
		testForLoop();
		testSQL();
	}

	private static void testSQL() {
		// TODO Auto-generated method stub
		
	}

	private static void testForLoop() {
		long time = System.currentTimeMillis();
		List<EmployeeTask> tasks = new EmployeeTaskDAO().findAll();
		for(EmployeeTask t : tasks)
		{
			
		}
		System.out.println((System.currentTimeMillis())-time);
	}

	private static void testHQL() {
		long time = System.currentTimeMillis();
		Session session = HibernateSessionFactory.getSession();
		String sql = "from EmployeeTask e";
		Query query = session.createQuery(sql);
		List<EmployeeTask>tasks = query.list();
		for(EmployeeTask t : tasks)
		{
			
		}
		System.out.println((System.currentTimeMillis())-time);
	}

	private static void sessionSave() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		ClientTrail ct = new ClientTrail();
		//ct.setClientName("fdf");
		
		
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
