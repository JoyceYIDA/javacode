package czy;

public class TestLinkedList {
    public static void main(String[] args){
        Sequence l=new LinkedList();
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);

        System.out.println(l.get(2));
        System.out.println(l.set(2,999));
        System.out.println(l.get(2));
        Object[] data=l.toArray();
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
