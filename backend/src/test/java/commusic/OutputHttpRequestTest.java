package commusic;

import org.junit.runner.RunWith;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OutputHttpRequestTest {
  
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;
  
  @Test
  public void urlShouldReturnDefault() throws Exception {
	  System.out.println(this.restTemplate.getForObject("http://localhost:" + port + "/output", String.class));
	  assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/output", String.class)).contains("https://example.com");
  }
}