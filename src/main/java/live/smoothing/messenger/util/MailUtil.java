package live.smoothing.messenger.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * Email 전송 유틸리티 클래스
 *
 * @author 김지윤
 */
@Component
public class MailUtil {

    private JavaMailSender mailSender;
    private MimeMessage message;
    private MimeMessageHelper messageHelper;

    public MailUtil(JavaMailSender mailSender) throws MessagingException {

        this.mailSender = mailSender;
        message = this.mailSender.createMimeMessage();
        messageHelper = new MimeMessageHelper(message, true, "UTF-8");
    }

    /**
     * Email 제목 설정 메서드
     *
     * @param subject email 제목
     */
    public void setSubject(String subject) throws MessagingException {

        messageHelper.setSubject(subject);
    }

    /**
     * Email 내용 설정 메서드
     *
     * @param htmlContent email 내용
     */
    public void setText(String htmlContent) throws MessagingException {

        messageHelper.setText(htmlContent, true);
    }

    /**
     * Email 발신자 설정 메서드
     *
     * @param email 발신자의 email
     * @param name 발신자의 이름
     */
    public void setFrom(String email, String name) throws UnsupportedEncodingException, MessagingException {

        messageHelper.setFrom(email, name);
    }

    /**
     * Email 수신자 설정 메서드
     *
     * @param email 수신자의 email
     */
    public void setTo(String email) throws MessagingException {

        messageHelper.setTo(email);
    }

    /**
     * 설정한 내용을 바탕으로 이메일을 보내는 메서드
     *
     */
    public void send() {

        mailSender.send(message);
    }
}
