# spring-yellow
Spring 3 and Java 17

## Starters
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
``` 

## Logger
In the application.properties
```
logging.level.web=debug
```

## Unit Test

HelloControllerUnitTest.java
```java
HelloController controller = new HelloController();
Model model = new BindingAwareModelMap(); // this seems a mock
String result = controller.getMessage("World", model); //GET method as simple method
```

```java
@WebMvcTest(HelloController.class)
public class HelloControllerMockMvcTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void testGetMessage() {
    
  }
}
```

## Functional Test
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {
  @Autowired
  private TestRestTemplate template
  
  @Test
  public void greetObjectTest() {
    //template.getForObject
    Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
    assertEquals("Hello, Dolly!", response.message());

  }

  @Test
  public void greetEntityTest() {
    //template.getForEntity
    ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
    Greeting response = entity.getBody();
    if (response != null) {
        assertEquals("Hello, World!", response.message());
    }
  }
}
```

