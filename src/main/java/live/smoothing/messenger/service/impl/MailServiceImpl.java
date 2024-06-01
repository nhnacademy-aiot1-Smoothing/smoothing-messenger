package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.adapter.MailAdapter;
import live.smoothing.messenger.dto.SenderInfo;
import live.smoothing.messenger.dto.mail.Receiver;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import live.smoothing.messenger.dto.mail.SendMailResponse;
import live.smoothing.messenger.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Mail을 전송하기 위한 클래스
 *
 * @author 김지윤
 */
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final SenderInfo senderInfo;

    private final MailAdapter mailAdapter;

    /**
     * {@inheritDoc}
     */
    @Override
    public SendMailRequest writeMail(Receiver receiver, String title, String body) {

        return new SendMailRequest(senderInfo.getEmail(), senderInfo.getName(), title, body, receiver);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendMailResponse sendMail(String secret, SendMailRequest request) {

        return mailAdapter.sendMail(secret, request);
    }
}
