package commusic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutputController {

  @RequestMapping("/output")
  public Output output() {
    return new Output();
  }
}