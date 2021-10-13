package kiranaStore.InventoryManagement.daoImpl;
import kiranaStore.InventoryManagement.dto.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.InventoryManagement.dao.*;
import kiranaStore.InventoryManagement.databaseConfig.DBConfig;
public class EmployeeDaoImpl implements EmployeeDao{
	DBConfig dbconfig;
	PreparedStatement stmt;
	public EmployeeDaoImpl() {
		dbconfig=DBConfig.getDBConfig();
	}
	public Boolean add(Employee e) {
		try {
			stmt=dbconfig.getCon().prepareStatement("insert into Employee(employeeId,employeeName,salary,jobtitle) values(?,?,?,?);");
			stmt.setInt(1, e.getEmployeeId());
			stmt.setString(2,e.getEmployeeName());
			stmt.setInt(3,e.getSalary());
			stmt.setString(4,e.getJobTitle());	
			int i=stmt.executeUpdate();
			return true;
			}catch(SQLException es) {
				es.printStackTrace();
				return false;
			}
	}
	@Override
	public Boolean update(Employee emp) {
		try {
			//employee c=new employee();
			stmt=dbconfig.getCon().prepareStatement("update Employee set employeeName=?,salary=?,jobtitle=? where employeeId=?");
			stmt.setString(1,emp.getEmployeeName());
			stmt.setInt(2,emp.getSalary());
			stmt.setString(3,emp.getJobTitle());
			stmt.setInt(4, emp.getEmployeeId());
			int i=stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	
}
	@Override
	public Boolean delete(Integer empId) {
		try {
			stmt=dbconfig.getCon().prepareStatement("delete from Employee where employeeId="+empId);
			int n=stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Employee SearchById(Integer eid) {
		ResultSet rs=null;
		Employee emp=null;
		try{
			stmt=dbconfig.getCon().prepareStatement("select * from Employee where employeeId="+eid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				emp=new Employee();
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setEmployeeName(rs.getString("employeeName"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobTitle(rs.getString("jobtitle"));
				return emp;
			}
			return emp;
		}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	@Override
	public List<Employee> employeeList(){
		ResultSet rs=null;
		Employee employee=null;
		List<Employee> employeeList=new ArrayList<>();
		try {
			stmt=dbconfig.getCon().prepareStatement("select * from employee");
			rs=stmt.executeQuery();
			while(rs.next()) {
				employee=new Employee();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setEmployeeName(rs.getString("employeeName"));
				employee.setSalary(rs.getInt("salary"));
				employee.setJobTitle(rs.getString("jobtitle"));
				employeeList.add(employee);
			}return employeeList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
	