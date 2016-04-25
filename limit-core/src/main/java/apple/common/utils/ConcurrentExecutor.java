package apple.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步执行工具类
 * @author niebinxiao
 */
public class ConcurrentExecutor {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	/**
	 * 异步执行任务
	 * @param run
	 */
	public static synchronized void execute(Runnable command) {
		executorService.execute(command);
	}

}
