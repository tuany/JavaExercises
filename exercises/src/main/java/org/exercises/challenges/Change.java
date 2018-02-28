package org.exercises.challenges;

public class Change {

    public long coin2  = 0;
    public long bill5  = 0;
    public long bill10 = 0;

    @Override
    public String toString() {
        return String.format("10 bill: %d\n5 bill: %d\n2 coin: %d\n", bill10,
                bill5, coin2);
    }
}
