package com.pchudzik.blog.example.springconverter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.UUID;

//@ControllerAdvice
public class ArgumentConverterBinder {
	@InitBinder
	void setupBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Id.class, new IdPropertyEditor());
	}

	private class IdPropertyEditor extends PropertyEditorSupport {
		@Override
		public String getAsText() {
			return getValue() != null
					? getValue().toString()
					: "";
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(new Id(UUID.fromString(text)));
		}
	}
}
