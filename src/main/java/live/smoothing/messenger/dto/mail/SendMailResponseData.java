package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Mail Response data DTO
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
public class SendMailResponseData {

    private String requestId;
    private List<SendMailResult> results;
}
