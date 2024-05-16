package live.smoothing.messenger.service;

import live.smoothing.messenger.hook.UserRole;

import java.util.List;

public interface UserService {

    List<String> getHookUrls(Integer hookTypeId);

    List<String> getUrlsByUserRole(UserRole userRole, Integer hookTypeId);
}
