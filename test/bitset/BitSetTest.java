package bitset;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BitSetTest {
    @Test
    void add() {
        BitSet x = new BitSet(0, 0, 0);
        x.add(2);
        assertEquals(x.contains(2), true);
        assertFalse(x.add(2));
    }

    @Test
    void del() {
        BitSet x = new BitSet(0, 1, 1);
        x.del(2);
        x.del(1);
        assertEquals(x.contains(2), false);
        assertEquals(x.contains(1), false);
        assertFalse(x.del(0));
    }

    @Test
    void contains() {
        assertEquals(new BitSet(1, 0, 1).contains(1), false);
    }

    @Test
    void intersection() {
        BitSet a = new BitSet(0, 1, 0, 0);
        BitSet b = new BitSet(1, 1, 0);
        BitSet c = new BitSet(1, 0, 1, 1);
        assertEquals(a.intersection(b), new BitSet(0, 1, 0, 0));
        assertEquals(b.intersection(c), new BitSet(1, 0, 0, 0));
    }

    @Test
    void union() {
        BitSet a = new BitSet(0, 1, 0, 0);
        BitSet b = new BitSet(1, 1, 0, 1);
        assertEquals(a.union(b), new BitSet(1, 1, 0, 1));
    }

    @Test
    void complement() {
        assertEquals(new BitSet(1, 0, 1).complement(), new BitSet(0, 1, 0));
    }

    @Test
    void addAll() {
        BitSet x = new BitSet(1, 0, 1, 0, 1);
        List<Integer> value = new ArrayList<>();
        value.add(1);
        value.add(0);
        value.add(1);
        assertEquals(x.addAll(1, value), new BitSet(1, 1, 1, 1, 1));
        try {
            x.addAll(3, value);
        } catch (IllegalArgumentException exception) {
            assertEquals("Invalid size", exception.getMessage());
        }
    }

    @Test
    void delAll() {
        BitSet x = new BitSet(1, 0, 1, 0, 1);
        List<Integer> value = new ArrayList<>();
        value.add(0);
        value.add(1);
        value.add(1);
        assertEquals(x.delAll(1, value), new BitSet(1, 0, 0, 0, 1));
        try {
            x.delAll(3, value);
        } catch (IllegalArgumentException exception) {
            assertEquals("Invalid size", exception.getMessage());
        }
    }

}