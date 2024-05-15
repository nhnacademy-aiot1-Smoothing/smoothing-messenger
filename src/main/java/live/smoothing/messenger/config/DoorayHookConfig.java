package live.smoothing.messenger.config;

import live.smoothing.messenger.hook.DoorayHookSender;
import live.smoothing.messenger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DoorayHookConfig {

    private final UserService userService;

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate) {

        List<String> urls = userService.getHookUrls(1);
        return new DoorayHookSender(restTemplate, urls);
    }
}