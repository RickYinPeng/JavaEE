import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author RickYinPeng
 * @ClassName HtmlMessage
 * @Description
 * @date 2018/10/18/15:48
 */
public class HtmlMessage {
    private static String from = "yp@rickyinpeng.com";
    private static String to = "hcy@rickyinpeng.com";
    private static String smtpHost = "localhost";
    public static void main(String[] args) throws Exception {
        String subject = "test";
        String body = "<h4>欢迎大家阅读此邮件</h4>";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", smtpHost); // 发件人的邮箱的 SMTP服务器地址
        props.setProperty("mail.smtp.auth", "true"); // 请求认证，参数名称与具体实现有关


        // 创建Session实例对象
        Session session = Session.getDefaultInstance(props);
        // 创建MimeMessage实例对象
        MimeMessage msg = new MimeMessage(session);
        // 设置发件人
        msg.setFrom(new InternetAddress(from));
        // 设置收件人
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        // 设置发送日期
        msg.setSentDate(new Date());
        // 设置邮件主题
        msg.setSubject(subject);

        // 设置HTML格式的邮件正文
        msg.setContent(body, "text/html;charset=gb2312");

        // 保存并生成最终的邮件内容
        msg.saveChanges();

      /*  // 把MimeMessage对象中的内容写入到文件中
        msg.writeTo(new FileOutputStream("c:\\test.eml"));*/

        Transport transport = session.getTransport("smtp");
        // 第2个参数需要填写的是QQ邮箱的SMTP的授权码，什么是授权码，它又是如何设置？
        transport.connect(from, "root");
        // 发送，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

    }
}
