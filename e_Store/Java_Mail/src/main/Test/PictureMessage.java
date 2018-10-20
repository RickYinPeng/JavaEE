import com.sun.deploy.util.SessionState;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author RickYinPeng
 * @ClassName PictureMessage
 * @Description 插入图片
 * @date 2018/10/18/16:14
 */
public class PictureMessage {
    private static String from = "yp@rickyinpeng.com";
    private static String to = "hcy@rickyinpeng.com";
    private static String smtpHost = "localhost";

    public static void main(String[] args) throws Exception {
        String pciture = "C:\\Users\\鹏哥\\Desktop\\照片\\favicon.ico";
        String subject = "带HTML与图片的邮件";
        String body = "<a href=http://www.baidu.com>" + "百度" + "</a></br>"
                + "<img src="+pciture+" />";
        System.out.println("<img src="+pciture+"/>");

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", smtpHost); // 发件人的邮箱的 SMTP服务器地址
        props.setProperty("mail.smtp.auth", "true"); // 请求认证，参数名称与具体实现有关

        Session session = Session.getDefaultInstance(props);

        // 创建MimeMessage实例对象
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSentDate(new Date());
        message.setSubject(subject);

        // 创建一个子类型为"related"的MimeMultipart对象。
        MimeMultipart multipart = new MimeMultipart("related");

        /*
          * 创建一个表示HTML正文的MimeBodyPart对象， 并将它加入到前面创建的MimeMultipart对象中
          */
        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(body, "text/html;charset=utf-8");
        multipart.addBodyPart(htmlBodyPart);

        /*
          * 创建一个表示图片内容的MimeBodyPart对象， 并将它加入到前面创建的MimeMultipart对象中
          */
        MimeBodyPart gifBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(pciture);
        gifBodyPart.setFileName(fds.getName());
        gifBodyPart.setDataHandler(new DataHandler(fds));
        multipart.addBodyPart(gifBodyPart);

        /*
          * 将MimeMultipart对象设置为整个邮件的内容， 要注意调用saveChanges方法进行更新
          */
        message.setContent(multipart);
        message.saveChanges();

        session.setDebug(true);
        Transport transport = session.getTransport("smtp");
        transport.connect(from,"root");
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
//        message.writeTo(new FileOutputStream("G:\\test.eml"));
    }
}
