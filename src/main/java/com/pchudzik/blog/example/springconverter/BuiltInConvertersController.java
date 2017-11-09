package com.pchudzik.blog.example.springconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/builtin-converters")
class BuiltInConvertersController {
    private final ConversionArgumentCaptor captor;

    BuiltInConvertersController(ConversionArgumentCaptor captor) {
        this.captor = captor;
    }

    @GetMapping("/locale")
    public void stringToLocale(@RequestParam Locale value) {
        captor.captureLocale(value);
    }

    @GetMapping("/currency")
    public void stringToCurrency(@RequestParam Currency value) {
        captor.captureCurrency(value);
    }

    @GetMapping("/map")
    public void stringToMapConverter(@RequestParam Map<String, String> map) {
        captor.captureMap(map);
    }

    @GetMapping("/map-with-enum")
    public void stringToMapWithEnumsConverter(@RequestParam Map<AnyEnum, Integer> map) {
        captor.captureMapWithEnum(map);
    }

    @GetMapping("/stream")
    public void stringToStreamConverter(@RequestParam Stream<Integer> stream) {
        captor.captureStream(stream);
    }
}
