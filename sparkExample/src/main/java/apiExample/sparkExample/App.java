package apiExample.sparkExample;

import static spark.Spark.*;
import static spark.Spark.port;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        port(2000);
        
        get("/hello", (req, res) -> "Hello World");
        
    }
}
