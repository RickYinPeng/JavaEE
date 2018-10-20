import javax.mail.*;
import java.util.Properties;

/**
 * @author RickYinPeng
 * @ClassName MailReceives
 * @Description 接受邮件
 * @date 2018/10/18/11:47
 */
public class MailReceives {
    public static void main(String[] args) throws Exception{
        // 定义连接POP3服务器的属性信息
        String pop3Server = "localhost";
        String protocol = "pop3";

        String username = "hcy";
        String password = "root";

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.pop3.host", pop3Server);

        // 获取连接
        Session session = Session.getDefaultInstance(props);
//        Session session = Session.getInstance(props);
        session.setDebug(true);

        // 获取Store对象
        Store store = session.getStore();
        System.out.println("---------------");
        store.connect(pop3Server,"hcy",password); // POP3服务器的登陆认证
        System.out.println("---------------");
        // 通过POP3协议获得Store对象调用这个方法时，邮件夹名称只能指定为"INBOX"
        Folder folder = store.getFolder("INBOX");// 获得用户的邮件帐户
        folder.open(Folder.READ_WRITE); // 设置对邮件帐户的访问权限

        Message[] messages = folder.getMessages();// 得到邮箱帐户中的所有邮件

        for (Message message : messages) {
            System.out.println("-----------------------------------------------------------");
            String subject = message.getSubject();// 获得邮件主题
            Address from = (Address) message.getFrom()[0];// 获得发送者地址
            System.out.println("邮件的主题为: " + subject + "\t发件人地址为: " + from);
            System.out.println("邮件的内容为：");
            message.writeTo(System.out);// 输出邮件内容到控制台
            System.out.println("-----------------------------------------------------------");
        }

        folder.close(false);// 关闭邮件夹对象
        store.close(); // 关闭连接对象
    }
}
