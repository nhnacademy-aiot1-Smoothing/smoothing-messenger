package live.smoothing.messenger.hook;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
public class DoorayHookSender {

    private RestTemplate restTemplate;

    private List<String> urls;

    public void send(DoorayHook doorayHook) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<DoorayHook> entity = new HttpEntity<>(doorayHook, headers);

        for (String url : urls) {
            ResponseEntity<String> exchange = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        }
    }

}
