package c14.practice;

/**
 * 修改 Counter2.java，使线程成为一个内部类，而且不需要明确保存指向 Counter2 的一个。
 */
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Counter2 extends Applet {
	
	/// 
	// 
	final TextField t = new TextField(10);
	private SeparateSubTask sp = null;
	private Button onOff = new Button("Toggle"), start = new Button("Start");

	class SeparateSubTask extends Thread {
		private int count = 0;
		private boolean runFlag = true;

		public SeparateSubTask() {
			start();
		}

		public void invertFlag() {
			runFlag = !runFlag;
		}

		public void run() {
			while (true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
				}
				if (runFlag)
					Counter2.this.t.setText(Integer.toString(count++));
			}
		}
	}

	public void init() {
		add(t);
		start.addActionListener(new StartL());
		add(start);
		onOff.addActionListener(new OnOffL());
		add(onOff);
	}

	class StartL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp == null)
				sp = new SeparateSubTask();
		}
	}

	class OnOffL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp != null)
				sp.invertFlag();
		}
	}

	public static void main(String[] args) {
		Counter2 applet1 = new Counter2();
		Counter2 applet2 = new Counter2();
		Frame aFrame = new Frame("Counter2");
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aFrame.setSize(300, 200);
		aFrame.add(applet1, BorderLayout.AFTER_LAST_LINE);
		applet1.init();
		applet1.start();
		aFrame.add(applet2, BorderLayout.CENTER);
		applet2.init();
		applet2.start();
		aFrame.setVisible(true);
	}
}