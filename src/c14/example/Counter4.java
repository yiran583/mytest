package c14.example;

//: Counter4.java
// If you separate your thread from the main
// class, you can have as many threads as you
// want.
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Ticker extends Thread {
	private Button b = new Button("Toggle");
	private TextField t = new TextField(10);
	private int count = 0;
	private boolean runFlag = true;
	Container c;
	public void setC(Container c) {
		this.c = c;
	}
	public Container getC() {
		return c;
	}
	public Ticker(Container c) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runFlag = !runFlag;
			}
		});
		Panel p = new Panel();
		p.add(t);
		p.add(b);
		c.add(p);
	}

	public void run() {
		while (true) {
			System.out.println("s");
			if (runFlag)
				t.setText(Integer.toString(count++));
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class Counter4 extends Applet {
	private Button start = new Button("Start");
	private boolean started = false;
	private Ticker[] s;
	private boolean isApplet = true;
	private int size;
	private String name = "22";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		if (isApplet)
			size = Integer.parseInt(getParameter("size"));
		s = new Ticker[size];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Ticker(this);
			System.out.println(this.getName());
		}
		System.out.println(s[1].getC() == s[2].getC());
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				if (!started) {
					started = true;
					for (int i = 0; i < s.length; i++)
						s[i].start();
				}
			}
		});
		add(start);
	}

	public static void main(String[] args) {
		Counter4 applet = new Counter4();
		applet.setName("aaaaaaaaa");
		applet.isApplet = false;
		applet.size = (args.length == 0 ? 15 : Integer.parseInt(args[0]));
		Frame aFrame = new Frame("Counter4");
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aFrame.add(applet, BorderLayout.CENTER);
		aFrame.setSize(200, applet.size * 50);
		applet.init();
		applet.start();
		aFrame.setVisible(true);
	}
}