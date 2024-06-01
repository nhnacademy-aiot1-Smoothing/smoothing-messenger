package live.smoothing.messenger.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 메일 발송 시 필요한 정보를 담고있는 DTO
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendMailRequest {

    private String senderAddress;
    private String senderName;
    private String title;
    private String body;
    private Receiver receiver;
}
