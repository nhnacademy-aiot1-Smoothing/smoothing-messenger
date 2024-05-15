package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.hook.DoorayHook;
import live.smoothing.messenger.hook.DoorayHookSender;
import live.smoothing.messenger.dto.DoorayHookDTO;
import live.smoothing.messenger.service.DoorayHookSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoorayHookSendServiceImpl implements DoorayHookSendService {

    private final DoorayHookSender doorayHookSender;

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.hook-exchange-name}")
    private String hookExchangeName;

    @Value("${rabbitmq.hook-routing-key}")
    private String hookRoutingKey;

    @Override
    public void send(DoorayHookDTO doorayHookDTO) {

        log.info("Send dooray message : {}", doorayHookDTO.getMessage());
        rabbitTemplate.convertAndSend(hookExchangeName, hookRoutingKey, doorayHookDTO);
    }

    @Override
    @RabbitListener(queues = "${rabbitmq.hook-queue}")
    public void sendHook(DoorayHookDTO doorayHookDTO) {

        log.info("Received dooray message : {}", doorayHookDTO.getMessage());
        doorayHookSender.send(DoorayHook.builder().botName("관리자").text(doorayHookDTO.getMessage()).build());
    }
}
