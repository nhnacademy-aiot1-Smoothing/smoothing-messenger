package live.smoothing.messenger.hook;

import live.smoothing.messenger.dto.DoorayHookDTO;
import live.smoothing.messenger.service.DoorayHookSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Message Queue로 hook 메세지 전송
 *
 * @author 김지윤
 */
@RestController
@RequiredArgsConstructor
public class DoorayHookController {

    private final DoorayHookSendService doorayHookSendService;

    /**
     * 회원 권한과 메세지를 담고 있는 doorayHookDTO를 Message Queue로 전송
     *
     * @param doorayHookDTO hook 전송에 필요한 내용을 담고있는 DTO
     */
    @PostMapping("/sendHook")
    public ResponseEntity<Void> sendHookToQueue(@RequestBody DoorayHookDTO doorayHookDTO) {

        doorayHookSendService.sendToQueue(doorayHookDTO);

        return ResponseEntity.ok().build();
    }
}
