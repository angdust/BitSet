package nikitin.bitset;


import java.util.ArrayList;
import java.util.List;

public class BitSet {
    private final ArrayList<Integer> val;

    /**
     * class constructor
     *
     * @param size
     */

    public BitSet(int size) {
        this.val = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.val.add(0);
        }
    }

    /**
     * class constructor
     *
     * @param value val of elements
     */

    public BitSet(int... value) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : value) {
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
        if (val.get(index) != 1) {
            val.set(index, 1);
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
        if (val.get(index) == 1) {
            val.set(index, 0);
            return true;
        }
        return false;
    }

    /**
     * @param index indicates which element to check
     * @return element state
     */

    public boolean contains(int index) {
        return val.get(index) == 1;
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
            if ((val.get(i) == 1) && (other.val.get(i) == 1)) {
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
                if (other.val.get(i) == 1) {
                    result.add(i);
                }
            }
            return result;
        } else {
            BitSet result = new BitSet(other.val.size());
            result.addAll(0, other.val);
            for (int i = 0; i < val.size(); i++) {
                if (val.get(i) == 1) {
                    result.add(i);
                }
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
            if (val.get(i) == 1) {
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

    public BitSet addAll(int index, List<Integer> array) {
        if (index + array.size() > val.size()) {
            throw new IllegalArgumentException("Invalid size");
        }
        BitSet result = new BitSet(val.size());
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i) == 1) {
                result.add(i);
            }
        }
        for (int j = index; j < array.size() + index; j++) {
            if (array.get(j - index) == 1) {
                result.add(j);
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

    public BitSet delAll(int index, List<Integer> array) {
        if (index + array.size() > val.size()) {
            throw new IllegalArgumentException("Invalid size");
        }
        BitSet result = new BitSet(val.size());
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i) == 1) {
                result.add(i);
            }
        }
        for (int j = index; j < array.size() + index; j++) {
            if (array.get(j - index) == 1) {
                result.del(j);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BitSet) {
            BitSet other = (BitSet) o;
            return this.val.equals(other.val);
        }
        BitSet bitSet = (BitSet) o;
        return val != null ? val.equals(bitSet.val) : bitSet.val == null;
    }
}
