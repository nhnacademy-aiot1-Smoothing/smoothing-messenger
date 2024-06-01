package live.smoothing.messenger.hook;

import live.smoothing.messenger.dto.DoorayHookDTO;
import live.smoothing.messenger.service.DoorayHookSendService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DoorayHookControllerTest {

    @Mock
    private DoorayHookSendService doorayHookSendService;

    @InjectMocks
    private DoorayHookController doorayHookController;

    @Test
    void sendHookToQueue() {
        DoorayHookDTO doorayHookDTO = new DoorayHookDTO(UserRole.ROLE_ADMIN, "관리자 메세지");

        ResponseEntity<Void> responseEntity = doorayHookController.sendHookToQueue(doorayHookDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(doorayHookSendService, times(1)).sendToQueue(eq(doorayHookDTO));
    }
}