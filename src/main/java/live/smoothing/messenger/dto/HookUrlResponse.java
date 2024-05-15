package live.smoothing.messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HookUrlResponse {

    private String userId;
    private String hookUrl;
}
