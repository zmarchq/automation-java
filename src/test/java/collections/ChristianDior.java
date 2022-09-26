package collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ChristianDior implements Store {
    Set<Dress> dressSet = new HashSet<>();
    public void addNewDress(Dress dress) {
        dressSet.add(dress);
    }

    public void printColor(){
        for (var dress : dressSet) {
            System.out.println(dress.getColor());
        }
    }

    public void printSize() {
        for (var dress : dressSet) {
            System.out.println(dress.getSize());
        }
    }

    public void deleteDress(Dress dress) {
        dressSet.remove(dress);
    }
}
