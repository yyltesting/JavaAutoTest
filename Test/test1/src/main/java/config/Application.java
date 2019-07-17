package config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//托管的类
@SpringBootApplication
//扫描哪个包路径下的类
@ComponentScan("GetTest.ServerController,PostTest.ServerController,config")
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}
