
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
import com.careservices.dao.Segment;
import com.careservices.services.SMSUtility;

import javafx.scene.control.Separator;

public class Test {

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
		Session groupSession = HibernateSessionFactory.getSession();
		SMSUtility utility = new SMSUtility();

		String hql = "from Segment where id=:id or parent_id=:id";
		Query query = groupSession.createQuery(hql);
		query.setParameter("id", 9);
		
		List<Segment> list = query.list();  
			
		for (Segment segment : list) {
			utility.removeGroup(segment.getGroupId());
		}
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
