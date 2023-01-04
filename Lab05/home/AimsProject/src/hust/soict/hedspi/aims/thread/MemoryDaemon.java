package hust.soict.hedspi.aims.thread;

public class MemoryDaemon  implements Runnable{
	
	private long memoryUsed = 0;
	
	@Override
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		
		while(true) {
			used = rt.totalMemory() - rt.freeMemory();
			if (used != memoryUsed) {
				System.out.println("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}

}