package com.pchudzik.blog.example.springconverter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
class IdConverter implements Converter<String, Id> {
	@Override
	public Id convert(String source) {
		return new Id(source);
	}
}
