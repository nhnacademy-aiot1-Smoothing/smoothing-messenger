package live.smoothing.messenger.dto.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mail Response Header DTO
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
public class Header {

    private Integer resultCode;
    private String resultMessage;
    private Boolean isSuccessful;
}
