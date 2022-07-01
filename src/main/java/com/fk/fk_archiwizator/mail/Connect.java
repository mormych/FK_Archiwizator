/* TODO: Przerobić cały kod i dostosować do programu
   TODO: Optymalizacja i refaktoryzacja
 */

package com.fk.fk_archiwizator.mail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

/* javax libraries */

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Connect {


    public Connect() {

    }


    public void sendEmail() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // potrzebne do zautoryzwania wysyłania email
        Session session = Session.getInstance(properties, null);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom("FlaKraTest@outlook.com");
            message.setRecipients(RecipientType.TO, "michmar2002@outlook.com");
            message.setSubject("Email test");
            message.setSentDate(new Date());
            message.setText("Siema. Próba email");
            Transport.send(message, "FlaKraTest@outlook.com", "dariusflynt2");
        } catch (MessagingException exception) {
            System.out.println("Send failed, " + exception);
        }
    }

    public void getEmail() {

    }
}
