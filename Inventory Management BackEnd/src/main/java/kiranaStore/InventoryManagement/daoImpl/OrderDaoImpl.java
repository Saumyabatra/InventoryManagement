package kiranaStore.InventoryManagement.daoImpl;
import kiranaStore.InventoryManagement.dto.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kiranaStore.InventoryManagement.dao.*;
import kiranaStore.InventoryManagement.databaseConfig.DBConfig;
public class OrderDaoImpl implements OrderDao{
	private DBConfig dbconfig;
	private PreparedStatement stmt;
	private ProductDao productDao;
	public OrderDaoImpl() {	
		productDao=new ProductDaoImpl();
		dbconfig=DBConfig.getDBConfig();	
}
@Override
public Boolean add(Order order) {
	try {
		ResultSet rs=null;
		stmt=dbconfig.getCon().prepareStatement("insert into Order1(orderId,employeeId,customerId,productId,orderQuantity,orderDate,totalPrice) values(?,?,?,?,?,?,?);");
		Integer orderId=order.getOrderId(); 
		Integer employeeId=order.getEmployeeId();
		Integer customerId=order.getCustomerId();
		Integer productId=order.getProductId();
		Integer orderQuantity=order.getOrderQuantity();
		Timestamp orderDate=new Timestamp(new Date().getTime());
		Integer totalPrice=order.getTotalPrice();
		
		Product product=productDao.SearchById(productId);
		if(product.getProductAvailability()<orderQuantity) {
		throw new ArithmeticException("We do not have enough of "+product.getProductName()+" We only have "+product.getProductAvailability());
		}
		if(totalPrice<=0 || totalPrice==null) {
		throw new NullPointerException("You must buy at least one Product");
		}
		stmt.setInt(1,orderId);
		stmt.setInt(2, employeeId);
		stmt.setInt(3, customerId);
		stmt.setInt(4, productId);
		stmt.setInt(5, orderQuantity);
		stmt.setTimestamp(6, orderDate);
		stmt.setInt(7, totalPrice);
		int i=stmt.executeUpdate();
		

		stmt=null;
		stmt=dbconfig.getCon().prepareStatement("update product set productAvailability=? where productId=?");
		Integer remainingQty=product.getProductAvailability()-orderQuantity;
		stmt.setInt(1, remainingQty);
		stmt.setInt(2,product.getProductId());
		i=stmt.executeUpdate();
		return true;
		}catch(SQLException | ArithmeticException| NullPointerException es) {
			System.out.println(es);
			return false;
		}
}

@Override
public Boolean update(Order order) {
	try {
		//Customer c=new Customer();
		stmt=dbconfig.getCon().prepareStatement("update Order1 set employeeId=?,customerId=?,orderId=?,orderQuantity=?,totalPrice=? where orderId=?");
		stmt.setInt(1,order.getEmployeeId());
		stmt.setInt(2,order.getCustomerId());
		stmt.setInt(3,order.getProductId());
		stmt.setInt(4, order.getOrderQuantity());
		//stmt.setTimestamp(5, order.getOrderDate());
		stmt.setInt(5, order.getTotalPrice());
		stmt.setInt(6,order.getOrderId());
		int i=stmt.executeUpdate();
		return true;
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}	
}
@Override
public Boolean delete(Integer o) {
	// TODO Auto-generated method stub
	try {
		stmt=dbconfig.getCon().prepareStatement("delete from Order1 where orderId="+o);
		int n=stmt.executeUpdate();
		return true;
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
}
@Override
public Order SearchById(Integer c) {
	// TODO Auto-generated method stub
	ResultSet rs=null;
	Order o=null;
	try{
		stmt=dbconfig.getCon().prepareStatement("select * from order1 where orderId="+c);
		rs=stmt.executeQuery();
		if(rs.next()) {
			o=new Order();
			o.setOrderId(rs.getInt("orderId"));
			o.setEmployeeId(rs.getInt("employeeId"));
			o.setCustomerId(rs.getInt("customerId"));
			o.setProductId(rs.getInt("productId"));
			o.setOrderQuantity(rs.getInt("orderQuantity"));
			o.setOrderDate(rs.getTime("orderDate"));
			o.setTotalPrice(rs.getInt("totalPrice"));
			return o;
		}
		return o;
	}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

}
@Override
public List<Order> orderList(){
	ResultSet rs=null;
	Order order=null;
	List<Order> orderList=new ArrayList<>();
	try {
		stmt=dbconfig.getCon().prepareStatement("select * from order1");
		rs=stmt.executeQuery();
		while(rs.next()) {
			order=new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setCustomerId(rs.getInt("customerId"));
			order.setProductId(rs.getInt("productId"));
			order.setEmployeeId(rs.getInt("employeeId"));
			order.setOrderQuantity(rs.getInt("orderQuantity"));
			order.setOrderDate(rs.getTime("orderDate"));
			order.setTotalPrice(rs.getInt("totalPrice"));
			orderList.add(order);
		}return orderList;
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	
}

}
