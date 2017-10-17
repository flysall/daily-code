package Thread;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	public void run(){
		String[] strArr = new String[]{"Java", "Struts", "SPring"};
		for(int i = 0; i<999999999; i++){
			System.out.println(getName() + "生产者准备生产集合元素");
			try
			{
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println(getName() + "生产完成: " + bq);
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
