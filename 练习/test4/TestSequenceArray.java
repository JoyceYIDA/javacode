public class TestSequenceArray {
    public static void main(String[] args) {
        Sequence sequence=new SequenceArrayImpl(4);
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);
        sequence.add(5);
        sequence.add(6);

        System.out.println(sequence.get(4));
        System.out.println(sequence.set(3,8));

        System.out.println( sequence.remove(3));
        System.out.println(sequence.get(3));

        System.out.println(sequence.contains(2));
        System.out.println(sequence.contains(9));

    }
}
