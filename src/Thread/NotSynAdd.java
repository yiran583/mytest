package Thread;


/**
 * @author jiaotd
 * @since 2015年10月15日 上午9:20:12
 */

class Num {
	public int i = 0;

	public synchronized void add() {
		i = i + 1;
		System.out.println(Thread.currentThread().getName() + ":" + i);
	}
}

public class NotSynAdd implements Runnable {

	Num num;

	public NotSynAdd(Num num) {
		this.num = num;
	}

	public void run() {
		num.add();
	}

	public static void main(String[] args) throws Exception {
		Num num = new Num();
		/*ExecutorService service = Executors.newScheduledThreadPool(10); 
		for (int i = 0; i < 10; i++){
			service.execute(new NotSynAdd(num));
		}
		service.shutdown();*/
		for (int i = 0; i < 10; i++){
			new Thread(new NotSynAdd(num)).start();
		}
	}

}
