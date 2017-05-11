import eli.user.UserController;
import eli.user.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= UserController.class)
//@SpringApplicationConfiguration(classes=MicroserviceUserServiceApplicationTests.class)
@SpringBootTest(classes=MicroserviceUserServiceApplicationTests.class)
public class MicroserviceUserServiceApplicationTests {
  @Autowired
    private WebApplicationContext webContext;
  private MockMvc mockMvc;
  @Before
    public void setMockMvc(){
      //mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

  }
  @Test
    public void  findUserTest() throws Exception{

      User user=new User();
      user.setId("5");
      user.setAddress("shanxin");
      user.setName("Eli");
    /*request = MockMvcRequestBuilders.post("/users")

            .param("id","1")

            .param("name","林峰")

            .param("age","20")*/

    ;
        /*mockMvc.perform(MockMvcRequestBuilders.get("/user/5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.model().attribute("user",
                        Matchers.contains(Matchers.samePropertyValuesAs(user))));*/
    mockMvc.perform(MockMvcRequestBuilders.get("/user/5"))
            .andExpect(MockMvcResultMatchers.status().isOk())
             .andExpect(MockMvcResultMatchers.content().string("{\"id\":5,\"name\":\"Eli\",\"address\":\"shanxin\"}"));
        /*String ss=mockMvc.perform(MockMvcRequestBuilders.get("/user/5")
                .contentType(MediaType.APPLICATION_JSON)

        ).andReturn().getResponse().getContentAsString();

        System.out.println(ss);*/
  }
}
