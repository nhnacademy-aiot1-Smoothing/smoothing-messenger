package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Header {

    private Integer resultCode;
    private String resultMessage;
    private Boolean isSuccessful;
}
