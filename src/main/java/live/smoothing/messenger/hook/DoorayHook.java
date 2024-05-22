package live.smoothing.messenger.hook;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Dooray hook 요소 설정 클래스
 *
 * @author 김지윤
 */
@NoArgsConstructor
@AllArgsConstructor
public class DoorayHook {

    private String botName;

    private String text;

    public static DoorayHookBuilder builder() {

        return new DoorayHookBuilder();
    }

    public static class DoorayHookBuilder {

        private String botName;

        private String text;


        public DoorayHookBuilder botName(String botName) {

            this.botName = botName;
            return this;
        }

        public DoorayHookBuilder text(String text) {

            this.text = text;
            return this;
        }

        public DoorayHook build() {

            return new DoorayHook(this.botName, this.text);
        }
    }
}
