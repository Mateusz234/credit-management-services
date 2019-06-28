package mg.clientservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mg.clientservice.entity.Client;

@Repository
public class ClientDao {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public ClientDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Client client) {

		String sql = "INSERT INTO Client VALUES(?,?,?)";

		jdbcTemplate.update(sql, new Object[] { 
				client.getName(), 
				client.getLastName(), 
				client.getPersonalId() 
				});
	}
	
	//Hardcoded for testing
	public List<Map<String,Object>> get() {
		
		String sql = "SELECT personalID FROM Client WHERE name = ? ";
		
		return jdbcTemplate.queryForList(sql, "Jan");
	}
	
	//run at start of app. test print of query
	@EventListener(ApplicationReadyEvent.class)
	public void callAtBeggining() {
		System.out.println(get());
	}
	
}
