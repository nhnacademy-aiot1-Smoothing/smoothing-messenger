package live.smoothing.messenger.service;

import live.smoothing.messenger.dto.mail.Receiver;
import live.smoothing.messenger.dto.mail.SendMailRequest;
import live.smoothing.messenger.dto.mail.SendMailResponse;

/**
 * Mail을 전송하기 위한 인터페이스
 *
 * @author 김지윤
 */
public interface MailService {

    /**
     * 메일 전송에 필요한 request 객체를 만들기 위한 메서드
     *
     * @param receiver 수신자 정보
     * @param title 메일 제목
     * @param body 메일 내용
     * @return 메일 전송에 필요한 request 객체
     */
    SendMailRequest writeMail(Receiver receiver, String title, String body);

    /**
     * secret key를 사용해 메일을 전송하는 메서드
     *
     * @param secret secret key
     * @param request 메일 전송에 필요한 request 객체
     * @return 메일 발송 성공/실패 응답
     */
    SendMailResponse sendMail(String secret, SendMailRequest request);
}
