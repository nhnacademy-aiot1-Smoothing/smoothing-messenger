package live.smoothing.messenger.service;

import live.smoothing.messenger.dto.DoorayHookDTO;

public interface DoorayHookSendService {

    void sendToQueue(DoorayHookDTO doorayHookDTO);

    void sendHook(DoorayHookDTO doorayHookDTO);
}
