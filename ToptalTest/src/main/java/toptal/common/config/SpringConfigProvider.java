package toptal.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("toptal.spring")
@ConditionalOnProperty(name = "legacy", havingValue = "false")
public class SpringConfigProvider {
}