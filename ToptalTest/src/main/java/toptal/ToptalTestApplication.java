package toptal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("toptal.common")
public class ToptalTestApplication {
	
	@Value("${application.mode}")
	private String applicationMode;

	public static void main(String[] args) {
		SpringApplication.run(ToptalTestApplication.class, args);
	}

}
