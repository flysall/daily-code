package flysall.typeinfo.pets;

import java.util.*;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
        new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "flysall.typeinfo.pets.Mutt",
            "flysall.typeinfo.pets.Pug",
            "flysall.typeinfo.pets.EgyptianMau",
            "flysall.typeinfo.pets.Manx",
            "flysall.typeinfo.pets.Cymric",
            "flysall.typeinfo.pets.Rat",
            "flysall.typeinfo.pets.Mouse",
            "flysall.typeinfo.pets.Hamster"
    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for(String name : typeNames)
                types.add((Class<? extends Pet>)Class.forName(name));
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        loader();
    }
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
