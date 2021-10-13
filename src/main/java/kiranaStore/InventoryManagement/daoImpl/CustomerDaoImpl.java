package kiranaStore.InventoryManagement.daoImpl;
import kiranaStore.InventoryManagement.dao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.InventoryManagement.databaseConfig.DBConfig;
import kiranaStore.InventoryManagement.dto.Customer;
public class CustomerDaoImpl implements CustomerDao {
	DBConfig dbconfig;
	PreparedStatement stmt;
	public CustomerDaoImpl() {
		dbconfig=DBConfig.getDBConfig();
	}
	@Override
	public Boolean add(Customer customer) {
		try {
			stmt=dbconfig.getCon().prepareStatement("insert into Customer(customerId,customerName,customerPhone,customerAge) values(?,?,?,?);");
			stmt.setInt(1, customer.getCustomerId());
			stmt.setString(2,customer.getCustomerName());
			stmt.setString(3,customer.getCustomerPhone());
			stmt.setInt(4,customer.getCustomerAge());	
			int i=stmt.executeUpdate();
			return true;
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	@Override
	public Boolean update(Customer customer) {
		try {
			//Customer c=new Customer();
			stmt=dbconfig.getCon().prepareStatement("update Customer set customerName=?,customerPhone=?,customerage=? where customerId=?");
			stmt.setString(1,customer.getCustomerName());
			stmt.setString(2,customer.getCustomerPhone());
			stmt.setInt(3,customer.getCustomerAge());
			stmt.setInt(4, customer.getCustomerId());
			int i=stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Boolean delete(Integer customerId) {
		try {
			stmt=dbconfig.getCon().prepareStatement("delete from Customer where customerId="+customerId);
			int n=stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Customer SearchById(Integer c) {
		ResultSet rs=null;
		Customer customer=null;
		try{
			stmt=dbconfig.getCon().prepareStatement("select * from Customer where customerId="+c);
			rs=stmt.executeQuery();
			if(rs.next()) {
				customer=new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerPhone(rs.getString("customerphone"));
				customer.setCustomerAge(rs.getInt("customerage"));
			}
			return customer;
		}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	@Override
	public List<Customer> customersList(){
		ResultSet rs=null;
		Customer customer=null;
		List<Customer> customerList=new ArrayList<>();
		try {
			stmt=dbconfig.getCon().prepareStatement("select * from customer");
			rs=stmt.executeQuery();
			while(rs.next()) {
				customer=new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerPhone(rs.getString("customerPhone"));
				customer.setCustomerAge(rs.getInt("customerAge"));
			
			customerList.add(customer);
			}return customerList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	}
