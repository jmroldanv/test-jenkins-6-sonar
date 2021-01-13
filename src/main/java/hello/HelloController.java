package hello;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
			
    @RequestMapping("/")
    public String index() {
    	logger.info("/index >>>");
        return "Greetings from index"; 
    }
    
    @RequestMapping("/testeo1/{id}")
    public String getById(@PathVariable String id) {
    	logger.info("/getById/"+id+" >>> ");
        return "Greetings from getById "+id;
    }    
   
    @RequestMapping("/path1")
    public String path1() {
    	logger.info("/path1 >>>");
        return "Hola soy path1";
    }  
     
}
