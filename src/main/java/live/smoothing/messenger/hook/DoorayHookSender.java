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

/**
 * dooray hook을 보내주기 위한 클래스
 *
 * @author 김지윤
 */
@Slf4j
@AllArgsConstructor
public class DoorayHookSender {

    private RestTemplate restTemplate;

    private final UserService userService;

    /**
     * 회원 권한에 따라 메세지를 보낼 수 있는 메서드
     *
     * @param doorayHook doorayHook 객체
     * @param userRole 회원 권한
     */
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

    /**
     * 회원 권한에 따라 메세지를 보낼 수 있는 메서드
     *
     * @param urls 권한에 따른 hook url list
     * @param entity DoorayHook을 담고있는 HttpEntity
     */
    private void sendToUrls(List<String> urls, HttpEntity<DoorayHook> entity) {
        for (String url : urls) {
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            log.info(exchange.getBody());
        }
    }

}
