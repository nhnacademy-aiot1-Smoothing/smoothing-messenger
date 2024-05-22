package live.smoothing.messenger.service;

import live.smoothing.messenger.dto.DoorayHookDTO;

/**
 * Dooray hook을 보내기 위한 인터페이스
 *
 * @author 김지윤
 */
public interface DoorayHookSendService {

    /**
     * 회원 권한과 메세지를 담고 있는 doorayHookDTO를 Message Queue로 전송
     *
     * @param doorayHookDTO hook 전송에 필요한 내용을 담고있는 DTO
     */
    void sendToQueue(DoorayHookDTO doorayHookDTO);

    /**
     * MessageQueue에서 받아온 메세지를 바탕으로 hook 전송
     *
     * @param doorayHookDTO hook 전송에 필요한 내용을 담고있는 DTO
     */
    void sendHook(DoorayHookDTO doorayHookDTO);
}
