package exam03retake01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailBox {

    private List<Mail> mails;


    public MailBox() {
        mails = new ArrayList<>();
    }

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String criteria) {
        return mails.stream().filter(mail -> mail.findMail(criteria)).collect(Collectors.toList());
    }

    public List<Mail> findByCriteriaV1(String criteria) {

        if (criteria.startsWith("from:")) {
            String crit = criteria.substring(5);
            return mails.stream().filter(mail -> mail.getFrom().getName().equals(crit) || mail.getFrom().getEmail().equals(crit)).collect(Collectors.toList());
        } else if (criteria.startsWith("to:")) {
            String crit = criteria.substring(3);
            List<Mail> result = new ArrayList<>();
            for (Mail mail : mails) {
                for (Contact to : mail.getTo()) {
                    if (to.getName().equals(crit) || to.getEmail().equals(crit)) {
                        result.add(mail);
                    }
                }
            }
            return result;
        } else {
            return mails.stream()
                    .filter(mail -> mail.getSubject().contains(criteria) || mail.getMessage().contains(criteria))
                    .collect(Collectors.toList());
        }
    }

}
