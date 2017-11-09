package com.pchudzik.blog.example.springconverter;

import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class ConversionArgumentCaptor {
    public void captureLocale(Locale locale) {
    }

    public void captureCurrency(Currency value) {
    }

    public void captureMap(Map<String, String> map) {
    }

    public void captureMapWithEnum(Map map) {
    }

    public void captureStream(Stream<Integer> stream) {
    }
}
