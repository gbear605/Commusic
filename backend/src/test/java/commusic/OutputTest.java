package commusic;

import commusic.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OutputTest {

  @Test
  public void testOutputVideoURLExampleTest() {
    assertEquals("https://example.com", new Output().getVideoURL());
  }
}