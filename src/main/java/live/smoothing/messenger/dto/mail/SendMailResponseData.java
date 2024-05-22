package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SendMailResponseData {

    private String requestId;
    private List<SendMailResult> results;
}
