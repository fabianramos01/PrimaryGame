package model;

public class MyThread implements Runnable{

	private Thread thread;
	private String text;
	private int sleep;
	private boolean stop;
	private boolean pause;
	
	public MyThread(String text) {
		this.text = text;
		thread = new Thread(this);
	}
	
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}
	
	@Override
	public void run() {
		while (!stop) {
			System.out.println(text);
		}
	}
	
	public void start() {
		thread.start();
	}
	
	public int getSleep() {
		return sleep;
	}
	
	public synchronized void stop() {
		stop = true;
		notify();
	}
	
	public synchronized void pause() {
		pause = true;
		notify();
	}
	
	public synchronized void resume() {
		pause = false;
		notify();
	}
	
	public boolean isPause() {
		return pause;
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public Thread getThread() {
		return thread;
	}
}