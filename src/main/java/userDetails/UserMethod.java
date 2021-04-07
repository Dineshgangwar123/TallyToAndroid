package userDetails;

import java.io.Console;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserMethod {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@PostMapping(path="/insert-user")
	public String InsertUser(@RequestBody String user) {
		
//		JSONObject obj = new JSONObject(user);
//		int a = 0;
//	        JSONArray arr = obj.getJSONArray("posts");
//	        for (int i = 0; i < arr.length(); i++) {
//	            String username = arr.getJSONObject(i).getString("username");
//	            int age = arr.getJSONObject(i).getInt("age");  
////	            String sql= "INSERT INTO user(name,age) VALUES(?,?)";
////	    		a= jdbctemplate.update(sql,username,age);
//	            return username;
//	            
//	            
//	        }
////	        if(a>0)
////			{
////				return ResponseEntity.noContent().build();
////			}
	        return "bad call";
		 
	}
	public void adduser(String username,int age)
	{
		String sql= "INSERT INTO user(name,age) VALUES(?,?)";
		
		int a= jdbctemplate.update(sql,username,age);
	}

	

}
