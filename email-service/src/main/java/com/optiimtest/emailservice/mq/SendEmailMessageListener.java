package com.optiimtest.emailservice.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optiimtest.emailservice.model.Email;
import com.optiimtest.emailservice.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created By: Bekir Tezcan
 * Created At: 4.03.2020
 * Description :
 */
@Component
public class SendEmailMessageListener {

    private EmailService emailService;

    public SendEmailMessageListener(EmailService emailService) {
        this.emailService = emailService;
    }

/*    @RabbitListener(queues = "emailQueue")
    public void receiveDeadQueue(Email message) {
        emailService.sendEmail(message);
    }*/

    @RabbitListener(queues = "emailQueue")
    public void receiveDeadQueue(String message) {
        try {
            Email mail = new ObjectMapper().readValue(message, Email.class);
            emailService.sendEmail(mail);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
