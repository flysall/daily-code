package flysall.concurency;

import java.util.*;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import java.lang.annotation.Retention;
import java.lang.annotation.Inherited;

public class SimpleThreadpool {
	//线程池中线程数目
	private static AtomicInteger poolCount = new AtomicInteger(0);
	//任务队列
	private ConcurrentLinkedQueue<Runnable> runnables;
	//为true时线程池运行
	private AtomicBoolean execute;
	//
	private List<SimpleThreadpoolThread> threads;
	
	//定制线程异常
	private class ThreadpoolException extends RuntimeException{
		//构造器
		public ThreadpoolException(Throwable cause){
			super(cause);
		}
	}
	
	private class SimpleThreadpoolThread extends Thread{
		private AtomicBoolean execute;
		private ConcurrentLinkedQueue<Runnable> runnables;
		
		public SimpleThreadpoolThread(String name, AtomicBoolean execute, ConcurrentLinkedQueue<Runnable> runnables){
			super(name);
			this.execute = execute;
			this.runnables = runnables;
		}
		
		@Override
		public void run(){
			try{
				while(execute.get() || !runnables.isEmpty()){
					Runnable runnable;
					while((runnable = runnables.poll()) != null){
						runnable.run();
					}
					Thread.sleep(1);
				}
			} catch(RuntimeException |  InterruptedException e){
				throw new ThreadpoolException(e);
			}	
		}
	}
	
	/**
	 * SimpleThreadpool私有构造器
	 */
	private SimpleThreadpool(int threadCount){
		poolCount.incrementAndGet();
		this.runnables = new ConcurrentLinkedQueue<>();
		this.execute = new AtomicBoolean(true);
		this.threads = new ArrayList<>();
		for(int threadIndex = 0; threadIndex < threadCount; threadIndex++){
			SimpleThreadpoolThread thread = new SimpleThreadpoolThread("SimpleThreadpool" + poolCount.get() + "Thread" + threadIndex, this.execute, this.runnables);
			thread.start();
			this.threads.add(thread);
		}
	}
	
	/**
	 * 获得SimpleThreadpool对象
	 * @param
	 */
	public static SimpleThreadpool getInstance(){
		return getInstance(Runtime.getRuntime().availableProcessors());
	}
	
	/**
	 * 用指定的thread数目获取SimpleThreadpool对象
	 * @param threadCount 添加到线程池的线程数目
	 * @return
	 */
	public static SimpleThreadpool getInstance(int threadCount){
		return new SimpleThreadpool(threadCount);
	}
	
	/**
	 * 将runnable任务加入队列以待运行
	 * @parAM runnable 被加入到线程池的任务
	 */
	public void execute(Runnable runnable){
		if(this.execute.get()){
			runnables.add(runnable);
		} else{
			throw new IllegalStateException("Threadpool terminating, unablte execute runnable");
		}
	}
	
	/**
	 * 在timeout ms内
	 * @param timeout 已毫秒为单位
	 */
	public void awaitTernation(long timeout) throws TimeoutException{
		if(this.execute.get()){
			throw new IllegalStateException("Threadpool not terminate beforte awaiting termination");
		}
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime <= timeout){
			boolean flag = true;
			for(Thread thread : threads){
				if(thread.isAlive()){
					flag = false;
					break;
				}
			}
			//所有线程都已死亡
			if(flag){
				return;
			}
			try{
				Thread.sleep(1);
			} catch (InterruptedException e){
				throw new ThreadpoolException(e);
			}
		}
		throw new TimeoutException("Unable to terminate threadpool within specified timeout (" + timeout + "ms)");
		
	}
}































