package ru.ulstu.is.sbapp.speaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.sbapp.WebConfiguration;
import ru.ulstu.is.sbapp.speaker.service.SpeakerService;

@RestController
@RequestMapping(WebConfiguration.REST_API + "/speaker")
public class SpeakerController {
    private final SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping("/laba2")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name,
                        @RequestParam(value = "lang", defaultValue = "en") String lang) {
        return speakerService.say(name, lang);
    }
    @GetMapping("/Up")
    public String hello2(@RequestParam(value = "name", defaultValue = "World") String name,
                         @RequestParam(value = "lang", defaultValue = "en") String lang) {
        return speakerService.sayUp(name, lang);
    }
    @GetMapping("/Low")
    public String hello3(@RequestParam(value = "name", defaultValue = "World") String name,
                         @RequestParam(value = "lang", defaultValue = "en") String lang) {
        return speakerService.sayLow(name, lang);
    }
}
