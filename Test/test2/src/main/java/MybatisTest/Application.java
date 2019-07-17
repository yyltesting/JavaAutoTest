package MybatisTest;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {
	
	private static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.context=SpringApplication.run(Application.class, args);
	}
	@PreDestroy
	public void close(){
		Application.context.close();
	}
}
