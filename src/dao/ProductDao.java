package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import entity.Product;
import entity.TicketReply;
import entity.User;
import entity.UserProduct;


public class ProductDao extends AbstractDao{

	
	public void addProduct(Product pro) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"insert into ProductMaster (name,warranty,w_type,w_coverage,exclusion) values(?,?,?,?,?)");
		stmt.setString(1,pro.getName());
		stmt.setString(2,pro.getWarranty());
		stmt.setString(3,pro.getwType());
		stmt.setString(4,pro.getCoverage());
		stmt.setString(5,pro.getExclusion());
		stmt.executeUpdate();
		con.close();

	}
	
	public void updateProduct(Product pro) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"update ProductMaster set name=?,warranty=?,w_type=?,w_coverage=?,exclusion=? where pid=?");
		stmt.setString(1,pro.getName());
		stmt.setString(2,pro.getWarranty());
		stmt.setString(3,pro.getwType());
		stmt.setString(4,pro.getCoverage());
		stmt.setString(5,pro.getExclusion());
		stmt.setInt(6, pro.getId());
		stmt.executeUpdate();
		con.close();

	}

	
	public ArrayList<Product> getProductNames() throws Exception {
		Logger log=Logger.getRootLogger();
		log.debug("Get All Product Method Entered");
		ArrayList<Product> list=new ArrayList<Product>();
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from ProductMaster");
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			list.add(new Product(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6)));
			log.debug("Element Added to Map");
		}
		log.debug("Get All Product Method Exit");
		return list;
	}


	public int getProductId(String p) throws Exception {
		int id=0;
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select pid from ProductMaster where name=?");
		stmt.setString(1, p);
		ResultSet rset=stmt.executeQuery();
		if(rset.next())
		{
			id=rset.getInt(1);
		}
		con.close();
		return id;
	}
	
	public Product getByProductId(int pid) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from ProductMaster where pid=?");
		stmt.setInt(1, pid);
		ResultSet rset=stmt.executeQuery();
		Product pro=null;
		if(rset.next())
		{	pro=new Product(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6));
		}
		con.close();
		return pro;
	}
	
	public UserProduct getUserProductById(int id) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from CustomerProducts where id=?");
		stmt.setInt(1, id);
		ResultSet rset=stmt.executeQuery();
		UserProduct pro=null;
		if(rset.next())
		{
			pro=new UserProduct(rset.getInt(1),rset.getInt(3), "abc", rset.getString(4), rset.getString(5), rset.getString(6));
		}
		con.close();
		return pro;
	}
	
	public UserProduct getCustomerProductById(int id , int pid) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from CustomerProducts where id=?");
		stmt.setInt(1, id);
		ResultSet rset=stmt.executeQuery();
		UserProduct pro=null;
		if(rset.next())
		{	Product p=getByProductId(pid);
			pro=new UserProduct(rset.getInt(1),rset.getInt(3), p.getName(), rset.getString(4), rset.getString(5), rset.getString(6));
		}
		con.close();
		return pro;
	}
	
	public void deleteProductById(int p) throws Exception {
		
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("delete from ProductMaster where pid=?");
		stmt.setInt(1, p);
		stmt.executeUpdate();
		
		con.close();
		
	}


	public void registerProduct(int pid, int cid, String pDate,
			String pPrice, String vendor) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"insert into CustomerProducts(cid,pid,purchaseDate,purchasePrice,vendor) values(?,?,?,?,?)");
		stmt.setInt(1,cid);
		stmt.setInt(2,pid);
		stmt.setString(3,pDate);
		stmt.setString(4,pPrice);
		stmt.setString(5,vendor);
		stmt.executeUpdate();
		con.close();

	}


	public List<UserProduct> getRegisteredProduct(int id) throws Exception {
		Logger log=Logger.getRootLogger();
		log.debug("Get All User Method Entered");
		List<UserProduct> list=new ArrayList<UserProduct>();
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("SELECT CustomerProducts.*,ProductMaster.name FROM CustomerProducts,ProductMaster"
		+ " WHERE CustomerProducts.pid = ProductMaster.pid AND CustomerProducts.cid=?");
		stmt.setInt(1, id);
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			list.add(new UserProduct(rset.getInt(1),rset.getInt(3),rset.getString(7),rset.getString(4),rset.getString(5),rset.getString(6)));
			log.debug("Element Added to Map");
		}
		log.debug("Get All User Method Exit");
		return list;
	}
	
	public List<UserProduct> getAllRegisteredProduct() throws Exception {
		Logger log=Logger.getRootLogger();
		log.debug("Get All User Method Entered");
		List<UserProduct> list=new ArrayList<UserProduct>();
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("SELECT CustomerProducts.*,ProductMaster.name FROM CustomerProducts,ProductMaster"
		+ " WHERE CustomerProducts.pid = ProductMaster.pid");
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{	int cid=Integer.parseInt(rset.getString(2));
			UserDao dao=new UserDao();
			User u=dao.getById(cid);
			list.add(new UserProduct(rset.getInt(1),rset.getInt(3),u.getName()+";"+rset.getString(7),rset.getString(4),rset.getString(5),rset.getString(6)));
			log.debug("Element Added to Map");
		}
		log.debug("Get All User Method Exit");
		return list;
	}
	
	public List<UserProduct> getProductById(int pid) throws Exception {
		Logger log=Logger.getRootLogger();
		log.debug("Get All Product Method Entered");
		UserDao dao=new UserDao();
		List<UserProduct> list=new ArrayList<UserProduct>();
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from CustomerProducts where pid=?");
		stmt.setInt(1, pid);
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			UserProduct prod=new UserProduct(rset.getInt(1),rset.getInt(2), rset.getString(3), rset.getString(4), rset.getString(5),rset.getString(6));
			prod.setUser(dao.getById(rset.getInt(2)));
			list.add(prod);
			log.debug("Element Added to Map");
		}
		log.debug("Get All Product Method Exit");
		return list;
	}

	public List<UserProduct> dateDifferenc(String fDate,String tDate) throws Exception
	{
		UserDao udao=new UserDao();
		ProductDao pdao=new ProductDao();
	Connection con=getConnection();	
	PreparedStatement stmt=con.prepareStatement("select * from CustomerProducts where str_to_date(?, '%d-%m-%y')>=str_to_date(purchaseDate, '%d-%m-%y') or str_to_date(?,'%d-%m-%y')<=str_to_date(purchaseDate, '%d-%m-%y') ");
	stmt.setString(1, fDate);
	stmt.setString(2, tDate);
	List<UserProduct> list=new ArrayList<UserProduct>();
	ResultSet rset=stmt.executeQuery();
	while(rset.next())
	{
	 UserProduct product=new UserProduct();
	             product.setId(rset.getInt(1));
	             product.setCid(rset.getInt(2));
	             product.setPid(rset.getInt(3));
	             product.setpDate(rset.getString(4));
	             product.setpPrice(rset.getString(5));
	             product.setVendor(rset.getString(6));
	             product.setUser(udao.getById(product.getCid()));
	             product.setProduct(pdao.getByProductId(product.getPid()));
		list.add(product);
	}
	return list;
	}
	
}
