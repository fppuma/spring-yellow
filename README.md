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

