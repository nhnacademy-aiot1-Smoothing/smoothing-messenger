package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mail Response body DTO
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
public class SendMailResponseBody {

    private SendMailResponseData data;
}
