package live.smoothing.messenger.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 메일 발송 시 필요한 정보를 담고있는 DTO
 *
 * @author 김지윤
 */

@AllArgsConstructor
public class SendMailRequest {

    private String senderAddress;
    private String senderName;
    @Getter
    private String title;
    @Getter
    private String body;
    @Getter
    private Receiver receiver;
}
