package kiranaStore.InventoryManagement.dao;
import kiranaStore.InventoryManagement.dto.*;
import java.util.*;
public interface OrderDao {
	public Boolean add(Order c);
	public Boolean update(Order c);
	public Boolean delete(Integer c);
	public Order SearchById(Integer c);
	public List<Order> orderList();
}
