package com.example.kafkastreamwithwikipedia.producer;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WikimeadiaProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendStreamMessage(String message)
    {
        kafkaTemplate.send("wikiStreamTopic",message);
    }
}
