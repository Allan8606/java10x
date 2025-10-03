package allan.dev.Docker_Aula10x;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {


    @GetMapping("/docker")
    public String menssagem(){
        return "Hello World Docker 10x";
    }
}
