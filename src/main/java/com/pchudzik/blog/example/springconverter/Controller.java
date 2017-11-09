package com.pchudzik.blog.example.springconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
class Controller {
	@GetMapping("/find-id/{id}")
	public ObjectToFind findId(@PathVariable Id id) {
		return new ObjectToFind(id);
	}

	@GetMapping("/find-uuid/{id}")
	public ObjectToFind findId(@PathVariable UUID id) {
		return new ObjectToFind(id);
	}

	static class ObjectToFind {
		private final String id;

		private ObjectToFind(Id id) {
			this.id = id.toString();
		}

		public ObjectToFind(UUID id) {
			this.id = id.toString();
		}

		public String getId() {
			return id;
		}
	}
}
