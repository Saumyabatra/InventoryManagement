package kiranaStore.InventoryManagement.dao;
import java.util.*;
import kiranaStore.InventoryManagement.dto.*;
public interface ProductDao {
	public Boolean add(Product c);
	public Boolean update(Product c);
	public Boolean delete(Integer c);
	public Product SearchById(Integer c);
	public List<Product> productList(); 
}
