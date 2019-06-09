package DS4;

import java.util.ArrayList;
import java.util.List;

public class TestBin {
    public static void main(String[] args) {
        BinTree<Integer> bin=new BinSearchTree<>();
        int[] num=new int[]{28,16,13,22,30,29,42};
        for(int i=0;i<num.length;i++){
            bin.add(num[i]);
        }
        bin.remove(22);
        List<Integer> list=new ArrayList<>();
        while(bin.size()!=0){
            list.add(bin.removeMin());
        }
        System.out.println(list);

        bin.preOrder();
//        bin.levelOrder();
    }
}
