package flysall.log;

import java.util.logging.*;

public class FLogger {
	public static void main(String[] args){
		Logger Log = Logger.getLogger(FLogger.class.getName());
		Log.info("What's that?");
		System.out.println("It's a Log");
		Log.info("OK");
	}
}
