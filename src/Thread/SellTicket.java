package Thread;

/**
 * @author jiaotd
 * @since 2015年10月15日 下午2:22:12
 */

class Reservoir {
	public static int ticket = 100;

	public synchronized boolean sell() {
		ticket--;
		System.out.println(Thread.currentThread().getName() + " sell one Ticket");
		return ticket >= 0 ? true : false;
	}
}

class Booth implements Runnable {
	int count;
	Reservoir reservoir;

	public Booth(Reservoir reservoir) {
		this.reservoir = reservoir;
	}

	public void run() {
		while (reservoir.sell()) {
			this.count = this.count + 1;
		}
		System.out.println(Thread.currentThread().getName() + " 售出:" + count);
	}

}

public class SellTicket {
	public static void main(String[] args) {
		Reservoir reservoir = new Reservoir();
		new Thread(new Booth(reservoir)).start();
		new Thread(new Booth(reservoir)).start();
		new Thread(new Booth(reservoir)).start();
	}
}
