/* TODO: Przerobić cały kod i dostosować do programu
   TODO: Optymalizacja i refaktoryzacja
 */

package com.fk.fk_archiwizator.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/* javax libraries */

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Connect {

    private Properties properties;
    private Session session;
    private Store store;
    private Folder folder; // temporary
    /* TODO: Rozwiązac problem z odczytem folderów z serwera */


    private String userName;
    private String password;
    private static Message[] messages;
    //private ArrayList<String> inboxesToRead = new ArrayList<>();


    public Connect(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public void sendEmail() {
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // potrzebne do zautoryzwania wysyłania email
        session = Session.getInstance(properties, null);

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

    public void getEmail(String protocol, String host, String port) {
        Properties properties = getProperties(protocol, host, port);
        Session session = Session.getDefaultInstance(properties);


        try{
            store = session.getStore(protocol);
            store.connect(userName, password);

            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            messages = folder.getMessages();

            System.out.println("Number of emails: " + messages.length);
            Message msg = messages[0];
            Address[] fromAddress = msg.getFrom();
            System.out.println(fromAddress[0]);
            System.out.println(msg.getSubject());
        } catch(MessagingException exception) {
            System.out.println(exception);
        }

    }

    private Properties getProperties(String protocol, String host, String port) {
        Properties connectionProperties = new Properties();

        connectionProperties.put(String.format("mail.%s.host", protocol), host);
        connectionProperties.put(String.format("mail.%s.port", protocol), host);
        connectionProperties.put("mail.debug", "true");

        // SSL setting
        connectionProperties.setProperty(
                String.format("mail.%s.socketFactory.class", protocol),
                "javax.net.ssl.SSLSocketFactory");
        connectionProperties.setProperty(
                String.format("mail.%s.socketFactory.fallback", protocol),
                "false");
        connectionProperties.setProperty(
                String.format("mail.%s.socketFactory.port", protocol),
                String.valueOf(port));

        return connectionProperties;
    }


    private String parseAddresses(Address[] address) {
        String listAddress = "";

        if (address != null) {
            for (Address value : address) {
                listAddress += value.toString() + ", ";
            }
        }
        if (listAddress.length() > 1) {
            listAddress = listAddress.substring(0, listAddress.length() - 2);
        }

        return listAddress;
    }

    public Message[] getEmails() {
        return messages;
    }

}
