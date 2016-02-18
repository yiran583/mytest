package c14.example;

//: Blocking.java
// Demonstrates the various ways a thread
// can be blocked.
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;

//////////// The basic framework ///////////
class Blockable extends Thread {
	private Peeker peeker;
	protected TextField state = new TextField(40);
	protected int i;

	public Blockable(Container c) {
		c.add(state);
		peeker = new Peeker(this, c);
	}

	public synchronized int read() {
		return i;
	}

	protected synchronized void update() {
		state.setText(getClass().getName() + " state: i = " + i);
	}

	public void stopPeeker() {
		// peeker.stop(); Deprecated in Java 1.2
		peeker.terminate(); // The preferred approach
	}
}

class Peeker extends Thread {
	private Blockable b;
	private int session;
	private TextField status = new TextField(40);
	private boolean stop = false;

	public Peeker(Blockable b, Container c) {
		c.add(status);
		this.b = b;
		start();
	}

	public void terminate() {
		stop = true;
	}

	public void run() {
		while (!stop) {
			status.setText(b.getClass().getName() + " Peeker " + (++session) + "; value = " + b.read());
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
} // /:Continued

// 1. 睡眠
// 这个程序的第一项测试是用 sleep()作出的：
// /:Continuing
// /////////// Blocking via sleep() ///////////
class Sleeper1 extends Blockable {
	public Sleeper1(Container c) {
		super(c);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Sleeper2 extends Blockable {
	public Sleeper2(Container c) {
		super(c);
	}

	public void run() {
		while (true) {
			change();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public synchronized void change() {
		i++;
		update();
	}
} // /:Continued

// /:Continuing
// ///////// Blocking via suspend() ///////////
class SuspendResume extends Blockable {
	public SuspendResume(Container c) {
		super(c);
		new Resumer(this);
	}
}

class SuspendResume1 extends SuspendResume {
	public SuspendResume1(Container c) {
		super(c);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			suspend(); // Deprecated in Java 1.2
		}
	}
}

class SuspendResume2 extends SuspendResume {
	public SuspendResume2(Container c) {
		super(c);
	}

	public void run() {
		while (true) {
			change();
			suspend(); // Deprecated in Java 1.2
		}
	}

	public synchronized void change() {
		i++;
		update();
	}
}

class Resumer extends Thread {
	private SuspendResume sr;

	public Resumer(SuspendResume sr) {
		this.sr = sr;
		start();
	}

	public void run() {
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			sr.resume(); // Deprecated in Java 1.2
		}
	}
} // /:Continued

// /:Continuing
// ///////// Blocking via wait() ///////////
class WaitNotify1 extends Blockable {
	public WaitNotify1(Container c) {
		super(c);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				wait(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class WaitNotify2 extends Blockable {

	public WaitNotify2(Container c) {
		super(c);
		new Notifier(this);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
	}
}

class Notifier extends Thread {
	private WaitNotify2 wn2;

	public Notifier(WaitNotify2 wn2) {
		this.wn2 = wn2;
		start();
	}

	public void run() {
		while (true) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
			}
			synchronized (wn2) {
				wn2.notify();
			}
		}
	}
} // /:Continued

// /:Continuing
class Sender extends Blockable { // send
	private Writer out;

	public Sender(Container c, Writer out) {
		super(c);
		this.out = out;
	}

	public void run() {
		while (true) {
			for (char c = 'A'; c <= 'z'; c++) {
				try {
					i++;
					out.write(c);
					state.setText("Sender sent: " + (char) c);
					sleep((int) (3000 * Math.random()));
				} catch (InterruptedException e) {
				} catch (IOException e) {
				}
			}
		}
	}
}

class Receiver extends Blockable {
	private Reader in;

	public Receiver(Container c, Reader in) {
		super(c);
		this.in = in;
	}

	public void run() {
		try {
			while (true) {
				i++; // Show peeker it's alive
				// Blocks until characters are there:
				state.setText("Receiver read: " + (char) in.read());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} // /:Continued

