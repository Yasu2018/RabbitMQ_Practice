package jp.takehara;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageSender {

    private final static String QUEUE_NAME = "hello";

    public void send(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("yasu");
        factory.setPassword("yasu");

        try(
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        ) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            String message = "Hello World!! " + currentDateTime;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
