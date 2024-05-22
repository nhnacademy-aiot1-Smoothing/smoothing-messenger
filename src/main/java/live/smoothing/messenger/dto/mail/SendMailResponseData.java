package live.smoothing.messenger.dto.mail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Mail Response data DTO
 *
 * @author 김지윤
 */
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class SendMailResponseData {

    private String requestId;
    private List<SendMailResult> results;
}
