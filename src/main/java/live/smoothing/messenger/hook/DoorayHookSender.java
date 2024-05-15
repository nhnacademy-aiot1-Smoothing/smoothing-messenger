package live.smoothing.messenger.hook;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



@AllArgsConstructor
public class DoorayHookSender {

    private RestTemplate restTemplate;

    private String url;

    public void send(DoorayHook doorayHook) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<DoorayHook> entity = new HttpEntity<>(doorayHook, headers);
        ResponseEntity<String> exchange = this.restTemplate.exchange(this.url, HttpMethod.POST, entity, String.class, new Object[0]);
    }

}
