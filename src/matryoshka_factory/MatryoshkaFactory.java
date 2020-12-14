package matryoshka_factory;

import utils.exceptions.IncorrectSizeMatryoshkaException;

public class MatryoshkaFactory implements MatryoshkaFactoryInterface {
    private final String TYPE;
    private final int MIN_SIZE;
    private final int MAX_SIZE;

    public MatryoshkaFactory(String type, int minSize, int maxSize) throws RuntimeException {
        if (minSize > maxSize)
            throw new RuntimeException("Min size should not be bigger than Max size");
        if (minSize < 0)
            throw new RuntimeException("Size cant be negative");
        this.TYPE = type;
        this.MIN_SIZE = minSize;
        this.MAX_SIZE = maxSize;
    }

    @Override
    public Matryoshka createMatryoshka(int size) {
        checkMatryoshka(size);
        return new Matryoshka(TYPE, size, false);
    }

    @Override
    public Matryoshka createMatryoshka(int size, Matryoshka forPlaceInto) {
        checkMatryoshka(size);
        return new Matryoshka(TYPE, size, forPlaceInto);
    }

    private void checkMatryoshka(int newSize) {
        if (newSize > MAX_SIZE)
            throw new IncorrectSizeMatryoshkaException("Max size violated. Take smaller.");
        if (newSize < MIN_SIZE)
            throw new IncorrectSizeMatryoshkaException("Max size violated. Take bigger.");
    }
    @Override
    public Matryoshka getFullMatryoshka() {
        Matryoshka nextMatryoshka;
        Matryoshka currentMatryoshka = createMatryoshka(MIN_SIZE);

        for (int i = MIN_SIZE + 1; i <= MAX_SIZE; ++i) {
            nextMatryoshka = createMatryoshka(i, currentMatryoshka);
            currentMatryoshka = nextMatryoshka;
        }
        return currentMatryoshka;
    }
}
