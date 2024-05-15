package live.smoothing.messenger.config;

import live.smoothing.messenger.hook.DoorayHookSender;
import live.smoothing.messenger.properties.DoorayHookProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class DoorayHookConfig {


    private final DoorayHookProperties properties;

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate) {

        return new DoorayHookSender(restTemplate, properties.getHookUrl());
    }
}
