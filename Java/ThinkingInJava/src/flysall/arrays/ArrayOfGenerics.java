package flysall.arrays;

import java.util.*;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> [] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<String>();
        // Compile-tiime error:
        // ls[1] = new ArrayList<Integer>();

        Object[] objects = ls;
        // compiles and runs successfully:
        objects[1] = new ArrayList<Integer>();

        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
        for(int i = 0; i < spheres.length; i++)
            spheres[i] = new ArrayList<BerylliumSphere>();
        List<Integer> list = new LinkedList<>();
    }
}
