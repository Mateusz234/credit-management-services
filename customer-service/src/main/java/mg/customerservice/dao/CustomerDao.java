package mg.customerservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mg.customerservice.entity.Customer;

@Repository
public class CustomerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Customer Customer){

		String sql = "INSERT INTO customer VALUES(?,?,?,?)";

		jdbcTemplate.update(sql, new Object[] { 
				Customer.getCreditId(), 
				Customer.getName(), 
				Customer.getLastName(),
				Customer.getPersonalId() });
	}

	public Customer getCustomerById(int creditId){

		Customer Customer = new Customer();
		String sql = "SELECT * FROM customer WHERE creditId = ? ";
		Customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { creditId }, new CustomerRowMaper());
		return Customer;
	}

	// Mapper to populate Customer object from query
	private class CustomerRowMaper implements RowMapper<Object> {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer Customer = new Customer();
			Customer.setCreditId(rs.getInt("creditId"));
			Customer.setName(rs.getString("name"));
			Customer.setLastName(rs.getString("lastName"));
			Customer.setPersonalId(rs.getString("PersonalId"));
			return Customer;
		}

	}

}
