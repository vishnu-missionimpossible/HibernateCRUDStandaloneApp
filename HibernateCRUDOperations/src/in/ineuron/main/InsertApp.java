package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction =null;
		boolean flag = false;
		
		try {
					session = HibernateUtil.getSession();
					if (session != null)
						transaction = session.beginTransaction();
			
						if (transaction != null) {
							Employee employee = new Employee();
							employee.setEmpId(15);
							employee.setEmpName("Vijaya");
							employee.setEmpSal(12000.55);
			
							session.save(employee);
							flag = true;
						}
				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		 finally {
			// TODO: handle finally clause
			 
			 if(flag == true)
			transaction.commit();
		else
			transaction.rollback();
			 
			 HibernateUtil.closeSession(session);
		}
		
		
			
	}
	

}
