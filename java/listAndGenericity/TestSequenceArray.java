package Day.listAndGenericity;

import Day.listAndGenericity.ISequence;
import Day.listAndGenericity.SequenceArray;

public class TestSequenceArray {
    public static void main(String[] args) {

        ISequence<Object> s=new SequenceArray<>(20);
        s.add(4);
        s.add(3);
        s.add(2);
        s.add(1);
        s.add(5);
        s.add(2);
        s.add(6);
        s.add(7);
        s.add(11);
        s.add(12);
        System.out.println(s.get(2));

        System.out.println(s.set(1,6));
        s.toArray();
        System.out.println(s.remove(3));
        s.toArray();
    }
}
