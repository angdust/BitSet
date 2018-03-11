package var16;


import java.util.List;
import java.util.Vector;

public class BitSet {
    private final Vector<Boolean> set;

    /**
     * class constructor
     *
     * @param size to create a class
     */

    public BitSet(int size) {
        this.set = new Vector<>(size);
        for (int i = 0; i < size; i++) this.set.set(i, false);
    }

    /**
     * class constructor
     *
     * @param value set of elements
     */

    public BitSet(Boolean... value) {
        Vector<Boolean> result = new Vector<>();
        for (Boolean i : value) {
            result.add(i);
        }
        this.set = result;
    }

    /**
     * changes the value from false to true
     *
     * @param index indicates which element to change
     * @return false if an element is already true
     */

    public boolean add(int index) {
        if (!set.get(index)) {
            set.set(index, true);
            return true;
        }
        return false;
    }

    /**
     * changes the value from true to false
     *
     * @param index indicates which element to change
     * @return false if an element is already false
     */

    public boolean del(int index) {
        if (set.get(index)) {
            set.set(index, false);
            return true;
        }
        return false;
    }

    /**
     * @param index indicates which element to check
     * @return element state
     */

    public boolean contains(int index) {
        return set.get(index);
    }

    /**
     * intersection of two sets
     * @param other set of elements
     * @return a result
     */

    public BitSet intersection(BitSet other) {
        int hsize;
        int lsize;
        if (set.size() >= other.set.size()) {
            hsize = set.size();
            lsize = other.set.size();
        } else {
            hsize = other.set.size();
            lsize = set.size();
        }
        BitSet result = new BitSet(hsize);
        for (int i = 0; i < lsize; i++) {
            if (set.get(i) && other.set.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * union of two sets
     * @param other set of elements
     * @return a result
     */

    public BitSet union(BitSet other) {
        if (set.size() >= other.set.size()) {
            BitSet result = new BitSet(set.size());
            result.addAll(0, set);
            for (int i = 0; i < other.set.size(); i++) {
                if (other.set.get(i)) result.add(i);
            }
            return result;
        } else {
            BitSet result = new BitSet(other.set.size());
            result.addAll(0, other.set);
            for (int i = 0; i < set.size(); i++) {
                if (set.get(i)) result.add(i);
            }
            return result;
        }
    }

    /**
     * complements the set
     *
     * @return a result
     */

    public BitSet complement() {
        BitSet result = new BitSet(set.size());
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i)) {
                result.del(i);
            } else {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * changes the value from the list of elements at a given index
     *
     * @param index indicates from which element start to switch
     * @param array set of elements
     * @return a result
     */

    public BitSet addAll(int index, List<Boolean> array) {
        if (index + array.size() > set.size()) {
            throw new IllegalArgumentException("Invalid size");
        }
        BitSet result = new BitSet(set.size());
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i)) result.add(i);
        }
        for (int j = index; j < array.size() + index; j++) {
            if (array.get(j - index)) result.add(j);
        }
        return result;
    }

    /**
     * changes the value from the list of elements at a given index
     *
     * @param index indicates from which element start to switch
     * @param array set of elements
     * @return a result
     */

    public BitSet delAll(int index, List<Boolean> array) {
        if (index + array.size() > set.size()) {
            throw new IllegalArgumentException("Invalid size");
        }
        BitSet result = new BitSet(set.size());
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i)) result.add(i);
        }
        for (int j = index; j < array.size() + index; j++) {
            if (array.get(j - index)) result.del(j);
        }
        return result;
    }
}
