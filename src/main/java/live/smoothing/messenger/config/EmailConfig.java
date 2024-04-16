package live.smoothing.messenger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Email 전송 설정 클래스
 *
 * @author 김지윤
 */
@Configuration
@PropertySource("classpath:secret.properties")
public class EmailConfig {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    /**
     * Email 을 전송하기 위한 JavaMailSender 등록
     *
     * @return Gmail SMTP 서버의 호스트, 포트 및 사용자 자격 증명이 설정된 mailSender
     */
    @Bean
    public JavaMailSender mailSender() {

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}
