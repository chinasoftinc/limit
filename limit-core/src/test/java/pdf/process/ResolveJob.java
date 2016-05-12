package pdf.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

	private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	// 文件位置
	private static final String file_location = "";

	// 文件名序列
	private static AtomicInteger current_file_name_sequence = new AtomicInteger(0);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		File resolveFile = new File(file_location + current_file_name_sequence.incrementAndGet() + ".txt");

		if (resolveFile.exists()) {
			executorService.execute(run(resolveFile)); // 执行读取和制造pdf任务
		}
		current_file_name_sequence.decrementAndGet();

	}

	// 执行读取和制造pdf任务
	private Runnable run(final File resolveFile) {
		return new Runnable() {

			@Override
			public void run() {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(resolveFile));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		};
	}

	public static void main(String[] args) {
		try {
			JobDetail jobDetail = new JobDetail("Job", "Group", ResolveJob.class);
			SimpleTrigger simpleTrigger = new SimpleTrigger("Job", "Group");
			simpleTrigger.setStartTime(new Date());

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
