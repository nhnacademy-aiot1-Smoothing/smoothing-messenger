package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.dto.CertificationMessage;
import live.smoothing.messenger.dto.mail.Receiver;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import live.smoothing.messenger.service.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
class MessageConsumerServiceImplTest {

    @Mock
    private MailService mailService;

    @InjectMocks
    private MessageConsumerServiceImpl messageConsumerService;

    @Value("${mail.secret}")
    private String secret;

    private CertificationMessage certificationMessage;

    @BeforeEach
    void setUp() {
        certificationMessage = new CertificationMessage();
        certificationMessage.setEmail("test@gmail.com");
        certificationMessage.setCertificationNumber("12345");
    }
    @Test
    void receiveCertificationMessage() {

        String title = "smoothing 인증번호 메일입니다.";
        String body = "인증번호는 12345 입니다.";
        SendMailRequest sendMailRequest = new SendMailRequest("admin@gmail.com", "관리자", title, body, new Receiver(certificationMessage.getEmail()));

        when(mailService.writeMail(any(Receiver.class), eq(title), eq(body))).thenReturn(sendMailRequest);

        messageConsumerService.receiveCertificationMessage(certificationMessage);

        verify(mailService, times(1)).writeMail(any(Receiver.class), eq(title), eq(body));
        verify(mailService, times(1)).sendMail(eq(secret), eq(sendMailRequest));
        verifyNoMoreInteractions(mailService);
    }
}