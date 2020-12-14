package matryoshka_factory;

import utils.exceptions.*;

public class Matryoshka implements MatryoshkaInterface {
    private final String TYPE;
    private final int SIZE;
    private boolean matryoshkaIsInner;
    private Matryoshka innerMatryoshka;

    Matryoshka(String type, int size, boolean matryoshkaIsInner) {
        TYPE = type;
        SIZE = size;
        this.matryoshkaIsInner = matryoshkaIsInner;
    }

    Matryoshka(String type, int size, Matryoshka forPlaceInto) {
        this(type, size, false);
        forPlaceInto.matryoshkaIsInner = true;
        innerMatryoshka = forPlaceInto;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public Matryoshka getInnerMatryoshka() {
        if (isEmpty()) throw new MatryoshkaEmptyException("Are you this stupid?");
        if (this.matryoshkaIsInner) throw new MatryoshkaIsInnerException("Matryoshka is already inner, you don't have access");
        Matryoshka removed = innerMatryoshka;
        innerMatryoshka = null;
        removed.matryoshkaIsInner = false;
        return removed;
    }

    @Override
    public void placeInside(Matryoshka newInnerMatryoshka) throws  MatryoshkaNotEmptyException, DifferentTypeMatryoshkaException,
            IncorrectSizeMatryoshkaException, MatryoshkaIsInnerException {
        if (this.matryoshkaIsInner || newInnerMatryoshka.matryoshkaIsInner)
                throw new MatryoshkaIsInnerException("Exception name says everything...");
        if (! isEmpty()) throw new MatryoshkaNotEmptyException("Are you blind or something?");
        if (!TYPE.equals(newInnerMatryoshka.getType())) throw new DifferentTypeMatryoshkaException("Types of matryoshkas should be the same");
        if (SIZE <= newInnerMatryoshka.getSize()) throw new IncorrectSizeMatryoshkaException("matryoshka_factory.Matryoshka should be smaller to fit in.");
        newInnerMatryoshka.matryoshkaIsInner = true;
        innerMatryoshka = newInnerMatryoshka;
    }

    @Override
    public String toString() {
        String res = "----------------------------\n";
        res += "Matryoshka(" + TYPE + "), size: " + SIZE;
        if (!isEmpty()) {
            res += "\n";
            res += innerMatryoshka.toString();
        } else {
            res += "\n----------------------------";
        }
        return res;
    }

    private boolean isEmpty() {
        return innerMatryoshka == null;
    }
}
