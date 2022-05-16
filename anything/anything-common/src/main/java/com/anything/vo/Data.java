package com.anything.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.ObjectUtils;

@SuppressWarnings("rawtypes")
public class Data extends HashMap<Object, Object> {

	static final long serialVersionUID = 1L;

	public Data() {
		super();
	}

	public Data(Map map) {
		super();
		this.addAll(map);
	}

	@SuppressWarnings("unchecked")
	public void addAll(Map map) {

		Iterator i$ = map.entrySet().iterator();

		do {
			if (!i$.hasNext()) {
				break;
			}

			java.util.Map.Entry entry = (java.util.Map.Entry) i$.next();
			Object value = entry.getValue();

			if (value != null) {
				Object toadd;
				if (value instanceof String[]) {
					String values[] = (String[]) (String[]) value;
					if (values.length > 1) {
						toadd = new ArrayList(Arrays.asList(values));
					} else {
						toadd = values[0];
					}
				} else {
					toadd = value;
				}

				this.put(((String) entry.getKey()), toadd);
			}
		} while (true);
	}

	@Override
	public Object get(Object key) {

		if (super.containsKey(key)) {
			return super.get(key);
		}

		try {
			String usKey = convertCamelCaseToUnderscores(key);

			if (super.containsKey(usKey)) {
				return super.get(usKey);
			} else if (super.containsKey(usKey.toLowerCase())) {
				return super.get(usKey.toLowerCase());
			}
		} catch (Exception e) {}

		return null;
	}

	public String getString(Object key) {

		Object obj = this.get(key);

		try {
			return obj.toString();
		} catch (Exception e) {}

		return "";
	}

	public int getInt(Object key) {

		Object obj = this.get(key);

		try {
			if (obj instanceof java.lang.Number) {
				return ((Number) obj).intValue();
			}

			return Integer.parseInt(obj.toString());
		} catch (Exception e) {}

		return 0;
	}

	public long getLong(Object key) {

		try {
			return Long.valueOf(this.getString(key), 10).longValue();
		} catch (Exception e) {}

		return 0;
	}

	public long getDouble(Object key) {

		try {
			return Double.valueOf(this.getString(key));
		} catch (Exception e) {}

		return 0;
	}

	private String convertCamelCaseToUnderscores(Object key) {

		if (ObjectUtils.isEmpty(key)) {
			return null;
		}

		return key.toString().replaceAll("([a-z0-9])([A-Z]+)", "$1_$2").toUpperCase();
	}
}
