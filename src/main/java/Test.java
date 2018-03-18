
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
import com.careservices.dao.Contact;
import com.careservices.dao.HibernateSessionFactory;
import com.careservices.dao.Segment;

public class Test {

	public static void main(String[] args) throws ParseException  {
		//do object ajj ki date ka object and kal ke date ka object useinig calander utility
		
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.sizeEq("employeeTasks", 0));
		criteria.setMaxResults(15);
		//criteria.createAlias("relatedTask", "task").add(Restrictions.eq("task.actor", employee));
		//criteria.addOrder(Order.asc("trailStartDate")).addOrder(Order.asc("time"));				
		List<Contact>trials  = criteria.list();
		for(Contact c : trials)
		{
			System.out.println("c id "+c.getId());
		}
		

	}
	
}
