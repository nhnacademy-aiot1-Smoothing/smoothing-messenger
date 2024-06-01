package live.smoothing.messenger.adapter;

import live.smoothing.messenger.dto.mail.SendMailResponse;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "mailService", url = "${mail.url}")
public interface MailAdapter {

    @PostMapping("/email/v2.1/appKeys/${mail.appkey}/sender/auth-mail")
    SendMailResponse sendMail(@RequestHeader("X-Secret-Key") String secret,
                              @RequestBody SendMailRequest request);

}
