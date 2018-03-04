package flysall.holding;

import flysall.typeinfo.pets.*;
import java.util.*;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        System.out.println(pets);
        while(it.hasNext()){
            System.out.print(it.next() + ", " + it.nextIndex() +
                ", " + it.previousIndex() + "; ");
        }
        while(it.hasPrevious())
            System.out.print(it.previous().id() + " ");
        System.out.println();
        // Backwards:
        while(it.hasPrevious())
            System.out.print(it.previous().id() + ", " + " ");
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while(it.hasNext()){
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}
