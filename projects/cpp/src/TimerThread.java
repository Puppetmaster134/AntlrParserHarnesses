import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;



public class TimerThread extends TimerTask {
	public ArrayList<HashMap<Long,Long>> memory = new ArrayList<HashMap<Long,Long>>();
	public ArrayList<HashMap<Long,Long>> cpu = new ArrayList<HashMap<Long,Long>>();
	public final ThreadMXBean threadMonitor;
	public final long threadId;
	public TimerThread(long threadId)
	{
		threadMonitor = ManagementFactory.getThreadMXBean();
		this.threadId = threadId;
	}
	
	@Override
	public void run() {
		System.currentTimeMillis();
		HashMap<Long,Long> memoryScrape = new HashMap<Long,Long>();
		HashMap<Long,Long> cpuScrape = new HashMap<Long,Long>();
		memoryScrape.put(System.currentTimeMillis(), getAllocatedHeap());
		cpuScrape.put(System.currentTimeMillis(), getUsedCPU());
		memory.add(memoryScrape);
		cpu.add(cpuScrape);
	}
	
	public long getAllocatedHeap()
	{
		long totalMem = Runtime.getRuntime().totalMemory();
		long freeMem = Runtime.getRuntime().freeMemory();
		return totalMem - freeMem;
	}

	public long getUsedCPU()
	{
		return this.threadMonitor.getThreadCpuTime(this.threadId);
	}

}
