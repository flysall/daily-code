package flysall.initialization;

public class Leaf {
    int i = 0;
    Leaf increment(){
        i++;
        return this;
    }
    Leaf incrmentNew(){
        i++;
        return new Leaf();
    }
    void print(){
        System.out.println("i = " + i);
    }
    public static void main(String[] args){
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
        x.incrmentNew().incrmentNew().incrmentNew().print();
    }
}
