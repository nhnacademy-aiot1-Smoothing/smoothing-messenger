package live.smoothing.messenger.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 사용자의 이메일과 인증번호를 담고있는 DTO
 *
 * @author 김지윤
 */
@Getter
@Setter
@NoArgsConstructor
public class CertificationMessage {

    private String email;
    private String certificationNumber;
}
