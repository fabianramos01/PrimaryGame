package model;

public abstract class MyThread implements Runnable {
	
	private Thread thread;
	private String name;
	private boolean stop;
	private boolean pause;
	private int sleep;
	
	public MyThread(String name, int sleep) {
		this.name = name;
		this.sleep = sleep;
		thread = new Thread(this, name);
	}
	
	public void start() {
		thread.start();
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public boolean isPause() {
		return pause;
	}
	
	public synchronized void stop() {
		pause = false;
		stop = true;
		notify();
	}
	
	public synchronized void pause() {
		pause = true;
	}
	
	public synchronized void resume() {
		pause = false;
		notify();
	}
	
	public void run() {
		while (!stop) {
			executeTask(name);
			synchronized (this) {
				while (pause) {
					try {
						wait();
					} catch (InterruptedException e) {
					}
				}
				if (stop) {
					break;
				}
			}
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	abstract void executeTask();

	void executeTask(String word) {
	}
}