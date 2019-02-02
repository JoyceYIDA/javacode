package DataStruct;

public class TestSingleLinkedList {
    public static void main(String[] args) {
        List list=new SingleLinkedList();

        ((SingleLinkedList) list).add(123);
        ((SingleLinkedList) list).add(321);
        ((SingleLinkedList) list).add(456);
        ((SingleLinkedList) list).add(678);
        ((SingleLinkedList) list).add(789);
        ((SingleLinkedList) list).add(111);
        ((SingleLinkedList) list).add(222);

        list.add(5,666);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list.toString());
    }
}
