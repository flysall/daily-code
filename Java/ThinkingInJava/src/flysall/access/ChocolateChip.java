package flysall.access;

import flysall.access.dessert.*;
public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("CholoateChip constructor");
    }
    public void chomp(){
        //! bite(); //Can't access bite
    }
    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
