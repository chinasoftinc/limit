package com.athena.common.base.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * @author niebinxiao
 * @param <T>
 */
public abstract class Model<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return JSON.toJSONString(this, new SerializeFilter[] { new ValueFilter() {
			public Object process(Object object, String name, Object value) {
				return value;
			}
		} });
	}

	public boolean equals(Object obj) {
		boolean equals = true;
		if (this == obj) {
			equals = true;
		} else if (obj == null || getClass() != obj.getClass() || !toString().equals(obj.toString())) {
			equals = false;
		}
		return equals;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				result = prime * result + ((field.get(this) == null) ? 0 : field.get(this).hashCode());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}
}
