package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DbConnection;

public class EmpServiceImpl implements EmployeeService {
	Connection con = null;
	PreparedStatement ps = null;

	@Override
	public void saveEmp(Employee e) {
		try {
			con = DbConnection.getDbConnection();
			String sql = "insert into employee (firstName, lastName, salary, age, email)" + "values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getAge());
			ps.setString(5, e.getEmail());

			ps.executeUpdate();
//			System.out.println("Data saved from serviceImpl...");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> listOfEmp = new ArrayList<>();
		Employee e = null;

		try {

			con = DbConnection.getDbConnection();
			String query = "Select * from employee";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				listOfEmp.add(e);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listOfEmp;
	}

	@Override
	public void deleteEmpById(Integer id) {
		try {
			con = DbConnection.getDbConnection();
			String sql = "delete from employee where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Data deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmpById(Integer id) {
		Employee e = null;
		try {
			con = DbConnection.getDbConnection();
			String query = "Select * from employee where id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));

			}
			System.out.println("Data Selected Successfully");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public void updateEmp(Employee e) {
		try {
			con = DbConnection.getDbConnection();
			String sql = "update employee set firstName=?, lastName=?, salary=?, age=?, email=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getAge());
			ps.setString(5, e.getEmail());
			ps.setInt(6, e.getId());
			ps.executeUpdate();
			System.out.println("Data updated successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<Employee> searchEmp(String firstName) {
		List<Employee> listOfEmp = new ArrayList<>();
		Employee e = null;

		try {

			con = DbConnection.getDbConnection();
//			String query = "Select * from employee where firstName = ?";
			String query = "Select * from employee where firstName  like ?";
			//LIKE '%or%';
			ps = con.prepareStatement(query);
			ps.setString(1, "%"+firstName+"%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				listOfEmp.add(e);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listOfEmp;
	}

}
