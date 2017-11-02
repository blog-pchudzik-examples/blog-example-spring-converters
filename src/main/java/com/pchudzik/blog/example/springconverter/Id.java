package com.pchudzik.blog.example.springconverter;

import java.util.UUID;

class Id {
	private final UUID uuid;

	public Id(UUID uuid) {
		this.uuid = uuid;
	}

	public Id(String uuid) {
		this(UUID.fromString(uuid));
	}

	@Override
	public String toString() {
		return uuid.toString();
	}
}
