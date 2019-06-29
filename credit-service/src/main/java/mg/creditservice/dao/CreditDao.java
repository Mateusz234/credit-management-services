package mg.creditservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mg.creditservice.entity.Credit;

@Repository
public class CreditDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public CreditDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Credit credit) {

		String sql = "INSERT INTO Credit VALUES(?)";

		jdbcTemplate.update(sql, new Object[] { credit.getCreditId() });
	}

	public List<Map<String, Object>> getAll() {

		String sql = "SELECT * FROM Credit";
		return jdbcTemplate.queryForList(sql);

	}

	// run at start of app. test print of query result
	@EventListener(ApplicationReadyEvent.class)
	public void callAtBeggining() {
		System.out.println(getAll());
	}

}
