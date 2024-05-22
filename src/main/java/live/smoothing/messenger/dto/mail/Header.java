package live.smoothing.messenger.dto.mail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Mail Response Header DTO
 *
 * @author 김지윤
 */
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class Header {

    private Integer resultCode;
    private String resultMessage;
    private Boolean isSuccessful;
}
