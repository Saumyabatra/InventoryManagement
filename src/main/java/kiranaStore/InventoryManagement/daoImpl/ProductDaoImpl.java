package kiranaStore.InventoryManagement.daoImpl;
import kiranaStore.InventoryManagement.dto.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.InventoryManagement.dao.*;
import kiranaStore.InventoryManagement.databaseConfig.DBConfig;
public class ProductDaoImpl implements ProductDao{
	DBConfig dbconfig;
	PreparedStatement stmt;
	public ProductDaoImpl() {
		dbconfig=DBConfig.getDBConfig();
	}
	public Boolean add(Product p) {
		try {
			stmt=dbconfig.getCon().prepareStatement("insert into Product(productId,productName,productPrice,productAvailability) values(?,?,?,?);");
			stmt.setInt(1, p.getProductId());
			stmt.setString(2,p.getProductName());
			stmt.setInt(3,p.getProductPrice());
			stmt.setInt(4,p.getProductAvailability());	
			int i=stmt.executeUpdate();
			return true;
			}catch(SQLException es) {
				es.printStackTrace();
				return false;
			}
	}
	@Override
	public Boolean update(Product p) {
		try {
			//Customer c=new Customer();
			stmt=dbconfig.getCon().prepareStatement("update Product set productName=?,ProductPrice=?,productAvailability=? where productId=?");
			stmt.setString(1,p.getProductName());
			stmt.setInt(2,p.getProductPrice());
			stmt.setInt(3,p.getProductAvailability());
			stmt.setInt(4, p.getProductId());
			int i=stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	
}
	@Override
	public Boolean delete(Integer pid) {
		try {
			stmt=dbconfig.getCon().prepareStatement("delete from Product where productId="+pid);
			int n=stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Product SearchById(Integer pid) {
		ResultSet rs=null;
		Product p=null;
		try{
			stmt=dbconfig.getCon().prepareStatement("select * from product where productId="+pid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString("productName"));
				p.setProductPrice(rs.getInt("productPrice"));
				p.setProductAvailability(rs.getInt("productAvailability"));
				return p;
			}
			return p;
		}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	@Override
	public List<Product> productList(){
		ResultSet rs=null;
		Product product=null;
		List<Product> productList=new ArrayList<>();
		try {
			stmt=dbconfig.getCon().prepareStatement("select * from product");
			rs=stmt.executeQuery();
			while(rs.next()) {
				product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductAvailability(rs.getInt("productAvailability"));
			productList.add(product);
			}return productList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
