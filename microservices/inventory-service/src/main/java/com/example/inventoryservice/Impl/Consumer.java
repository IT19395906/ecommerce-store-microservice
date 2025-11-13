package com.example.inventoryservice.Impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.common.CommonResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {
    
    @KafkaListener(topics = "${spring.kafka.template.defualt-topic}", groupId = "${spring.kafka.consumer.groupId}")
    
    public void receive(CommonResponseDto commonResponseDto){
        log.info("Receiving order from topic {}", commonResponseDto);
    }
}





