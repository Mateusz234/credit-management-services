package mg.creditservice.dao;

import java.util.ArrayList;
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

	List<Map<String, Object>> creditListOfMap = new ArrayList<>();
	List<Credit> creditList = new ArrayList<>();

	public CreditDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Credit credit) {

		String sql = "INSERT INTO Credit VALUES(?)";

		jdbcTemplate.update(sql, new Object[] { credit.getCreditId() });
	}

	/*TODO implement checking if id exists (ids are unique)
	 * then add if it doesn't instead of
	 * clearing and creating new objects. Slower but less memory needed
	 */
	public List<Credit> getAll() {
		
		//prepare collections
		creditListOfMap.clear();
		creditList.clear();
		
		String sql = "SELECT * FROM Credit";
		creditListOfMap = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> entry : creditListOfMap) {
			for (String key : entry.keySet()) {
				creditList.add(new Credit((int) entry.get(key)));
			}
		}
		return creditList;
	}

}
