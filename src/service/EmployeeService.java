package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {

	public void saveEmp(Employee emp);

	public List<Employee> getEmployee();

	public void deleteEmpById(Integer id);

	public Employee getEmpById(Integer id);

	public void updateEmp(Employee e);
	
	public List<Employee> searchEmp(String firstName);

}

