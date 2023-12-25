package com.example.kafkastreamwithwikipedia.controller;


import com.example.kafkastreamwithwikipedia.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {

    private final WikimediaStreamConsumer wikimediaConsumer;

    @GetMapping("/")
    public HttpStatus publishStream()
    {
        wikimediaConsumer.ConsumerStreamAndPublish();
        return HttpStatus.OK;
    }
}
