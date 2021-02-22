package exam03retake01;

import java.util.List;

public class Mail {

    private Contact from;

    private List<Contact> to;

    private String subject;

    private String message;

    public Mail(Contact from, List<Contact> to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public Contact getFrom() {
        return from;
    }

    public List<Contact> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public boolean findMail(String criteria) {
        if (criteria.startsWith("from:")) {
            String crit = criteria.substring(5);
            return from.getName().equals(crit) || from.getEmail().equals(crit);
        } else if (criteria.startsWith("to:")) {
            String crit = criteria.substring(3);
            return to.stream().anyMatch(contact -> contact.getEmail().equals(crit) || contact.getName().equals(crit));
        } else {
            return subject.contains(criteria) || message.contains(criteria);
        }

    }
}
