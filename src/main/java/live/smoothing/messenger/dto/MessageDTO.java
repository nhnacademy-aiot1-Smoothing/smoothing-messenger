package live.smoothing.messenger.dto;

import lombok.*;

/**
 *  Message Queue에서 받아올 메세지 DTO
 *
 * @author 김지윤
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private String email;
    private String title;
    private String eventMessage;
}
