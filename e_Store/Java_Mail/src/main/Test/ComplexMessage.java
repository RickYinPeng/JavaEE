import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * @author RickYinPeng
 * @ClassName ComplexMessage
 * @Description
 * @date 2018/10/18/20:33
 */
public class ComplexMessage {
    private static String from = "yp@rickyinpeng.com";
    private static String to = "hcy@rickyinpeng.com";
    private static String smtpHost = "localhost";

    public static void main(String[] args) throws Exception {
        String subject = "HTML邮件和图片以及附件资源";

        String pciture = "C:\\Users\\鹏哥\\Desktop\\照片\\favicon.ico";

        String body = "<a href=http://www.baidu.com>" + "百度" + "</a></br>"
                + "<img src=" + pciture + " />";

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

        // 创建代表邮件正文和附件的各个MimeBodyPart对象
        MimeBodyPart contentPart = createContent(body, pciture);

        // 下面的附件可以是视频或者是音频
        MimeBodyPart attachPart1 = createAttachment("C:\\Users\\鹏哥\\Desktop\\照片\\韩花花\\QQ图片20180430222100.gif");

        // 创建用于组合邮件正文和附件的MimeMultipart对象
        MimeMultipart allMultipart = new MimeMultipart("mixed");
        allMultipart.addBodyPart(contentPart);
        allMultipart.addBodyPart(attachPart1);

        // 设置整个邮件内容为最终组合出的MimeMultipart对象
        message.setContent(allMultipart);
        message.saveChanges();

//        message.writeTo(new FileOutputStream("G:\\ComplexMessage.eml"));
        session.setDebug(true);
        Transport transport = session.getTransport("smtp");
        transport.connect(from,"root");
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }

    public static MimeBodyPart createContent(String body, String filename)
            throws Exception {
        /*
          * 创建代表组合MIME消息的MimeMultipart对象， 和将该MimeMultipart对象保存到的MimeBodyPart对象
          */
        MimeBodyPart contentPart = new MimeBodyPart();
        MimeMultipart contentMultipart = new MimeMultipart("related");

        /*
          * 创建用于保存HTML正文的MimeBodyPart对象， 并将它保存到MimeMultipart中
          */
        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(body, "text/html;charset=gb2312");
        contentMultipart.addBodyPart(htmlBodyPart);

        /*
          * 创建用于保存图片的MimeBodyPart对象， 并将它保存到MimeMultipart中
          */
        MimeBodyPart gifBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(filename);
        gifBodyPart.setDataHandler(new DataHandler(fds));
        contentMultipart.addBodyPart(gifBodyPart);

        // 将MimeMultipart对象保存到MimeBodyPart对象中
        contentPart.setContent(contentMultipart);
        return contentPart;
    }

    public static MimeBodyPart createAttachment(String filename)
            throws Exception {
        // 创建保存附件的MimeBodyPart对象，并加入附件内容和相应信息
        MimeBodyPart attachPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(filename);
        attachPart.setDataHandler(new DataHandler(fds));
        attachPart.setFileName(fds.getName());
        return attachPart;
    }
}
