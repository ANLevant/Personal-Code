package toptal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToptalTestApplication {
	
	@Value("${application.mode}")
	private String applicationMode;

	public static void main(String[] args) {
		SpringApplication.run(ToptalTestApplication.class, args);
	}
}
