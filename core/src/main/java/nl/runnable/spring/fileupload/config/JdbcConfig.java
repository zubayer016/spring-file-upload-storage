package nl.runnable.spring.fileupload.config;

import nl.runnable.spring.fileupload.MultipartFileRepository;
import nl.runnable.spring.fileupload.impl.JdbcMultipartFileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Laurens Fridael
 */
@Configuration
public class JdbcConfig {

  @Bean
  MultipartFileRepository multipartFileRepository() {
    return new JdbcMultipartFileRepository();
  }

}
