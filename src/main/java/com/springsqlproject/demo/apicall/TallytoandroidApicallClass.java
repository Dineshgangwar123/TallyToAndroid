package com.springsqlproject.demo.apicall;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TallytoandroidApicallClass {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@PostMapping(path="/insert-item-details")
	public String InsertUser(@RequestBody String user) {
		
		JSONObject obj = new JSONObject(user);
		int a = 0;
	        JSONArray arr = obj.getJSONArray("posts");
	        
	        for (int i = 0; i < arr.length(); i++) {
	        	
	            String item_name = arr.getJSONObject(i).getString("item_name");
	            String group = arr.getJSONObject(i).getString("group");
	            String baseUnit = arr.getJSONObject(i).getString("baseUnit");
	            String alternateUnit = arr.getJSONObject(i).getString("alternateUnit");
	            int stockId = arr.getJSONObject(i).getInt("stockId"); 
	            int gst = arr.getJSONObject(i).getInt("gst");  
	            int hsn = arr.getJSONObject(i).getInt("hsn");  
	            int mrp = arr.getJSONObject(i).getInt("mrp");  
	            int sdtSellRate = arr.getJSONObject(i).getInt("sdtSellRate");  
	            int closingStock = arr.getJSONObject(i).getInt("closingStock");  
	            String sql= "INSERT INTO itemtable(stockid,itemname,`group`,baseunit,alternateunit,gst,hsn,mrp,sdtsellrate,closingstock) VALUES(?,?,?,?,?,?,?,?,?,?)";
	    		a= jdbctemplate.update(sql,stockId,item_name,group,baseUnit,alternateUnit,gst,hsn,mrp,sdtSellRate,closingStock);     
	        }
	        if(a>0)
			{
				return "inserted";
			}
	        return "bad call";
		 
	}
	

	    @PutMapping(path="/updateusers")
		public String update(@RequestBody String user) {
			
			JSONObject obj = new JSONObject(user);
			int a = 0;
		        JSONArray arr = obj.getJSONArray("posts");
		        
		        for (int i = 0; i < arr.length(); i++) {
		        	
		            String item_name = arr.getJSONObject(i).getString("item_name");
		            String group = arr.getJSONObject(i).getString("group");
		            String baseUnit = arr.getJSONObject(i).getString("baseUnit");
		            String alternateUnit = arr.getJSONObject(i).getString("alternateUnit");
		            int stockId = arr.getJSONObject(i).getInt("stockId"); 
		            int gst = arr.getJSONObject(i).getInt("gst");  
		            int hsn = arr.getJSONObject(i).getInt("hsn");  
		            int mrp = arr.getJSONObject(i).getInt("mrp");  
		            int sdtSellRate = arr.getJSONObject(i).getInt("sdtSellRate");  
		            int closingStock = arr.getJSONObject(i).getInt("closingStock"); 
		            String sql = "update itemtable set itemname = ?,`group` = ?,baseunit = ?,alternateunit = ?,gst = ?,hsn = ?,mrp = ?,sdtsellrate = ?,closingstock = ? where stockid = ?";
		    		a= jdbctemplate.update(sql,item_name,group,baseUnit,alternateUnit,gst,hsn,mrp,sdtSellRate,closingStock,stockId);     
		        }
		        if(a>0)
				{
					return "updated";
				}
		        return "bad call";
			 
		}
	
	



	
}
	





