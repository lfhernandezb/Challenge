package com.example.challenge;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.challenge.services.CharacterServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
//@WebMvcTest(MainController.class)
//@ComponentScan({"com.example.challenge"})
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = SpringTestConfig.class)
@SpringBootTest
class ChallengeApplicationTests {
	
	private static final Logger logger = Logger.getLogger(ChallengeApplicationTests.class.getName());
	/*
    @Autowired
    private MockMvc mvc;

	@Test
	void getCharacterNumberOne() {
        try {
			mvc.perform(get("/api/character/1")
				      .contentType(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk())
				      .andExpect(jsonPath("$[0].name", is("Rick Sanchez")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	*/
	/*
    @TestConfiguration
    static class CharacterServiceImplTestContextConfiguration {
 
    	//@Autowired
    	//private RestTemplate restTemplate;

    	@Bean
    	public RestTemplateBuilder restTemplateBuilder() {
    	   // Do any additional configuration here
    	   return new RestTemplateBuilder();
    	}
    	
        
    }
    */
    /*
    @Autowired
    private MockMvc mvc;
	
    @Autowired 
    private MockRestServiceServer server;
    
    @Mock 
    private RestTemplateBuilder restTemplateBuilder;
 
	@Mock
	private RestTemplate restTemplate;
	
    @Test //(expected = NotFoundException.class)
    public void  givenRemoteApiCall_when404Error_thenThrowNotFound() {
        //Assert.assertNotNull(this.builder);
        // Assert.assertNotNull(this.server);

         this.server
          .expect(ExpectedCount.once(), requestTo("/api/character/1000"))
          .andExpect(method(HttpMethod.GET))
          .andRespond(withStatus(HttpStatus.NOT_FOUND));

        Character response = restTemplate 
          .getForObject("/api/character/1000", Character.class);
        this.server.verify();
    }
    */
    @Autowired
    private CharacterServiceImpl characterService;

	@Autowired
	private MainController mainController;

    //private MockRestServiceServer mockServer;

    //private ObjectMapper mapper = new ObjectMapper();
    /*
    @Before
    public void init() {
    	
        mockServer = MockRestServiceServer //.createServer(restTemplate);
        		.bindTo(restTemplate)
        	      .bufferContent()
        	      .build();
        
        logger.setLevel(Level.FINE);
        logger.addHandler(new ConsoleHandler());

    	logger.info(restTemplate.toString());
        mockServer = MockRestServiceServer.(restTemplate);
        logger.info(mockServer.toString());
    }
    */
    @Test
    public void contextLoads() throws Exception {
		assertThat(mainController).isNotNull();
		//assertThat(mockServer).isNotNull();
	}
    /*
    @Test
    public void givenMockingIsDoneByMockRestServiceServer_whenGetIsCalled_shouldReturnMockedObject() throws Exception {
        //Character character = new Character();

        mockServer.expect(ExpectedCount.once(),
          requestTo("/api/character/1"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withStatus(HttpStatus.OK)
              .contentType(MediaType.APPLICATION_JSON));
              //.body(mapper.writeValueAsString(emp)));

        Character character = characterService.getCharacter("1");
        mockServer.verify();
        //Assert.assertEquals(emp, employee);
    }
    */
}
