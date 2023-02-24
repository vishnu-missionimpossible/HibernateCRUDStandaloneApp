package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction =null;
		boolean flag = false;
		int id=13;
		
		try {
					session = HibernateUtil.getSession();
					if (session != null)
						transaction = session.beginTransaction();
			
						if (transaction != null) {
					Employee employee =session.get(Employee.class, id);
				            if(employee!=null) {
							session.delete(employee);
							flag = true;
							}else {
								System.out.println("Record not available for deletion for the given id:: "+id);
								flag = false;
								
							}
								
						}
				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		 finally {
			// TODO: handle finally clause
			 
			 if(flag == true) {
				 transaction.commit();
				 System.out.println("Object deleted successfully...");
			 }
			 
			else {
				transaction.rollback();
				System.out.println("Object deletion failed...");
			}
			
			 
			 HibernateUtil.closeSession(session);
		}
		
		
			
	}
	

}
