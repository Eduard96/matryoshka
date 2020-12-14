import matryoshka_factory.Matryoshka;
import matryoshka_factory.MatryoshkaFactory;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String type = "EDO";
        int minSize = 1;
        int maxSize = 10;
        MatryoshkaFactory fullEdoFactory_1 = new MatryoshkaFactory(type, minSize, maxSize);

        Matryoshka newFullMatr = fullEdoFactory_1.getFullMatryoshka();
        Matryoshka onlyOneMatr = fullEdoFactory_1.createMatryoshka(10);
        Matryoshka newAlmostFullMatr = newFullMatr.getInnerMatryoshka();
        System.out.println(newAlmostFullMatr);
        System.out.println(newFullMatr);
        newFullMatr.placeInside(newAlmostFullMatr);
        System.out.println(newAlmostFullMatr);
        System.out.println(newFullMatr);
        onlyOneMatr.placeInside(newAlmostFullMatr);




//        LinkedList<Matryoshka> matryoshkeq = new LinkedList<>();
//        for(int i = minSize; i <= maxSize; i++) {
//            matryoshkeq.add(fullEdoFactory_1.createMatryoshka(i));
//        }
//        for(int i = 0; i < matryoshkeq.size()-1; i++) {
//            matryoshkeq.get(i+1).placeInside(matryoshkeq.get(i));
//        }
//        for(Matryoshka matryoshka : matryoshkeq) {
//            System.out.println(matryoshka);
//        }
    }
}