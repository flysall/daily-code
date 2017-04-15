public class MutilThreadDown {
	public static void main(String[] args) throws Exception{
		final DownUtil downUtil = new DownUtil("http://www.crazyit.org/"
				+ "attachments/month_1703/1703261544e3b3dc9ee08bcfbe.png", "ios.png", 4);
		downUtil.download();
		new Thread(() -> {
			while(downUtil.getCompletRate() < 1){
				System.out.println("has finished: " + downUtil.getCompletRate());
				try{
					Thread.sleep(1000);
				}
				catch(Exception ex) {}
			}
		}).start();
	}
}
