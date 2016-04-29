package com.athena.common.cache.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisCacheUtils {
	private static final Logger logger = LoggerFactory.getLogger(RedisCacheUtils.class);

	/**
	 * 对象转换为字节码
	 * @param obj
	 * @return
	 */
	public static byte[] object2Byte(Object obj) {
		if (obj != null) {
			try {
				ByteArrayOutputStream bo = new ByteArrayOutputStream();
				ObjectOutputStream oo = new ObjectOutputStream(bo);
				oo.writeObject(obj);
				return bo.toByteArray();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
		return null;
	}

	/**
	 * 字节码转换为对象
	 * @param bytes
	 * @return
	 */
	public static Object byte2Object(byte[] bytes) {
		if (bytes != null) {
			try {
				ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
				ObjectInputStream oi = new ObjectInputStream(bi);
				return oi.readObject();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
		return null;
	}
}
