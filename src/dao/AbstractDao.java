package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.servlet.ServletContext;
import org.apache.log4j.Logger;
import com.swinfosoft.mvc.web.ActionContext;

public abstract class AbstractDao {

	static Properties prop;
	static Logger logger=Logger.getRootLogger(); 
	static
	{
		prop=new Properties();
		try
		{
		InputStream in=
			AbstractDao.class.getResourceAsStream("/db.properties");
		prop.load(in);
		logger.info("properties loaded.");
		}catch(Exception ex)
		{
			logger.error(ex);
		}
	}

	public void saveProperties() throws Exception
	{
		ServletContext ctx=ActionContext.getServletContext();
		String url=ctx.getRealPath("/WEB-INF/classes/db.properties");
		logger.info("db properties are saved at: "+url);
		File file=new File(url);
		FileOutputStream out=new FileOutputStream(file);
		prop.store(out, "db properties configured by the user.");
	}
	
public Connection getConnection() throws Exception
{
Connection con=null;

		//To create a database connection for MySql
		Class.forName(prop.getProperty("driverClass"));
		String url=prop.getProperty("url");
		String user=prop.getProperty("user");
		String pass=prop.getProperty("password");
		if(user==null)
		con=DriverManager.getConnection(url);
		else 
		con=
		DriverManager.getConnection(url,user,pass);
		
		return con;
	}
}


