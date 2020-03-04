package com.optiimtest.noteservice.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optiimtest.noteservice.model.Email;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By: Bekir Tezcan
 * Created At: 4.03.2020
 * Description :
 */
@Component
public class SendEmailMessageService {

    private RabbitTemplate template;

    private AmqpAdmin amqpAdmin;

    public SendEmailMessageService(RabbitTemplate template, AmqpAdmin amqpAdmin) {
        this.template = template;
        this.amqpAdmin = amqpAdmin;
    }

    public void sendEmail(Email email){
        Queue queue = QueueBuilder.durable("emailQueue").build();
        amqpAdmin.declareQueue(queue);
        try {
            template.convertAndSend("emailQueue", new ObjectMapper().writeValueAsString(email));
        } catch (JsonProcessingException e) {
        }
    }
}
