package commusic;

import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputServiceTest {

  @Autowired
  private OutputController controller;

  @Test
  public void contexLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

  @Test
  public void testOutputVideoURLExampleTest() {
    assertEquals("https://example.com", new OutputService().getVideoURL());
  }
}