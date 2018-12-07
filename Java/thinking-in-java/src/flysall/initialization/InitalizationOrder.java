package flysall.initialization;

import static net.mindview.util.Print.*;

class OuterParent {
    int val = 1;
}

class  OuterChild extends OuterParent{
    int val = 2;
}

public class InitalizationOrder {
    static class Parent {
        int val = 1;

        private Parent() {
            play();
        }

        private void play() {
            print("Parent play()");
        }
    }

    static class Child extends Parent {
        int val = 2;

        private Child() {
            play();
        }

        void play() {
            print("Child play()");
        }
    }

    public static void main(String[] args) {
        Parent firstChild = new Child();
        Child secondChild = new Child();
        secondChild.play();
        OuterParent firstOc = new OuterChild();
        OuterChild secondOc = new OuterChild();
        print(firstOc.val);
        print(secondOc.val);
        print(firstChild.val);
        print(secondChild.val);
        firstChild.play();

    }
}
