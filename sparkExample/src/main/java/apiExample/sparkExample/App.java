package apiExample.sparkExample;

import static spark.Spark.get;
import static spark.Spark.port;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	int numObjects = 2;
    	
    	String input = "[{\"studentNumber\": \"43255\"}]";
    			
    			
    			
    	
		JSONObject student1 = new JSONObject();
		student1.put("studentNumber", "43255");
		student1.put("name", "Jiajun Ma");
		student1.put("studentEmail", "jiajun.ma@cgs.act.edu.au");
		student1.put("studentRFID", "4101010191");
		student1.put("studentYear", 11);
		
		JSONObject student2 = new JSONObject();
		student2.put("studentNumber", "42151");
		student2.put("name", "Tom Gaynor");
		student2.put("studentEmail", "ton.gaynor@cgs.act.edu.au");
		student2.put("studentRFID", "8374018572");
		student2.put("studentYear", 11);
		
		JSONArray list = new JSONArray();
		
		for (int x = 1; x <= numObjects; x++) {
			list.put(student1);
		}
		
		try(FileWriter file = new FileWriter("test.json"))
		{
			file.write(list.toString());
			file.flush();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
        
        port(2000);
        
        get("/hello", (req, res) -> list);
        
    }
}
