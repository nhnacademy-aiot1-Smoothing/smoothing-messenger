package live.smoothing.messenger.dto;

import live.smoothing.messenger.hook.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * hook 전송 시 필요한 정보를 담고있는 DTO
 * 회원 권한, 메세지 내용
 *
 * @author 김지윤
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoorayHookDTO {

    private UserRole userRole;
    private String message;
}
