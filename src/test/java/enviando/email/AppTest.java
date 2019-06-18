package enviando.email;

import org.junit.Test;

import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /*Utilizando jUnit em vez de criar classe main para teste*/
    @Test
    public void testeEmail() {

        /*Olhar as configurações do smtp do seu email (hotmail,gmail, etc...)*/
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true"); /*Autorização*/
        properties.put("mail.smtp.starttls","true"); /*Autenticação*/
        properties.put("mail.smtp.host","smtp.gmail.com"); /*Servidor gmail Google*/
        properties.put("mail.smtp.port","465"); /*Porta do servidor*/
        properties.put("mail.smtp.socketFactory.port","465"); /*Especifica a porta a ser conectada pelo socket*/
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); /*Classe socket de conexão ao SMTP*/

    }


}
