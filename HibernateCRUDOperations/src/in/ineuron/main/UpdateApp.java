package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateApp {
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
							employee.setEmpName("Lakshmi");
							employee.setEmpSal(12345.55);
			
							session.saveOrUpdate(employee);
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
			 
			 if(flag == true) {
				 transaction.commit();
				 System.out.println("Record updated successfully...");
			 }
			
			 else
			{
				transaction.rollback();
				System.out.println("Record updation failed...");
			}
			 
			 
			 HibernateUtil.closeSession(session);
		}
		
		
			
	}
	

}
