package flysall.object;

public class ShowProperties {
    public static void main(String[] args){
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.version"));
    }
}
