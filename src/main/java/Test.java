
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
import com.careservices.dao.HibernateSessionFactory;
import com.careservices.dao.Segment;

public class Test {

	public static void main(String[] args) throws ParseException  {
		//do object ajj ki date ka object and kal ke date ka object useinig calander utility
		
		Session session = HibernateSessionFactory.getSession();
		JSONArray jArr = new JSONArray();
		Integer employeeId = 4;
		CareUser employee = new CareUserDAO().findById(employeeId);
		String hql = "from ClientTrail  WHERE trailStartDate between :currentDate AND :nextDate AND status='TRIAL' AND relatedTask.actor =:actor order by trailStartDate, time";
		String currentDate = "2018-02-28";
		String nextDate = "2018-02-28";
		Date cDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate); 
		Date nDate = new SimpleDateFormat("yyyy-MM-dd").parse(nextDate);
		Query query = session.createQuery(hql);
		query.setParameter("currentDate", cDate);
		query.setParameter("nextDate",nDate );
		query.setParameter("actor", employee);
		//query.setParameter("status", TaskStatusConstants.TRIAL);
		List<ClientTrail>trials  = query.list();
		for (ClientTrail clientTrail : trials) {
			System.out.println(clientTrail.getId());
		}
		
		

	}
	
}
