package GetTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//托管的类
@SpringBootApplication
//扫描哪个包路径下的类
@ComponentScan("GetTest.ServerController,config")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
