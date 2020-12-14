package matryoshka_factory;

import matryoshka_factory.Matryoshka;

public interface MatryoshkaInterface {
    String getType();

    int getSize();

    Matryoshka getInnerMatryoshka();

    void placeInside(Matryoshka matryoshka);

    String toString();
}
