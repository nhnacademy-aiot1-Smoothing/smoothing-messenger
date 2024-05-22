package live.smoothing.messenger.hook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoorayHook {

    private String botName;

    private String botIconImage;

    private String text;

    private List<Attachment> attachments;

    public static DoorayHookBuilder builder() {

        return new DoorayHookBuilder();
    }

    public static class DoorayHookBuilder {

        private String botName;

        private String botIconImage;

        private String text;

        private List<Attachment> attachments;

        public DoorayHookBuilder botName(String botName) {

            this.botName = botName;
            return this;
        }

        public DoorayHookBuilder botIconImage(String botIconImage) {

            this.botIconImage = botIconImage;
            return this;
        }

        public DoorayHookBuilder text(String text) {

            this.text = text;
            return this;
        }

        public DoorayHookBuilder attachments(List<Attachment> attachments) {

            this.attachments = attachments;
            return this;
        }

        public DoorayHook build() {

            return new DoorayHook(this.botName, this.botIconImage, this.text, this.attachments);
        }

        public String toString() {

            return "DoorayHook.DoorayHookBuilder(botName=" + this.botName + ", botIconImage=" + this.botIconImage + "text=" + this.text + ", attachments=" + this.attachments + ")";
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Attachment {

        private String title;

        private String titleLink;

        private String text;

        private String color;

        public static AttachmentBuilder builder() {

            return new AttachmentBuilder();
        }

        @NoArgsConstructor
        public static class AttachmentBuilder {

            private String title;

            private String titleLink;

            private String text;

            private String color;

            public AttachmentBuilder title(String title) {

                this.title = title;
                return this;
            }

            public AttachmentBuilder titleLink(String titleLink) {

                this.titleLink = titleLink;
                return this;
            }

            public AttachmentBuilder text(String text) {

                this.text = text;
                return this;
            }

            public AttachmentBuilder color(String color) {

                this.color = color;
                return this;
            }

            public Attachment build() {

                return new Attachment(this.title, this.titleLink, this.text, this.color);
            }

            public String toString() {

                return "DoorayHook.Attachment.AttachmentBuilder(title=" + this.title + ", titleLink=" + this.titleLink + ", text=" + this.text + ", color=" + this.color + ")";
            }
        }


    }

}
