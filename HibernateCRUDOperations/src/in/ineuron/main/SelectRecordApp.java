package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		Employee employee = null;
		int id =10;
		try {
			 
			if(session!=null)
				employee=session.load(Employee.class, id);

				System.out.println(employee);
			
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("Record not available for the given id: "+id);
		}

	}

}
