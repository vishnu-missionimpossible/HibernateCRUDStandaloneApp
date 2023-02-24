package in.ineuron.main;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;



public class Standard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		boolean flag = false;
		
		cfg = new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
	   Employee employee =  new Employee();
	   employee.setEmpId(12);
	   employee.setEmpName("Vyshnavi");
	   employee.setEmpSal(5000.25);
	   
	   try {
		transaction = session.beginTransaction();
		idValue = (Integer) session.save(employee);
		System.out.println("Generated idvalue is: "+idValue);
		flag = true;
	} catch (HibernateException e) {
		// TODO: handle exception
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
		finally {
			if(flag==true)
				transaction.commit();
			else
				transaction.rollback();
		    session.close();
		    sessionFactory.close();
		}
		
		
		
		
		
		
		
		

	}

}
