package collections;

import java.util.HashSet;
import java.util.Set;

public class AliExpress implements Store {
    Set<Dress> dressSet = new HashSet<>();
    @Override
    public void addNewDress(Dress dress) {
        dressSet.add(dress);
    }
    @Override
    public void printColor() {
        for (var dress : dressSet) {
            System.out.println( dress.getColor() + " - 美麗的");
        }
    }

    @Override
    public void printSize() {
        int i = 0;
        do {
            System.out.println("薄的\n");
            i++;
        } while (i < dressSet.size());
    }

    @Override
    public void deleteDress(Dress dress) {
        dressSet.remove(dress);
    }
}
