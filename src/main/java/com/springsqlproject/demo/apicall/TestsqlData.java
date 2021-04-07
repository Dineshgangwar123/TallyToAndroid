package com.springsqlproject.demo.apicall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import userDetails.UpdateUser;
import userDetails.User;

@RestController
public class TestsqlData {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@GetMapping(path="/hello-worldsss")
	public String HelloWorld() {
		return "Hello Worldsssssssssss";
	}
	
	@PostMapping(path="/insert-user/{name}/{age}")
	public String InsertUser(@PathVariable String name,@PathVariable int age ) {
		
        String sql= "INSERT INTO user(name,age) VALUES(?,?)";
		
		int a= jdbctemplate.update(sql,name,age);
		if(a>0)
		{
			return "new row inserted";
		}
		return "Something went wrong";
		 
	}
	
	
	
	@Autowired
	private JdbcTemplate jdbctemplates;
	
	@PostMapping(path="/insert-item")
	public String InsertUser(@RequestBody String user) {
		
		JSONObject obj = new JSONObject(user);
		int a = 0;
	        JSONArray arr = obj.getJSONArray("posts");
	        
	        for (int i = 0; i < arr.length(); i++) {

//	      	  final String SELECT_BY_ID_QUERY = "SELECT id, name, age from user where name = ?";
//
//	            String username = arr.getJSONObject(i).getString("username");
//	        	User users= jdbctemplate.queryForObject(SELECT_BY_ID_QUERY, new EmployeeMapper(), 
//	        			username);
//	        	
//	    		List<User> userlist=new ArrayList();
//	    		if(userlist.size()>0)
//	    		{
//	    			
//	    		}
//	    		else {
//	    			
//	    		}
//	    		  		userlist.add(users);
//	    		  		JSONObject objs=new JSONObject();
//	    		  		objs.put("posts",userlist);
	    		  		
	    		  		
	            String username = arr.getJSONObject(i).getString("username");
	            int age = arr.getJSONObject(i).getInt("age");  
	            String sql= "INSERT INTO user(name,age) VALUES(?,?)";
	    		a= jdbctemplate.update(sql,username,age);     
	        }
	        if(a>0)
			{
				return "inserted";
			}
	        return "bad call";
		 
	}
	
	
	  
	  final String SELECT_BY_ID_QUERY = "SELECT id, name, age from user where id = ?";
	  final String SELECT_ALL_QUERY = "SELECT id, name, age from user";
	  final String UPDATE_QUERY = "update user set age = :age where id = :id";
	  final String DELETE_QUERY = "delete from user where id = :id";

	  @GetMapping(path="/getall-ur")
	  public String findAllEmployees() {
		  List<User> ddd=jdbctemplate.query(SELECT_ALL_QUERY, new EmployeeMapper());
		  JSONObject obj=new JSONObject();
		  
		  obj.put("posts",ddd);
		  
		  return obj.toString();
		  }
	  
	  
	  @GetMapping(path="/get-user/{id}")
	  public String findEmployee(@PathVariable int id) {
		  		User user= jdbctemplate.queryForObject(SELECT_BY_ID_QUERY, new EmployeeMapper(), 
			    id);
		  		List<User> userlist=new ArrayList();
		  		userlist.add(user);
		  		JSONObject obj=new JSONObject();
		  		obj.put("posts",userlist);
				return obj.toString();	
			  }
	  
	  
	  
	  private static final class EmployeeMapper implements RowMapper<User> {
		    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		      User user = new User();
		      user.setAge(rs.getInt("age"));
		      
		      user.setUsername(rs.getString("name"));
		      user.setId(rs.getInt("id"));
		      return user;
		    }
		  }
	  
	  @PutMapping(path="/updateuser/{id}/{age}")
	  public String update(@PathVariable int id,@PathVariable int age){
	      String SQL = "update user set age = ? where id = ?";
	      jdbctemplates.update(SQL, age, id);
//	      System.out.println("Updated Record with ID = " + id );
	      return ("Updated Record with ID = " + id );
	   }

	  @DeleteMapping(path="/deleteuser/{id}")
	  public String deleteEmpById(@PathVariable int id) {
		    // Adding params using MapSqlParameterSource class
		    SqlParameterSource namedParameters = new MapSqlParameterSource("id", id );
		    int status = jdbctemplates.update(DELETE_QUERY, namedParameters);
		    if(status != 0){
		      return ("Employee data deleted for ID " + id);
		    }else{
		      return ("No Employee found with ID " + id);
		    }
		  }
	
}
	





