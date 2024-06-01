package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.dto.CertificationMessage;
import live.smoothing.messenger.dto.mail.Receiver;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import live.smoothing.messenger.service.MailService;
import live.smoothing.messenger.service.MessageConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Message Queue에서 메세지를 받아오는 클래스
 * 받아온 메세지를 바탕으로 인증번호 발급 메일을 발송한다.
 *
 * @author 김지윤
 */
@Slf4j
@RequiredArgsConstructor
@Service("messageConsumerService")
public class MessageConsumerServiceImpl implements MessageConsumerService {

    @Value("${mail.secret}")
    private String secret;

    private final MailService mailService;

    /**
     * {@inheritDoc}
     */
    @Override
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveCertificationMessage(CertificationMessage certificationMessage) {

        log.info("Received Message :{}", certificationMessage.getCertificationNumber());

        String title = "smoothing 인증번호 메일입니다.";
        String body = "인증번호는 " + certificationMessage.getCertificationNumber() + " 입니다.";

        SendMailRequest request = mailService.writeMail(new Receiver(certificationMessage.getEmail()), title, body);

        mailService.sendMail(secret, request);
    }
}
