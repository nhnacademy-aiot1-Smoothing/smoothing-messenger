package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.adapter.UserAdapter;
import live.smoothing.messenger.dto.HookUrlResponse;
import live.smoothing.messenger.dto.RoleResponse;
import live.smoothing.messenger.hook.UserRole;
import live.smoothing.messenger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAdapter userAdapter;

    @Override
    public List<String> getHookUrls(Integer hookTypeId) {

        List<String> hookUrls = new ArrayList<>();
        List<HookUrlResponse> usersHookList = userAdapter.getUsersHookList(hookTypeId);

        for (HookUrlResponse response : usersHookList) {
            hookUrls.add(response.getHookUrl());
        }

        return hookUrls;
    }

    @Override
    public List<String> getUrlsByUserRole(UserRole userRole, Integer hookTypeId) {

        List<String> urls = new ArrayList<>();
        List<HookUrlResponse> usersHookList = userAdapter.getUsersHookList(hookTypeId);

        for (HookUrlResponse response : usersHookList) {

            List<RoleResponse> userRoles = userAdapter.getUserRoles(response.getUserId());

            for (RoleResponse role : userRoles) {
                if (userRole.name().equals(role.getRoleInfo())) {
                    urls.add(response.getHookUrl());
                }
            }

        }
        return urls;
    }
}
