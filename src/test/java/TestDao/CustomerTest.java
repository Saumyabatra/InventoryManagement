package TestDao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import kiranaStore.InventoryManagement.dto.Customer;
import kiranaStore.InventoryManagement.daoImpl.*;
import kiranaStore.InventoryManagement.dao.*;
public class CustomerTest {
	CustomerDao customerDao;
	@Before
	public void setUp() {
		customerDao=new CustomerDaoImpl();
	}
	//@Test
	public void testAddCustomer() {
		Customer c=new Customer();
		c.setCustomerId(9);
		c.setCustomerName("Luo");
		c.setCustomerPhone("XXXXXXXXXX");
		c.setCustomerAge(33);
		Assert.assertTrue(customerDao.add(c));;
	}
	@Test
	public void testSearchById() {
		Assert.assertNotNull(customerDao.SearchById(2));
	}
	@Test
	public void testCustomerList() {
		Assert.assertTrue(customerDao.customersList().size()>0);

		
	}
}