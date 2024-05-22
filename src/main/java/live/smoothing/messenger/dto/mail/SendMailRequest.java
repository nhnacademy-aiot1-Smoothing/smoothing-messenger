package live.smoothing.messenger.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendMailRequest {

    private String senderAddress;
    private String senderName;
    private String title;
    private String body;
    private Receiver receiver;
}
