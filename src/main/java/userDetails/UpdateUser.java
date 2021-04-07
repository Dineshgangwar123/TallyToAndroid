package userDetails;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUser {

	@Autowired
	private JdbcTemplate jdbctemplates;
	
	@GetMapping(path="/hello-wo")
	public String HelloWorld() {
		return "Hello Worldsssssssssss";
	}
	
	 final String UPDATE_QUERY = "update user set age = :age where id = :id";
	  final String DELETE_QUERY = "delete from user where id = :id";	

	  @PutMapping(path="/update-user/{age}/{id}")
	  public String update(@PathVariable int age,@PathVariable int id) {
		  
		  
//		  JSONObject obj = new JSONObject(user);
			int a = 0;
//		        JSONArray arr = obj.getJSONArray("posts");
		        
//		        for (int i = 0; i < arr.length(); i++) {
		        	
//		            String username = arr.getJSONObject(i).getString("username");
//		            int age = arr.getJSONObject(i).getInt("age"); 
//		            int id = arr.getJSONObject(i).getInt("id"); 
		            SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("age", age).addValue("id", id);
		     	    a= jdbctemplates.update(UPDATE_QUERY, namedParameters); 
		                
//		        }
		        if(a != 0){
		        	return ("Employee data updated for ID " );
		        }else{
		        	return ("No Employee found with ID " );
		        }
	  }
	  
//	  @DeleteMapping(path="/deleteuser/{id}")
	  public String deleteEmpById(int id) {
		    // Adding params using MapSqlParameterSource class
		    SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		    int status = jdbctemplates.update(DELETE_QUERY, namedParameters);
		    if(status != 0){
		      return ("Employee data deleted for ID " + id);
		    }else{
		      return ("No Employee found with ID " + id);
		    }
		  }

}
