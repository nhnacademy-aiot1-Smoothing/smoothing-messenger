package live.smoothing.messenger.service;

import live.smoothing.messenger.dto.CertificationMessage;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Message Queue에서 메세지를 받아오는 인터페이스
 *
 * @author 김지윤
 */
public interface MessageConsumerService {

    /**
     * Message Queue에 메세지를 받아오는 메서드
     *
     * @param certificationMessage queue에서 받아온 메세지를 담고 있는 객체
     */
    void receiveCertificationMessage(CertificationMessage certificationMessage) throws MessagingException, UnsupportedEncodingException;
}
