package kiranaStore.InventoryManagement.dao;
import kiranaStore.InventoryManagement.dto.*;
import java.util.*;
public interface EmployeeDao {
	public Boolean add(Employee c);
	public Boolean update(Employee c);
	public Boolean delete(Integer c);
	public Employee SearchById(Integer c);
	public List<Employee> employeeList();
}
