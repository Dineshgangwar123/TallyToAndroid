package userDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import userDetails.User;

@RestController
public class GetUserDetails {
	
	@Autowired
	  private JdbcTemplate jdbcTemplate; 
	  
	 
}
