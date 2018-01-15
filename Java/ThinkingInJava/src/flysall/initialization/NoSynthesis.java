package flysall.initialization;

class Bird2{
    Bird2(int i) {
        System.out.println("It's int " + i);
    }
    Bird2(double d){
        System.out.println("It's double " + d);
    }
}
public class NoSynthesis {
    public static void main(String[] args){
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
}
