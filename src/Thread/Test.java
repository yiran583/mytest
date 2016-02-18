package Thread;

public class Test {
	public static void main(String[] args) {
		Reservoir1 r = new Reservoir1(100);
		Booth1 b1 = new Booth1(r);
		Booth1 b2 = new Booth1(r);
		Booth1 b3 = new Booth1(r);
	}
}

/**
 * contain shared resource
 */
class Reservoir1 {
	private int total;

	public Reservoir1(int t) {
		this.total = t;
	}

	/**
	 * Thread safe method serialized access to Booth.total
	 */
	public synchronized boolean sellTicket() {
		if (this.total > 0) {
			this.total = this.total - 1;
			return true; // successfully sell one
		} else {
			return false; // no more tickets
		}
	}
}

/**
 * create new thread by inheriting Thread
 */
class Booth1 extends Thread {
	private static int threadID = 0; // owned by Class object

	private Reservoir1 release; // sell this reservoir
	private int count = 0; // owned by this thread object

	/**
	 * constructor
	 */
	public Booth1(Reservoir1 r) {
		super("ID:" + (++threadID));
		this.release = r; // all threads share the same reservoir
		this.start();
	}

	/**
	 * convert object to string
	 */
	public String toString() {
		return super.getName();
	}

	/**
	 * what does the thread do?
	 */
	public void run() {
		while (true) {
			if (this.release.sellTicket()) {
				this.count = this.count + 1;
				System.out.println(this.getName() + ": sell 1");
				try {
					sleep((int) Math.random() * 100); // random intervals
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			} else {
				break;
			}
		}
		System.out.println(this.getName() + " I sold:" + count);
	}
}