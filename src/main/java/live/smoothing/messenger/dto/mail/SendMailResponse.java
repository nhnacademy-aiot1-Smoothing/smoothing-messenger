package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 메일 발송 시 서버의 응답 메세지를 담고있는 DTO
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
public class SendMailResponse {

    private Header header;
    private SendMailResponseBody body;

}
