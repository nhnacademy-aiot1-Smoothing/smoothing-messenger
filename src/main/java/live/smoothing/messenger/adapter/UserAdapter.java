package live.smoothing.messenger.adapter;

import live.smoothing.messenger.dto.HookUrlResponse;
import live.smoothing.messenger.dto.RoleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user-service")
public interface UserAdapter {

    @GetMapping("/api/user/hook/list/{hookTypeId}")
    List<HookUrlResponse> getUsersHookList(@PathVariable("hookTypeId") Integer hookTypeId);

    @GetMapping("/api/user/userRole/list")
    List<RoleResponse> getUserRoles(@RequestParam(name = "userId") String userId);

}
