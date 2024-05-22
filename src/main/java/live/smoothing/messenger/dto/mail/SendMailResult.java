package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mail Response result DTO
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
public class SendMailResult {

    private String receiveMailAddr;
    private String receiveName;
    private String receiveType;
    private Integer resultCode;
    private String resultMessage;
}
