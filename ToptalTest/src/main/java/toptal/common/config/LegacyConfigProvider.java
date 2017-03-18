package toptal.common.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("toptal.legacy")
@ConditionalOnProperty(name = "legacy", havingValue = "true")
public class LegacyConfigProvider {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmd = new DriverManagerDataSource();
	    return dmd;
	}
	
}