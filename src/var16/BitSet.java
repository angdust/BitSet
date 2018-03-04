package var16;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BitSet {
    private final List<String> set = new ArrayList<>();

    public boolean add(String value) {
        if (!set.contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    public boolean del(String value) {
        if (set.contains(value)) {
            set.remove(value);
            return true;
        }
        return false;
    }

    public boolean contains(String value) {
        return set.indexOf(value) != -1;
    }

    public BitSet intersection(BitSet other) {
        BitSet result = new BitSet();
        result.addAll(set);
        result.addAll(other.set);
        return result;
    }

    public BitSet union(BitSet other) {
        BitSet result = new BitSet();
        for (String i : set) {
            for (String j : other.set) {
                if (Objects.equals(i, j)) result.add(i);
            }
        }
        return result;
    }

    public BitSet complement(BitSet other) {
        BitSet result = new BitSet();
        for (String i : set) {
            if (other.set.contains(i)) result.del(i);
        }
        return result;

    }

    public BitSet addAll(List<String> array) {
        BitSet result = new BitSet();
        for (String i : set) result.add(i);
        for (String j : array) result.add(j);
        return result;
    }

    public BitSet dellAll(List<String> array) {
        BitSet result = new BitSet();
        for (String i : set) result.add(i);
        for (String j : array) result.del(j);
        return result;
    }
}
