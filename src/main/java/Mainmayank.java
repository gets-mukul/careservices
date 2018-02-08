

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.careservices.dao.ClientTrail;
import com.careservices.dao.HibernateSessionFactory;

public class Mainmayank {

	public static void main(String[] args) {
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
