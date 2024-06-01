package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.adapter.MailAdapter;
import live.smoothing.messenger.dto.SenderInfo;
import live.smoothing.messenger.dto.mail.Receiver;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import live.smoothing.messenger.dto.mail.SendMailResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MailServiceImplTest {

    @Mock
    private SenderInfo senderInfo;

    @Mock
    private MailAdapter mailAdapter;

    @InjectMocks
    private MailServiceImpl mailService;

    @Test
    void writeMail() {

        Receiver receiver = new Receiver("test@gmail.com");
        String title = "test";
        String body = "test mail";

        when(senderInfo.getEmail()).thenReturn("admin@gmail.com");
        when(senderInfo.getName()).thenReturn("관리자");

        SendMailRequest sendMailRequest = mailService.writeMail(receiver, title, body);

        assertNotNull(sendMailRequest);
        assertEquals(title, sendMailRequest.getTitle());
        assertEquals(body, sendMailRequest.getBody());
        assertEquals("admin@gmail.com", senderInfo.getEmail());
        assertEquals("관리자", senderInfo.getName());
        assertEquals(receiver, sendMailRequest.getReceiver());
    }

    @Test
    void sendMail() {

        String secret = "testSecret";
        SendMailRequest sendMailRequest = new SendMailRequest("admin@gmail.com", "관리자", "제목", "내용", new Receiver("test@gmail.com"));
        SendMailResponse sendMailResponse = mailService.sendMail(secret, sendMailRequest);

        when(mailAdapter.sendMail(secret, sendMailRequest)).thenReturn(sendMailResponse);

        SendMailResponse response = mailService.sendMail(secret, sendMailRequest);

        assertEquals(sendMailResponse, response);

    }
}