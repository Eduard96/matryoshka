package matryoshka_factory;

public interface MatryoshkaFactoryInterface {
    Matryoshka createMatryoshka(int size);

    Matryoshka createMatryoshka(int size, Matryoshka forPlaceInto);

    Matryoshka getFullMatryoshka();
}
