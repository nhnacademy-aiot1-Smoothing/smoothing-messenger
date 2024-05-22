package live.smoothing.messenger.hook;

import live.smoothing.messenger.dto.DoorayHookDTO;
import live.smoothing.messenger.service.DoorayHookSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DoorayHookController {

    private final DoorayHookSendService doorayHookSendService;

    @PostMapping("/sendHook")
    public ResponseEntity<Void> sendHook(@RequestBody DoorayHookDTO doorayHookDTO) {

        doorayHookSendService.sendToQueue(doorayHookDTO);

        return ResponseEntity.ok().build();
    }
}
