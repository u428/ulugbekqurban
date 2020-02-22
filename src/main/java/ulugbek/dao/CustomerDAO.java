package ulugbek.dao;

import ulugbek.Entity.Student;

import java.util.List;


public interface CustomerDAO {

	public List<Student> getStudent();

	public void saveStudent(Student theCustomer);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
	
}
