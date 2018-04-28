package pl.school.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class) // SpringRunner is an alias for the SpringJUnit4ClassRunner.

//those two below inject a MockMvc instance.
@SpringBootTest // we are asking for the whole application context to be created. An alternative would be 
// to ask Spring Boot to create only the web layers of the context using the @WebMvcTest

@AutoConfigureMockMvc
public class HelloControllerTest {
/*
	MockMvc comes from Spring Test and allows you, via a set of convenient builder classes, to send 
	HTTP requests into the DispatcherServlet and make assertions about the result. 
	*/
    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot HelloController!")));
    }
}