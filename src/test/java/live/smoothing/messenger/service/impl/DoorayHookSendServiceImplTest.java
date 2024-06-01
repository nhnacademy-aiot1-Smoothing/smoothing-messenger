package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.dto.DoorayHookDTO;
import live.smoothing.messenger.hook.DoorayHook;
import live.smoothing.messenger.hook.DoorayHookSender;
import live.smoothing.messenger.hook.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
class DoorayHookSendServiceImplTest {

    @Value("${rabbitmq.hook-exchange-name}")
    private String hookExchangeName;

    @Value("${rabbitmq.hook-routing-key}")
    private String hookRoutingKey;

    @Mock
    private DoorayHookSender doorayHookSender;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private DoorayHookSendServiceImpl doorayHookSendService;

    @Test
    void sendToQueue() {
        DoorayHookDTO doorayHookDTO = new DoorayHookDTO(UserRole.ROLE_ADMIN, "관리자 메세지");

        doorayHookSendService.sendToQueue(doorayHookDTO);

        verify(rabbitTemplate, times(1)).convertAndSend(eq(hookExchangeName), eq(hookRoutingKey), eq(doorayHookDTO));
    }

    @Test
    void sendHook() {

        DoorayHookDTO doorayHookDTO = new DoorayHookDTO(UserRole.ROLE_ADMIN, "관리자 메세지");
        doorayHookSendService.sendHook(doorayHookDTO);

        verify(doorayHookSender, times(1)).send(any(DoorayHook.class), eq(UserRole.ROLE_ADMIN));
    }
}