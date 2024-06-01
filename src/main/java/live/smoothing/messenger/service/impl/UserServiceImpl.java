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

/**
 * 회원이 설정한 hook url을 가져오기 위한 클래스
 *
 * @author 김지윤
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAdapter userAdapter;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHookUrls(Integer hookTypeId) {

        List<String> hookUrls = new ArrayList<>();
        List<HookUrlResponse> usersHookList = userAdapter.getUsersHookList(hookTypeId);

        for (HookUrlResponse response : usersHookList) {
            hookUrls.add(response.getHookUrl());
        }

        return hookUrls;
    }

    /**
     * {@inheritDoc}
     */
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
