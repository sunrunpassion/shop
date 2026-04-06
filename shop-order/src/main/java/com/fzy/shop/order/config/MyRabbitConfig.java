package com.fzy.shop.order.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyRabbitConfig {

    @Primary
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        // 1. 创建实例
        RabbitTemplate template = new RabbitTemplate(connectionFactory);

        // 2. 设置 JSON 转换器
        template.setMessageConverter(messageConverter());

        // 3. 设置确认回调 (ConfirmCallback)
        // 消息到达 Broker 时的回调
        template.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("RabbitMQ Confirm: correlationData[" + correlationData + "], ack[" + ack + "], cause[" + cause + "]");
        });

        // 4. 设置退回回调 (ReturnsCallback)
        // 消息未到达 Queue 时的回调
        template.setReturnsCallback(returned -> {
            System.out.println("RabbitMQ Return: message[" + returned.getMessage() + "]" +
                    ", replyCode[" + returned.getReplyCode() + "]" +
                    ", replyText[" + returned.getReplyText() + "]" +
                    ", exchange[" + returned.getExchange() + "]" +
                    ", routingKey[" + returned.getRoutingKey() + "]");
        });

        return template;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}