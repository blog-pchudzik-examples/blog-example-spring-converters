package com.pchudzik.blog.example.springconverter;

import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

//@ControllerAdvice
class IdConverter implements Converter<String, Id> {
	@Override
	public Id convert(String source) {
		return new Id(UUID.fromString(source));
	}
}
