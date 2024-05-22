//package live.smoothing.messenger.service.impl;
//
//import live.smoothing.messenger.dto.MessageDTO;
//import live.smoothing.messenger.service.MailSendService;
//import live.smoothing.messenger.util.MailUtil;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import java.io.UnsupportedEncodingException;
//
///**
// * Mail을 전송하기 위한 클래스
// *
// * @author 김지윤
// */
//@Slf4j
//@RequiredArgsConstructor
//@Service("mailSendService")
//public class MailSendServiceImpl implements MailSendService {
//
//    private final MailUtil mailUtil;
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void sendMail(MessageDTO messageDTO) throws MessagingException, UnsupportedEncodingException {
//
//        try {
//            mailUtil.setSubject(messageDTO.getTitle());
//            mailUtil.setText(messageDTO.getEventMessage());
//            mailUtil.setFrom("cs.smoothing@gmail.com", "관리자");
//            mailUtil.setTo(messageDTO.getEmail());
//
//            mailUtil.send();
//            log.info("메일 전송 완료");
//        } catch(Exception e) {
//            log.error("메일 전송 중 오류 발생: {}", e.getMessage());
//        }
//    }
//}
