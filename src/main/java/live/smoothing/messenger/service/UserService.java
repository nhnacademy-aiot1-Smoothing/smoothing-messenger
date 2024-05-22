package live.smoothing.messenger.service;

import live.smoothing.messenger.hook.UserRole;

import java.util.List;

/**
 * 회원이 설정한 hook url을 가져오기 위한 인터페이스
 *
 * @author 김지윤
 */
public interface UserService {

    /**
     * 모든 회원의 url list를 가져오기 위한 메서드
     *
     * @param hookTypeId queue에서 받아온 메세지를 담고 있는 객체
     * @return 모든 회원의 url list
     */
    List<String> getHookUrls(Integer hookTypeId);

    /**
     * 회원 권한과 hookType에 따라 url list를 가져오기 위한 메서드
     *
     * @param userRole 회원 권한
     * @param hookTypeId 훅 타입 아이디
     * @return 권한에 따른 회원의 url list
     */
    List<String> getUrlsByUserRole(UserRole userRole, Integer hookTypeId);
}
