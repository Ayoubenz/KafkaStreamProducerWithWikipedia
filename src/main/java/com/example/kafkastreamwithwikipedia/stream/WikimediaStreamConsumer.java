package com.example.kafkastreamwithwikipedia.stream;

import com.example.kafkastreamwithwikipedia.producer.WikimeadiaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webclient;

    private final WikimeadiaProducer wikimeadiaProducer;

    public WikimediaStreamConsumer(WebClient.Builder webclientBuilder, WikimeadiaProducer wikimeadiaProducer) {
        this.webclient = webclientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.wikimeadiaProducer = wikimeadiaProducer;
    }

    public void ConsumerStreamAndPublish()
    {
        webclient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikimeadiaProducer::sendStreamMessage);
    }


}
