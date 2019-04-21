
public class FasterFunctions{
	
	static Thread[] threads;
	
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		
		new FasterFunctions();
		
		threads = new Thread[3];
		
		threads[0] = new Thread(()->{
			SlowFunctions.millionsOfSqrts();
		});
		threads[1] = new Thread(()->{
			SlowFunctions.slowSortLargeArray();
		});
		threads[2] = new Thread(()->{
			SlowFunctions.ackermann(3, 14);
		});
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		try {
			threads[0].join();
			threads[1].join();
			threads[2].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}

}
