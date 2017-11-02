package com.pchudzik.blog.example.springconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controller {
	@GetMapping("/find/{id}")
	public ObjectToFind findOne(@PathVariable Id id) {
		return new ObjectToFind(id);
	}

	static class ObjectToFind {
		private final String id;

		private ObjectToFind(Id id) {
			this.id = id.toString();
		}

		public String getId() {
			return id;
		}
	}
}
