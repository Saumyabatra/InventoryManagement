package kiranaStore.InventoryManagement;
import kiranaStore.InventoryManagement.dao.CustomerDao;
import kiranaStore.InventoryManagement.dao.EmployeeDao;
import kiranaStore.InventoryManagement.dao.OrderDao;
import kiranaStore.InventoryManagement.dao.ProductDao;
import kiranaStore.InventoryManagement.daoImpl.CustomerDaoImpl;
import kiranaStore.InventoryManagement.daoImpl.EmployeeDaoImpl;
import kiranaStore.InventoryManagement.daoImpl.OrderDaoImpl;
import kiranaStore.InventoryManagement.daoImpl.ProductDaoImpl;
import kiranaStore.InventoryManagement.dto.Customer;
import kiranaStore.InventoryManagement.dto.Employee;
import kiranaStore.InventoryManagement.dto.Product;
import kiranaStore.InventoryManagement.dto.Order;
import java.util.*;
public class Test{
	CustomerDao customerdao=new CustomerDaoImpl();
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    Employee employee = new Employee();
    Product product = new Product();
    Order order = new Order();
	Customer customer=new Customer();
	Scanner s=new Scanner(System.in);
	public void addCustomer(Customer customer) {
		/*
		 * customer.setCustomerId(6); customer.setCustomerName("Bianca");
		 * customer.setCustomerPhone("3456789023"); customer.setCustomerAge(29);
		 * System.out.println(customerdao.add(customer)); customer.setCustomerId(8);
		 * customer.setCustomerName("Miho"); customer.setCustomerPhone("0976532235");
		 * customer.setCustomerAge(29);
		 */
		System.out.println(customerdao.add(customer));
	}
	public void display(Integer customerId) {
		customer=customerdao.SearchById(customerId);
		System.out.println(customer);
	}
	public void displayCustomers() {
		List<Customer> list=customerdao.customersList();
		for(Customer c:list) {
			System.out.println(c);
		}
	}
	public void addEmployee(Employee employee) {
		/*
		 * employee.setEmployeeId(3); employee.setEmployeeName("E3");
		 * employee.setSalary(12000); employee.setJobTitle("HR Manager");
		 * System.out.println(employeeDao.add(employee)); employee.setEmployeeId(4);
		 * employee.setEmployeeName("E4"); employee.setSalary(15000);
		 * employee.setJobTitle("Manager");
		 * 
		 */
		System.out.println(employeeDao.add(employee));
	}
	public void displayEmployee(Integer e) {
		employee=employeeDao.SearchById(3);
		System.out.print(employee);
	}
	public void displayEmployees() {
		List<Employee> list=employeeDao.employeeList();
		for(Employee c:list) {
			System.out.println(c);
		}
	}
	public void addProduct(Product product) {
		/*
		 * product.setProductId(1); product.setProductName("sugar");
		 * product.setProductPrice(1200); product.setProductAvailability(1000);
		 * System.out.println(productDao.add(product)); product.setProductId(2);
		 * product.setProductName("Salt"); product.setProductPrice(12000);
		 * product.setProductAvailability(200);
		 * System.out.println(productDao.add(product)); product.setProductId(4);
		 * product.setProductName("Shampoo"); product.setProductPrice(1200);
		 * product.setProductAvailability(100);
		 * System.out.println(productDao.add(product)); product.setProductId(5);
		 * product.setProductName("toothbrush"); product.setProductPrice(1200);
		 * product.setProductAvailability(100);
		 * 
		 */
		System.out.println(productDao.add(product));
	}
	public void displayProduct(Integer p) {
		product=productDao.SearchById(3);
		System.out.println(product);
	}
	public void displayProducts() {
		List<Product> list=productDao.productList();
		for(Product c:list) {
			System.out.println(c);
		}
	}
	public void addOrder(Integer pid,Integer cid,Integer orderQuantity) {
		order.setCustomerId(cid);
		order.setEmployeeId(1);
		order.setProductId(pid);
		order.setOrderDate(new Date());
		order.setOrderQuantity(orderQuantity);
		//order.setTotalPrice(orderQuantity);
		Integer totalPrice=(order.getOrderQuantity()*productDao.SearchById(pid).getProductPrice());
		order.setTotalPrice(totalPrice);
		System.out.println(orderDao.add(order));
	}
	public void displayOrder(Integer oid) {
		order=orderDao.SearchById(oid);
		System.out.println(order);
	}
	public void displayOrders() {
		List<Order> list=orderDao.orderList();
		for(Order o:list) {
			System.out.println(o);
		}
	}
	public void displayTotal() {
		List<Order> list=orderDao.orderList();
		Integer sum=0;
		for(Order o:list) {
			sum=sum+o.getTotalPrice();
		}
		System.out.println(sum);
	}
	}
	
