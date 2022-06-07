package com.anything.generic;

import org.modelmapper.ModelMapper;

public class Convert<T> {

	public void test(T t) {

		ModelMapper mapper = new ModelMapper();
		mapper.map(?, t.getClass());
	}
}
