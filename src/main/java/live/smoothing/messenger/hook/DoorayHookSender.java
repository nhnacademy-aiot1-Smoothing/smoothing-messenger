package live.smoothing.messenger.hook;

import live.smoothing.messenger.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class DoorayHookSender {

    private RestTemplate restTemplate;

    private final UserService userService;

    public void send(DoorayHook doorayHook, UserRole userRole) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<DoorayHook> entity = new HttpEntity<>(doorayHook, headers);

        List<String> adminUrls = userService.getUrlsByUserRole(UserRole.ROLE_ADMIN, 1);
        List<String> userUrls = userService.getUrlsByUserRole(UserRole.ROLE_USER, 1);
        List<String> allUrls = userService.getHookUrls(1);

        switch(userRole) {

            case ROLE_ADMIN:
                sendToUrls(adminUrls, entity);
                break;

            case ROLE_USER:
                sendToUrls(userUrls, entity);
                break;

            default:
                sendToUrls(allUrls, entity);
                break;
        }
    }

    private void sendToUrls(List<String> urls, HttpEntity<DoorayHook> entity) {
        for (String url : urls) {
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            log.info(exchange.getBody());
        }
    }

}
