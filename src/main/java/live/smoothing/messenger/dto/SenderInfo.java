package live.smoothing.messenger.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 메일 발신자의 정보를 담고있는 DTO
 * 발신자 이메일, 발신자 이름
 *
 * @author 김지윤
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mail.sender")
public class SenderInfo {

    private String email;
    private String name;
}
