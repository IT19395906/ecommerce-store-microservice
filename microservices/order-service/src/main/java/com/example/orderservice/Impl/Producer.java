package com.example.orderservice.Impl;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.common.CommonResponseDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class Producer {

    private final NewTopic newTopic;
    private final KafkaTemplate<String, CommonResponseDto> kafkaTemplate;

    public void sendMessage(CommonResponseDto commonResponseDto) {
        log.info("Sending order to topic {}", commonResponseDto);
        Message<CommonResponseDto> message = MessageBuilder.withPayload(commonResponseDto).setHeader(KafkaHeaders.TOPIC, newTopic.name()).build();
        kafkaTemplate.send(message);
    }
}
