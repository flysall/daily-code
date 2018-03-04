package flysall.object;

import java.util.*;

public class HelloDate {
    public static void main(String[] args){
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
        for(int i = 0; i <= 100000000; i += 2){
            i--;
        }
        System.out.println("And now, it's: ");
        System.out.println(new Date());
    }
}
