import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author RickYinPeng
 * @ClassName TestMessage
 * @Description 测试创建邮件
 * @date 2018/10/18/11:19
 */
public class TestMessage {
    public static void main(String[] args) throws Exception{
        String from = "yp@rickyinpeng.com";
        String to = "hcy@rickyinpeng.com";
        String subject = "test";
        String body = "test!!!";

        // 创建Session实例对象
        Session session = Session.getDefaultInstance(new Properties());
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
        // 设置纯文本内容的邮件正文
        msg.setText(body);
        // 保存并生成最终的邮件内容
        msg.saveChanges();
        // 把MimeMessage对象中的内容写入到文件中
        msg.writeTo(new FileOutputStream("G:\\test.eml"));
    }

}
