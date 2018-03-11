package var16;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitSetTest {
    @Test
    void add() {
        BitSet x = new BitSet(false, false, false);
        x.add(2);
        assertEquals(x.contains(2), true);
    }

    @Test
    void del() {
        BitSet x = new BitSet(false, true, true);
        x.del(2);
        assertEquals(x.contains(2), false);
        x.del(1);
        assertEquals(x.contains(1), false);
    }

    @Test
    void contains() {
        assertEquals(new BitSet(true, false, true).contains(1), false);
    }

    @Test
    void intersection() {
        BitSet a = new BitSet(false, true, false, false);
        BitSet b = new BitSet(true, true, false, true);
        assertEquals(a.intersection(b), new BitSet(false, true, false, false));
    }

    @Test
    void union() {
        BitSet a = new BitSet(false, true, false, false);
        BitSet b = new BitSet(true, true, false, true);
        assertEquals(a.union(b), new BitSet(true, true, false, true));
    }

    @Test
    void complement() {
        assertEquals(new BitSet(true, false, true).complement(), new BitSet(false, true, false));
    }

    @Test
    void addAll() {
        BitSet x = new BitSet(true, false, true, false, true);
        List<Boolean> value = new ArrayList<>();
        value.add(true);
        value.add(false);
        value.add(true);
        x.addAll(1, value);
        assertEquals(x.contains(1), true);
    }

    @Test
    void delAll() {
        BitSet x = new BitSet(true, false, true, false, true);
        List<Boolean> value = new ArrayList<>();
        value.add(false);
        value.add(true);
        value.add(true);
        x.addAll(1, value);
        assertEquals(x.contains(2), false);
    }

}