package live.smoothing.messenger.service;

import live.smoothing.messenger.dto.mail.Receiver;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import live.smoothing.messenger.dto.mail.SendMailResponse;

public interface MailService {

    SendMailRequest writeMail(Receiver receiver, String title, String body);

    SendMailResponse sendMail(String secret, SendMailRequest request);
}
