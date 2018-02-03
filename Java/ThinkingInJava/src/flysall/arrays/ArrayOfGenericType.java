package flysall.arrays;

public class ArrayOfGenericType<T> {
    T[] array; // OK
//    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        array = (T[]) new Object[size];
    }

}
