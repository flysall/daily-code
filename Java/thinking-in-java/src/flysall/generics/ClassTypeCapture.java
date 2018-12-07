package flysall.generics;

import static net.mindview.util.Print.*;

class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
    Class<T> kind;
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new
                ClassTypeCapture<Building>(Building.class);
        print(ctt1.f(new Building()));
        print(ctt1.f(new House()));
        print("---->");
        ClassTypeCapture<House> ctt2 = new
                ClassTypeCapture<House>(House.class);
        print(ctt2.f(new Building()));
        print(ctt2.f(new House()));
    }
}
