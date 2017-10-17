package Thread;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	public void run(){
		while(true){
			System.out.println(getName() + "消费者准备消费准备集合");
			try{
				Thread.sleep(200);
				bq.take();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println(getName() + "消费完成: " + bq);
		}
	}
}
