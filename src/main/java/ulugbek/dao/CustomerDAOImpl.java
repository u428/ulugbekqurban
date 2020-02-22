package ulugbek.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import ulugbek.Entity.Student;

@Service
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Student> getStudent() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  ... sort by last name
		Query theQuery = currentSession.createQuery("select * from groupby order by id");

		// execute query and get result list
		List<Student> student= theQuery.list();
				
		// return the results		
		return student;
	}

	@Override
	public void saveStudent(Student theStudent) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theStudent);
		
	}

	@Override
	public Student getStudent(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Student theStudent = (Student) currentSession.get(Student.class, theId);
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=studentId");
		theQuery.setParameter("studentId", theId);
		
		theQuery.executeUpdate();		
	}

}











