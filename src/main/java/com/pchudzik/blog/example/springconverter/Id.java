package com.pchudzik.blog.example.springconverter;

import java.util.UUID;

class Id {
	private final UUID uuid;

	public Id(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * Constructor to be used by spring to automatically convert from String to the Id class
	 * @param uuid
	 */
	public Id(String uuid) {
		this(UUID.fromString(uuid));
	}

	@Override
	public String toString() {
		return uuid.toString();
	}
}
