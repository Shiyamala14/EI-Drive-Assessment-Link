import java.util.*;


public class EmailAdapter implements Notifier {
    private ExternalEmailService external;
    private String domainForUser;

    public EmailAdapter(ExternalEmailService external, String domainForUser) {
        this.external = external;
        this.domainForUser = domainForUser;
    }

    @Override
    public void notifyUser(String userId, String message) {
        String email = userId + "@" + domainForUser;
        external.sendMailTo(email, "Notification", message);
    }
}
