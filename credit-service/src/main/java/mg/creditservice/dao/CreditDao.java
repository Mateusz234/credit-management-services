package mg.creditservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mg.creditservice.entity.Credit;

@Repository
public class CreditDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	List<Credit> creditList = new ArrayList<Credit>();

	public CreditDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Credit credit) {

		String sql = "INSERT INTO credit VALUES(?,?)";

		jdbcTemplate.update(sql, new Object[] { 
				credit.getCreditId(), 
				credit.getName() 
				});
	}

	public List<Credit> getAll() {
		String sql = "SELECT * FROM credit";
		creditList.clear(); // prepare list for another call
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		// Get objects from map and put it to a list
		for (Map<String, Object> row : rows) {
			Credit credit = new Credit();
			credit.setCreditId((int)(row.get("creditId")));
			credit.setName((String)row.get("name"));
			creditList.add(credit);
		}
		return creditList;
	}
}
