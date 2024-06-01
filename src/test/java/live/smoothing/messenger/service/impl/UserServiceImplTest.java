package live.smoothing.messenger.service.impl;

import live.smoothing.messenger.adapter.UserAdapter;
import live.smoothing.messenger.dto.HookUrlResponse;
import live.smoothing.messenger.dto.RoleResponse;
import live.smoothing.messenger.hook.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserAdapter userAdapter;

    @InjectMocks
    private UserServiceImpl userService;

    private List<HookUrlResponse> mockHookUrlResponses;
    private List<RoleResponse> mockRoleResponses;

    @BeforeEach
    void setUp() {
        mockHookUrlResponses = Arrays.asList(
                new HookUrlResponse("user1", "http://hook-url-1.com"),
                new HookUrlResponse("user2", "http://hook-url-2.com")
        );
    }
    @Test
    void getHookUrls() {

        when(userAdapter.getUsersHookList(1)).thenReturn(mockHookUrlResponses);

        List<String> hookUrls = userService.getHookUrls(1);

        assertNotNull(hookUrls);
        assertEquals(2, hookUrls.size());

        verify(userAdapter, times(1)).getUsersHookList(1);
        verifyNoMoreInteractions(userAdapter);

    }

    @Test
    void getUrlsByUserRole() {

        when(userAdapter.getUsersHookList(1)).thenReturn(mockHookUrlResponses);
        when(userAdapter.getUserRoles("user1")).thenReturn(List.of(new RoleResponse(1L, "ROLE_ADMIN")));
        when(userAdapter.getUserRoles("user2")).thenReturn(List.of(new RoleResponse(1L, "ROLE_USER")));

        List<String> adminUrls = userService.getUrlsByUserRole(UserRole.ROLE_ADMIN, 1);
        List<String> userUrls = userService.getUrlsByUserRole(UserRole.ROLE_USER, 1);

        assertEquals(1, adminUrls.size());
        assertEquals("http://hook-url-1.com", adminUrls.get(0));

        assertEquals(1, userUrls.size());
        assertEquals("http://hook-url-2.com", userUrls.get(0));

        verify(userAdapter, times(2)).getUsersHookList(1);
        verifyNoMoreInteractions(userAdapter);

    }
}