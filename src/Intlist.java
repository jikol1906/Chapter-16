/**
 * Created by borisgrunwald on 04/09/2016.
 */
public interface Intlist extends Iterable<Integer> {

    public int size();
    public int get(int index);
    public String toString();
    public int indexOf(int value);
    public void add(int value);
    public void add(int index, int value);
    public void remove(int index);
}
