package yp.Mail;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

/**
 * @author RickYinPeng
 * @ClassName POP3Help
 * @Description
 * @date 2018/10/18/13:40
 */
public class POP3Help {
    public static Folder getFolder(String host, String username, String password) {
        Properties prop = new Properties();
        prop.setProperty("mail.store.protocol", "pop3");
        prop.setProperty("mail.pop3.host", host);

        Session mailSession = Session.getDefaultInstance(prop, null);
        mailSession.setDebug(false);

        try {
            Store store = mailSession.getStore("pop3");
            store.connect(host, username, password);
            Folder folder = store.getFolder("inbox");
            folder.open(Folder.READ_WRITE);
            return folder;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
