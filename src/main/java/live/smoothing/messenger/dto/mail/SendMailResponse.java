package live.smoothing.messenger.dto.mail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 메일 발송 시 서버의 응답 메세지를 담고있는 DTO
 *
 * @author 김지윤
 */
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class SendMailResponse {

    private Header header;
    private SendMailResponseBody body;
}
