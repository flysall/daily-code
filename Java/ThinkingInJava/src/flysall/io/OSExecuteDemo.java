package flysall.io;

import net.mindview.util.*;

public class OSExecuteDemo {
    public static void main(String[] args) {
        if(args.length < 1)
            System.out.println("Please add command arguments");
        else {
            StringBuilder sb = new StringBuilder(args[0]);
            for(int i = 1; i < args.length; i++)
                sb.append(" " + args[i]);
            String command = sb.toString();
            OSExecute.command(command);
        }
    }
}
