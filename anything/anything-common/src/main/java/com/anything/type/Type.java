package com.anything.type;

public class Type {

	public enum Session {

		KEY("ANYTHING_SESSION");

		private String value;
		private Session(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
}
