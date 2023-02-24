package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;



public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Step 1 Creating a configuration object 
		Configuration cfg = new Configuration();
		
		//2. configure hibernate.cfg.xml file to configuration object
		cfg.configure();
		
		//3. Create SessionFactory object
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//4. Get the session object from Sessionfactory
		Session session = sessionFactory.openSession();
		
		//5. Begin a transaction with in a session 
		Transaction transaction =  session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(11);
		employee.setEmpName("Chandu");
		employee.setEmpSal(4000.25);
		
		//6. Perform operation
		Serializable object = session.save(employee);
		System.out.println(object);
		//7. performing transaction operation
		transaction.commit();
		
		//8. Close the session object
		session.close();
		
		

	}

}
