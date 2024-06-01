package live.smoothing.messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * user-service 에서 받아오는 권한 정보 DTO
 * 권한 아이디, 권한명
 *
 * @author 김지윤
 */
@Getter
@AllArgsConstructor
public class RoleResponse {

    private Long roleId;
    private String roleInfo;
}
