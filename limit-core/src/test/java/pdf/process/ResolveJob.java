package pdf.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class ResolveJob implements Job {

	// 文件位置
	private static final String file_location = "";

	// 当前文件
	private static File current_file = null;
	
	private static Integer current_file_length = null;

	// 文件名序列
	private static AtomicInteger file_name_sequence = new AtomicInteger(0);

	// 当前文件读取的行数指针
	private static Integer read_line = null;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		File resolveFile = new File(file_location + file_name_sequence + ".txt");
		if (current_file == null || (current_file != null && !resolveFile.getName().equals(current_file.getName()))) {
			// 当前解析文件为空, 或文件过时, 重置文件引用和行指针
			current_file = current_file;
			read_line = null;
		}
	}

	private void resolveLog() {
		long successRecord = 0; // 成功执行数量
		try {
			// 将日志文件关联读取流
			if (null != current_file) {
				BufferedReader reader = new BufferedReader(new FileReader(current_file));
				String line; // 读取的行字符
				Integer lineNum = 0; // 读取的行数

				// 读取, 跟随上一次行指针
				while ((line = reader.readLine()) != null) {
					if (null != read_line && ++lineNum <= read_line) {
						continue;
					}
					if (null == read_line) {
						read_line = 1;
					}
					read_line++;

					reader.close();
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 获取日志目录下最后更新的文件
	 * @author nbx
	 * @date 2015年1月20日 上午9:09:32
	 * @return
	 */
	private File getLastFile() {
		try {
			// 获取文件路径
			File dir = new File(file_location);
			
			// 路径不存在
			if (!dir.exists()) {
				return null;
			}
			
			// 获取路径下所有文件名
			File[] files = dir.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File arg0, String arg1) {
					return arg1.endsWith(".txt");
				}
			});
			
			// 路径下没有文件, 返回空
			if (files == null || files.length == 0) {
				return null;
			}
			
			// 遍历文件名, 取得最后更新的文件:
			File max_last_modifies_file = null; // 最后更新的文件
			long max_last_modifies_time = 0; // 最后更新的时间
			File last_modifies_file = null;
			for (File f : files) {
				if (f.exists() && f.lastModified() > max_last_modifies_time) {
					max_last_modifies_time = f.lastModified();
					last_modifies_file = max_last_modifies_file == null ? f : max_last_modifies_file;
					max_last_modifies_file = f;
				}
			}
			if (null != current_file_length && null != current_file && current_file_length == last_modifies_file.length()
					&& current_file.getName().equals(last_modifies_file.getName())) {
				return null;
			}
			/**
			 * last_modifies_file：倒数第2个更新的文件（即上次更新的文件-昨天日志文件）, max_last_modifies_file：最后更新的文件。 ---多个文件时
			 */
			return last_modifies_file;
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			JobDetail jobDetail = new JobDetail("Job", "Group", ResolveJob.class);
			SimpleTrigger simpleTrigger = new SimpleTrigger("Job", "Group");
			simpleTrigger.setStartTime(new Date()); // 直接调度

			simpleTrigger.setRepeatInterval(2000);
			simpleTrigger.setRepeatCount(-1);

			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, simpleTrigger);

			scheduler.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
