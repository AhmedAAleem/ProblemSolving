package com.sales.jdbc.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class InvoiceConfiguration {
	
	  @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/sys"); // Change this URL based on your database configuration
	        dataSource.setUsername("root"); // Change this to your database username
	        dataSource.setPassword("Password"); // Change this to your database password
	        return dataSource;
	    }
	  
//	  public static boolean isDbConnected() {
//		  Connection conn = null;
//		    final String CHECK_SQL_QUERY = "SELECT 1";
//		    boolean isConnected = false;
//		    try (PreparedStatement statement = conn.prepareStatement(CHECK_SQL_QUERY)) {
//		        isConnected = true;
//		    } catch (SQLException | NullPointerException e) {
//		        // handle SQL error here!
//		    }
//		    return isConnected;
//		}

}
