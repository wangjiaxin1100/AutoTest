package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//入口类
@SpringBootApplication
//扫描包下的类，托管给Spingboot
@ComponentScan("com.course")
public class Application {
    public static void main (String[] args){
        SpringApplication.run((Application.class));
    }

}

