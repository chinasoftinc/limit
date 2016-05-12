package pdf.reader;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadId {

	private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	// 文件保存位置
	private static final String FILE_LOCATION = "";

	// 当前读取igop数据库行
	private static final Integer CURRENT_ROW = 0;

	// 每次读取的记录数
	private static final Integer ONCE_RECORD = 200;

	// 文件名序列
	private static AtomicInteger FILE_NAME_SEQUENCE = new AtomicInteger(0);

	// 数据库连接
	private static final Connection con = getConnection();

	public static void main(String[] args) {
	}

	// 保存文件
	static boolean save(BigDecimal[] primaryKey) {
		executorService.execute(null);
		FILE_NAME_SEQUENCE = new AtomicInteger(FILE_NAME_SEQUENCE.incrementAndGet()); // 每次文件序列自增
		return false;
	}

	// 读库
	static void run() {

		// 保存到文件
		boolean result = save(null);
	}

	// 获取数据源
	private static Connection getConnection() {
		return null;
	}
}
