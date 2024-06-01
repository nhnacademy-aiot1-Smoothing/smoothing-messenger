package live.smoothing.messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * user-service 에서 받아오는 hook 정보 DTO
 * 회원 아이디, 회원이 설정한 url
 *
 * @author 김지윤
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HookUrlResponse {

    private String userId;
    private String hookUrl;
}
