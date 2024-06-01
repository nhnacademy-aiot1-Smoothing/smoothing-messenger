package live.smoothing.messenger.hook;

import live.smoothing.messenger.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DoorayHookSenderTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private UserService userService;

    @InjectMocks
    private DoorayHookSender doorayHookSender;

    private DoorayHook doorayHook;

    @BeforeEach
    void setUp() {
        doorayHook = new DoorayHook();
    }

    @Test
    void testSendToAdminUrls() {
        List<String> adminUrls = Arrays.asList("http://admin-url.com");
        doReturn(adminUrls).when(userService).getUrlsByUserRole(UserRole.ROLE_ADMIN, 1);
        doReturn(ResponseEntity.ok("Success")).when(restTemplate)
                .exchange(eq("http://admin-url.com"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class));

        doorayHookSender.send(doorayHook, UserRole.ROLE_ADMIN);

        verify(restTemplate).exchange(eq("http://admin-url.com"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class));
        verify(userService).getUrlsByUserRole(UserRole.ROLE_ADMIN, 1);
        verifyNoMoreInteractions(restTemplate);
    }

    @Test
    void testSendToUserUrls() {
        List<String> userUrls = Arrays.asList("http://user-url.com");
        doReturn(userUrls).when(userService).getUrlsByUserRole(UserRole.ROLE_USER, 1);
        doReturn(ResponseEntity.ok("Success")).when(restTemplate)
                .exchange(eq("http://user-url.com"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class));

        doorayHookSender.send(doorayHook, UserRole.ROLE_USER);

        verify(restTemplate).exchange(eq("http://user-url.com"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class));
        verify(userService).getUrlsByUserRole(UserRole.ROLE_USER, 1);
        verifyNoMoreInteractions(restTemplate);
    }

    @Test
    void testSendToAllUrls() {
        List<String> allUrls = Arrays.asList("http://all-url.com");
        doReturn(allUrls).when(userService).getHookUrls(1);
        doReturn(ResponseEntity.ok("Success")).when(restTemplate)
                .exchange(eq("http://all-url.com"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class));

        doorayHookSender.send(doorayHook, UserRole.ALL);

        verify(restTemplate).exchange(eq("http://all-url.com"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class));
        verify(userService).getHookUrls(1);
        verifyNoMoreInteractions(restTemplate);
    }

}