package var16;


import java.util.List;
import java.util.Vector;

public class BitSet {
    private final Vector<Boolean> val;

    /**
     * class constructor
     *
     * @param size
     */

    public BitSet(int size) {
        this.val = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            this.val.add(false);
        }
    }

    /**
     * class constructor
     *
     * @param value val of elements
     */

    public BitSet(Boolean... value) {
        Vector<Boolean> result = new Vector<>();
        for (Boolean i : value) {
            result.add(i);
        }
        this.val = result;
    }

    /**
     * changes the value from false to true
     *
     * @param index indicates which element to change
     * @return false if an element is already true
     */

    public boolean add(int index) {
        if (!val.get(index)) {
            val.set(index, true);
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
        if (val.get(index)) {
            val.set(index, false);
            return true;
        }
        return false;
    }

    /**
     * @param index indicates which element to check
     * @return element state
     */

    public boolean contains(int index) {
        return val.get(index);
    }

    /**
     * intersection of two sets
     *
     * @param other val of elements
     * @return a result
     */

    public BitSet intersection(BitSet other) {
        int hsize;
        int lsize;
        if (val.size() >= other.val.size()) {
            hsize = val.size();
            lsize = other.val.size();
        } else {
            hsize = other.val.size();
            lsize = val.size();
        }
        BitSet result = new BitSet(hsize);
        for (int i = 0; i < lsize; i++) {
            if (val.get(i) && other.val.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * union of two sets
     *
     * @param other val of elements
     * @return a result
     */

    public BitSet union(BitSet other) {
        if (val.size() >= other.val.size()) {
            BitSet result = new BitSet(val.size());
            result.addAll(0, val);
            for (int i = 0; i < other.val.size(); i++) {
                if (other.val.get(i)) result.add(i);
            }
            return result;
        } else {
            BitSet result = new BitSet(other.val.size());
            result.addAll(0, other.val);
            for (int i = 0; i < val.size(); i++) {
                if (val.get(i)) result.add(i);
            }
            return result;
        }
    }

    /**
     * complements the val
     *
     * @return a result
     */

    public BitSet complement() {
        BitSet result = new BitSet(val.size());
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i)) {
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
     * @param array val of elements
     * @return a result
     */

    public BitSet addAll(int index, List<Boolean> array) {
        if (index + array.size() > val.size()) {
            throw new IllegalArgumentException("Invalid size");
        }
        BitSet result = new BitSet(val.size());
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i)) result.add(i);
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
     * @param array val of elements
     * @return a result
     */

    public BitSet delAll(int index, List<Boolean> array) {
        if (index + array.size() > val.size()) {
            throw new IllegalArgumentException("Invalid size");
        }
        BitSet result = new BitSet(val.size());
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i)) result.add(i);
        }
        for (int j = index; j < array.size() + index; j++) {
            if (array.get(j - index)) result.del(j);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof BitSet) {
            BitSet other = (BitSet) o;
            return this.val.equals(other.val);
        }
        BitSet bitSet = (BitSet) o;
        return val != null ? val.equals(bitSet.val) : bitSet.val == null;
    }

}
