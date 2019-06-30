package mg.productservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mg.productservice.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public ProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Product product) {

		String sql = "INSERT INTO Product VALUES(?,?,?)";

		jdbcTemplate.update(sql, new Object[] { product.getCreditId(), product.getName(), product.getValue(), });
	}

	public Product getProductById(int creditId) {

		Product product = new Product();
		String sql = "SELECT * FROM Product WHERE creditId = ? ";

		product = (Product) jdbcTemplate.queryForObject(sql, new Object[] { creditId }, new ProductRowMaper());

		return product;
	}

	// Mapper to populate Product object from query
	private class ProductRowMaper implements RowMapper<Object> {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setCreditId(rs.getInt("creditId"));
			product.setName(rs.getString("name"));
			product.setValue(rs.getDouble("value"));
			return product;
		}

	}

}
