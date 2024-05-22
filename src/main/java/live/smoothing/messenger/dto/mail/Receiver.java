package live.smoothing.messenger.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Mail Request Receiver DTO
 *
 * @author 김지윤
 */
@Getter
@AllArgsConstructor
public class Receiver {

    private String receiveMailAddr;
}
