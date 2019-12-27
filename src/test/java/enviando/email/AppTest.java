package enviando.email;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private String userName = "brunocesardevweb@gmail.com";
    private String password = "xxxxxxzzz";

    /*Utilizando jUnit em vez de criar classe main para teste*/
    /*Lembrar de autorizar(ativar) o gmail criado para teste*/
    @Test
    public void testeEmail() {

        /*Olhar as configurações do smtp do seu email (hotmail,gmail, etc...)*/
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true"); /*Autorização*/
        properties.put("mail.smtp.starttls", "true"); /*Autenticação*/
        properties.put("mail.smtp.host", "smtp.gmail.com"); /*Servidor gmail Google*/
        properties.put("mail.smtp.port", "465"); /*Porta do servidor*/
        properties.put("mail.smtp.socketFactory.port", "465"); /*Especifica a porta a ser conectada pelo socket*/
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); /*Classe socket de conexão ao SMTP*/

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            Address[] toUser = InternetAddress.parse("brunocesardevweb@gmail.com, brunocesar.oc96@gmail.com");

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userName)); /*Email usado na autenticação, Quem está enviando*/
            msg.setRecipients(Message.RecipientType.TO, toUser); /*email de Destino*/
            msg.setSubject("Chegou e-mail enviado com Java."); /*Assunto do E-mail*/
            msg.setText("Olá desenvolvedor!!\nVocê acaba de recer o email enviado pelo projeto java.\n");

            Transport.send(msg);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }


}
