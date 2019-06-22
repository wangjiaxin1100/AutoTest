package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//SpringBoot 通过访问localhost:8080，内置Web服务器
@RestController
@EnableAutoConfiguration
//托管类
public class SamperController {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World!";
    }
    public static void main(String[] args)  throws Exception
    {
//        入口类
        SpringApplication.run(SamperController.class, args);
    }

}
