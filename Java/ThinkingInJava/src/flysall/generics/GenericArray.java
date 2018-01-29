package flysall.generics;

public class GenericArray<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
    public T[] rep() {
        return array;
    }
    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
//        Integer[] ia = gai.rep(); Cause a ClassCastException
        Object[] oa = gai.rep();
        gai.put(0, new Integer(1));
        System.out.println(oa[0]);
        Object[] ob = gai.rep();
        System.out.println(gai.get(0));
    }
}
