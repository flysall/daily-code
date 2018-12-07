package flysall.generics;

import flysall.generics.coffee.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

interface Addable<T> {
    void add(T t);
}

public class Fill2 {
    // ClassToken version:
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    // Generator vision:
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for(int i = 0; i < size; i++) 
            addable.add(generator.next());
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }
    public void add(T item) {
        c.add(item);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

// To adapt a specific type, you can use inheritance.
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for(Coffee c : carrier)
            print(c);
        print("-------------------");
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for(Coffee c : coffeeQueue)
            print(c);
    }
}
