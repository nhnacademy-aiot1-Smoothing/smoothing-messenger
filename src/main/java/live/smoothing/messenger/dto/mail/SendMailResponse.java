package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendMailResponse {

    private Header header;
    private SendMailResponseBody body;

}
