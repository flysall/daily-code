package flysall.io;

import java.io.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class DirectoryDemo {
    public static void main(String[] args) {
        PPrint.pprint(Directory.walk(".").dirs);
        for(File file : Directory.local(".", "T.*"))
            print(file);
        print("--------------------");

        for(File file : Directory.walk(".", "T.*\\.java"))
            print(file);
        print("====================");
        for(File file : Directory.walk(".", ".*[Zz].*\\.class"))
            print(file);
    }
}
