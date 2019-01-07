package upteam.lottery.infra.util.jwt;

import upteam.lottery.infra.constant.IdentifyChar;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidatorContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Properties;
import java.util.Random;

/**
 * @author zty
 *
 * <p>valid util</p>
 */
public class ValidatorUtil {
    private static final Logger logger = Logger.getLogger(ValidatorUtil.class);

    public static boolean isThisValue(Object o, Object value, ConstraintValidatorContext context) {
        System.out.println(o.equals(value));
        return o.equals(value);
    }

    /**
     * <p>create identify code</p>
     *
     * @return object[0] is image and object[1] is code
     */
    public static Object[] createIdentifyImage() {

        StringBuffer stringBuffer = new StringBuffer();
        BufferedImage bufferedImage = new BufferedImage(IdentifyChar.WIDTH, IdentifyChar.HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, IdentifyChar.WIDTH, IdentifyChar.HEIGHT);

        Random random = new Random();
        for (int i = 0; i < IdentifyChar.CHAR_NUM; i++) {
            g.setColor(getRandomColor());
            int n = random.nextInt(IdentifyChar.IDENTIFY_CHARS.length);
            g.setFont(new Font(null, Font.BOLD + Font.ITALIC, IdentifyChar.FONT_SIZE));
            g.drawString(IdentifyChar.IDENTIFY_CHARS[n] + "", i * IdentifyChar.WIDTH / IdentifyChar.CHAR_NUM, IdentifyChar.HEIGHT * 2 / 3);
            stringBuffer.append(IdentifyChar.IDENTIFY_CHARS[n]);
        }

        for (int i = 0; i < IdentifyChar.CHAR_LINE; i++) {
            g.setColor(getRandomColor());
            g.drawLine(random.nextInt(IdentifyChar.WIDTH), random.nextInt(IdentifyChar.HEIGHT), random.nextInt(IdentifyChar.WIDTH), random.nextInt(IdentifyChar.HEIGHT));
        }

        return new Object[]{bufferedImage, stringBuffer.toString()};
    }

    /**
     * <p>get random color</p>
     *
     * @return
     */
    public static Color getRandomColor() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return color;
    }

    /**
     * <p>send email when registry</p>
     *
     * @param to
     * @param url
     * @return
     */
//    public static boolean sendEmail(String to, String mailCode, HttpSession httpSession) {
//
//        try {
//            httpSession.setAttribute("mailCode", mailCode);
//
//            Properties props = new Properties();
//
//            props.setProperty("mail.debug", "true");
//            props.setProperty("mail.smtp.auth", "true");
//            props.setProperty("mail.host", Email.EMAIL_SERVER_HOST);
//            props.setProperty("mail.transport.protocol", "smtp");
//
//            Session session = Session.getInstance(props);
//
//            Message msg = new MimeMessage(session);
//            msg.setSubject("authentication email from giggle here");
//            msg.setContent("<p>" + mailCode + "</p>", "text/html");
//            msg.setFrom(new InternetAddress(Email.EMAIL_FROM));
//
//            Transport transport = session.getTransport();
//            logger.info("connect it...");
//            transport.connect(Email.EMAIL_SERVER_HOST, Email.EMAIL_FROM, Email.LICENSE_KEY);
//            logger.info("get connection");
//
//            transport.sendMessage(msg, new Address[]{new InternetAddress(to)});
//            logger.info("send it");
//            transport.close();
//            logger.info("send email successfully");
//            return true;
//        } catch (Exception mex) {
//            logger.info("send error " + mex.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * <p>get six index number</p>
//     *
//     * @return
//     */
//    public static String getMailIdentifyCode() {
//        Random random = new Random();
//        String result = "";
//        for (int i = 0; i < Email.EMAIL_IDENTIFY_CODE; i++) {
//            result += random.nextInt(10);
//        }
//        return result;
//    }
}
