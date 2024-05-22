package live.smoothing.messenger.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Getter
@Setter
@ConfigurationProperties(prefix = "dooray")
public class DoorayHookProperties {

    private String hookUrl;

}
