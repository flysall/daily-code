package flysall.holding;

import java.util.*;
import flysall.typeinfo.pets.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while(it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
        for(Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
        //Iterator can also remove elements
        it = pets.iterator();
        System.out.println(pets);
        for(int i = 0; i < 6; i++){
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}
