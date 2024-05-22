package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.dto.MessageDTO;
import live.smoothing.messenger.service.MailSendService;
import live.smoothing.messenger.service.MessageConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Message Queue에서 메세지를 받아오는 클래스
 *
 * @author 김지윤
 */
@Slf4j
@RequiredArgsConstructor
@Service("messageConsumerService")
public class MessageConsumerServiceImpl implements MessageConsumerService {

    private final MailSendService mailSendService;

    /**
     * {@inheritDoc}
     */
    @Override
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(MessageDTO messageDTO) throws MessagingException, UnsupportedEncodingException { // Consumer 역할

        log.info("Received Message :{}", messageDTO.getEventMessage());

//        mailSendService.sendMail(messageDTO);
    }
}
