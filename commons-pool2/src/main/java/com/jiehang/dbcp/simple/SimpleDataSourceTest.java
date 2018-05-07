package com.jiehang.dbcp.simple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class SimpleDataSourceTest {

	public static void main(String[] args) throws SQLException {
		DataSource dataSource = createDataSource();
		Connection connection;
		Statement statement = null;
		for(int i=0; i<10; i++) {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
		}
		ResultSet resultSet = statement.executeQuery("select * from blog_category");
		while (resultSet.next()) {
			String string = resultSet.getString("name");
			System.out.println(string);
		}
//		if(resultSet != null)
//			resultSet.close();
//		if(statement != null)
//			statement.close();
//		if(connection != null)
//			connection.close();
	}
	
	private static DataSource createDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setMaxIdle(5);
		basicDataSource.setMaxTotal(10);
		basicDataSource.setMaxWaitMillis(10);
		basicDataSource.setUrl("jdbc:mysql://45.76.51.233:3306/blog");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("jin~@jake12");
		return basicDataSource;
	}
}
