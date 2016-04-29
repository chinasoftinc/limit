package com.athena.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author niebinxiao
 */
public class ConcurrentExecutor {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	public static synchronized void execute(Runnable command) {
		executorService.execute(command);
	}

}
