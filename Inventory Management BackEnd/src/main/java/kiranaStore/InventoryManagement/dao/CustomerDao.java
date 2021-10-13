package kiranaStore.InventoryManagement.dao;
import java.util.*;
import kiranaStore.InventoryManagement.dto.*;

public interface CustomerDao {
	public Boolean add(Customer c);
	public Boolean update(Customer c);
	public Boolean delete(Integer cid);
	public Customer SearchById(Integer cid);
	public List<Customer> customersList();
}
