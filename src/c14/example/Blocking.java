package c14.example;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

// ///////// Testing Everything ///////////
public class Blocking extends Applet {
	private Button start = new Button("Start"), stopPeekers = new Button("Stop Peekers");
	private boolean started = false;
	private Blockable[] b;
	private PipedWriter out;
	private PipedReader in;

	public void init() {
		out = new PipedWriter();
		try {
			in = new PipedReader(out);
		} catch (IOException e) {
		}
		b = new Blockable[] { new Sleeper1(this), new Sleeper2(this), new SuspendResume1(this),
				new SuspendResume2(this), new WaitNotify1(this), new WaitNotify2(this), new Sender(this, out),
				new Receiver(this, in) };
		start.addActionListener(new StartL());
		add(start);
		stopPeekers.addActionListener(new StopPeekersL());
		add(stopPeekers);
	}

	class StartL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!started) {
				started = true;
				for (int i = 0; i < b.length; i++)
					b[i].start();
			}
		}
	}

	class StopPeekersL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Demonstration of the preferred
			// alternative to Thread.stop():
			for (int i = 0; i < b.length; i++)
				b[i].stopPeeker();
		}
	}

	public static void main(String[] args) {
		Blocking applet = new Blocking();
		Frame aFrame = new Frame("Blocking");
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aFrame.add(applet, BorderLayout.CENTER);
		aFrame.setSize(350, 550);
		applet.init();
		applet.start();
		aFrame.setVisible(true);
	}
} // /:~