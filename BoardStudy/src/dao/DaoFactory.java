package dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import connection.AwsConnectionMaker;
import connection.ConnectionMaker;

@Configuration
public class DaoFactory {
	@Bean
	public ConnectionMaker connectionMaker() {
		return new AwsConnectionMaker();
	}

	@Bean
	public DataSource dataSource() {

		String url = "jdbc:mysql://database-study-spring.chsxiosrbq1b.ap-northeast-2.rds.amazonaws.com:3306/sys";
		String username = "admin";
		String password = "6s8GJggs8q9Ol3biXshz";

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;

	}

	@Bean
	public BoardDao boardDao() {
		BoardDao boardDao = new BoardDao();
		boardDao.setDataSource(dataSource());
		// boardDao.setConnectionMaker(connectionMaker());
		return boardDao;
	}

	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}
}
