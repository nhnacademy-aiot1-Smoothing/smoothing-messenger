package live.smoothing.messenger.dto;

import live.smoothing.messenger.hook.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoorayHookDTO {

    private UserRole userRole;
    private String message;
}
