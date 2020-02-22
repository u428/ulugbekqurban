package ulugbek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ulugbek.Entity.Student;
import ulugbek.dao.CustomerDAO;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Student> getStudent() {
		return customerDAO.getStudent();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		customerDAO.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
		return customerDAO.getStudent(theId);
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		
		customerDAO.deleteStudent(theId);
	}
}





