package live.smoothing.messenger.service;

import live.smoothing.messenger.dto.DoorayHookDTO;

public interface DoorayHookSendService {

    void send(DoorayHookDTO doorayHookDTO);

    void sendHook(DoorayHookDTO doorayHookDTO);
}
