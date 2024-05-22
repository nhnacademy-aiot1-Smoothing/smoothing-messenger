package live.smoothing.messenger.dto.mail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mail Response body DTO
 *
 * @author 김지윤
 */
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class SendMailResponseBody {

    private SendMailResponseData data;
}
