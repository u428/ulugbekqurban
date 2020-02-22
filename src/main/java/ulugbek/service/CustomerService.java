package ulugbek.service;

import java.util.List;

import ulugbek.Entity.Student;

public interface CustomerService {

	public List<Student> getStudent();

	public void saveStudent(Student theCustomer);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
	
}
