package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
//@SpringBootTest    			-- Es más lento. Carga todo el contexto de aplicación completo (todos los beans).
//@AutoConfigureMockMvc			-- Lo incluye @WebMvcTest

/*
 * 
    ejemplo1:
   
	 	@SpringBootTest(
	  			SpringBootTest.WebEnvironment.MOCK,      		-- Mocking
	  			classes = Application.class)
		@AutoConfigureMockMvc
		@TestPropertySource(locations = "classpath:application-integrationtest.properties") //overwrites application.properties
		
	
	ejemplo2:  
	
		@SpringBootTest(
	  			webEnvironment = WebEnvironment.RANDOM_PORT,	-- Random Port
	  			classes = Application.class)
	  	@AutoConfigureMockMvc
	

 *
 */


/*
 * @WebMvcTest
 * 
 * Se usa para pruebas mvc (controller, ...) ligeras. No necesita cargar todo el contexto de app.
 * 
 * Using this annotation will disable full auto-configuration and instead apply only configuration relevant to MVC tests 
 * (i.e. @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter, WebMvcConfigurer 
 * and HandlerMethodArgumentResolver beans but not @Component, @Service or @Repository beans). 

 * By default, tests annotated with @WebMvcTest will also auto-configure Spring Security and MockMvc 
 * (include support for HtmlUnit WebClient and Selenium WebDriver). 
 * For more fine-grained control of MockMVC the @AutoConfigureMockMvc annotation can be used. 

 */
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from index")));
    }
}
