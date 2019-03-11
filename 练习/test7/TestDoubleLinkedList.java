package czy;

public class TestDoubleLinkedList {
    public static void main(String[] args) {
        Sequence d=new DoubleLinkedList();
        d.add(1);
        d.add(2);
        d.add(4);
        d.add(5);
        d.add(6);
        d.add(7);
        d.add(8);
//        System.out.println(d.get(2));
//        System.out.println(d.set(2,666));
//        System.out.println(d.get(2));
//        System.out.println(d.remove(4));
//        System.out.println(d.size());
//        System.out.println(d.contains(666));
//        System.out.println(d.contains(3));
//        d.clear();
//        System.out.println(d.size());
        Object[] data=d.toArray();
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}