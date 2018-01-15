package flysall.initialization;

public class Flower {
    int petalCount = 0;
    String s = "initail value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only, petalCount= "
                + petals);
    }

    Flower(String ss) {
        System.out.println("Constructor w/ String only, s = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);
        this.s = s;
        System.out.println("String & int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }
    void printPetalCount(){
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }
    public static void main(String[] args){
        Flower x = new Flower();
        x.printPetalCount();
    }
}