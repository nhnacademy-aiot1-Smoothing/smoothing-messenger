package live.smoothing.messenger.config;

import live.smoothing.messenger.hook.DoorayHookSender;
import live.smoothing.messenger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Dooray Hook 설정 클래스
 *
 * @author 김지윤
 */
@Configuration
@RequiredArgsConstructor
public class DoorayHookConfig {

    private final UserService userService;

    /**
     * RestTemplate 생성
     *
     * @return 생성된 RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    /**
     * dooray hook을 보내주는 DoorayHookSender
     *
     * @return 생성된 DoorayHookSender
     */
    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate) {

        return new DoorayHookSender(restTemplate, userService);
    }
}
