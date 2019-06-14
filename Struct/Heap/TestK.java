package Heap;

import java.sql.PreparedStatement;
import java.util.*;


/**
 * 给定一个非空整数数组，返回其中出现频率前k高元素
 */
public class TestK {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,2,2,3};
        List<Integer> list=new TestK().topKFrequent(nums,2);
        System.out.println(list);
    }
    /**
     * 自定义一个类；作为一个结构
     */
    private class Freq implements Comparable<Freq>{
        private int key;
        private int freq;

        public Freq(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if(this.freq<o.freq){
                return 1;
            }else if(this.freq>o.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }

    /**
     * TreeMap中存储了所有的数以及他的频率
     * 用优先级队列存储频率最高的k个元素（优先级队列的size=k)
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums,int k){
        Map<Integer,Freq> map=new HashMap<>();
        for(int i:nums){
            if(map.get(i)==null){
                map.put(i,new Freq(i,1));
            }else{
                Freq freq=map.get(i);
                freq.freq+=1;
                map.put(i,freq);
            }
        }
        //使用优先级队列存储出现频率较大的前K个元素
        PrioityQueue<Freq> prioityQueue=new PrioityQueue<Freq>();
        //遍历;keyset返回所有的key值
        for(int key:map.keySet()){
            if(prioityQueue.size()<k){
                prioityQueue.enQueue(new Freq(key,map.get(key).freq));
            }
            //优先级队列元素达到k之后，每次替换队列中频率最小的元素
            if(map.get(key).freq>prioityQueue.peek().freq){
                //将优先级队列中最小的频率替换
                prioityQueue.deQueue();
                prioityQueue.enQueue(new Freq(key,map.get(key).freq));
            }
        }
        List<Integer> list=new ArrayList<>();
        while (prioityQueue.isEmpty()){
            list.add(prioityQueue.deQueue().key);
        }
        return list;
    }
}
