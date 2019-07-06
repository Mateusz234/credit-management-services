package mg.productservice.dao;

import javax.sql.DataSource;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class dbConnectionConfig {

	@Bean
	public DataSource getDataSource() {

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.url("jdbc:mysql://192.168.1.63:3306/creditDB?serverTimezone=UTC"); // connection with my local db
		dataSourceBuilder.url("jdbc:mysql://mysql/creditdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		dataSourceBuilder.username("product");
		dataSourceBuilder.password("123456");
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		return dataSourceBuilder.build();

	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

}
