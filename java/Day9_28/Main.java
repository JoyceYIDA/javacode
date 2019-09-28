package AAA.Day9_28;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yida
 */
public class Main {

    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    /**
     * Initialize your data structure here.
     */
    public Main() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        //先判断1和2哪个是空的
        int res=0;
        if(q1.isEmpty()){
            int len=q2.size();
            for(int i=0;i<len-1;i++){
                q1.add(q2.poll());
            }
            res=q2.poll();
        }else{
            int len=q1.size();
            for(int i=0;i<len-1;i++){
                q2.add(q1.poll());
            }
            res=q1.poll();
        }
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int res=0;
        if(q1.isEmpty()){
            int len=q2.size();
            for(int i=0;i<len-1;i++){
                q1.add(q2.poll());
            }
            res=q2.peek();
            q1.add(q2.poll());
        }else{
            int len=q1.size();
            for(int i=0;i<len-1;i++){
                q2.add(q1.poll());
            }
            res=q1.peek();
            q2.add(q1.poll());
        }
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}


class MyQueue {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res=0;
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            res=s2.pop();
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        int res=0;
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            res=s2.peek();
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}

class MinStack {
    Stack<Integer> s1=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(s1.isEmpty()){
            s1.push(x);
            s1.push(x);
        }else{
            int temp=s1.peek();
            s1.push(x);
            if(temp<x){
                s1.push(temp);
            }else{
                s1.push(x);
            }
        }
    }

    public void pop() {
        s1.pop();
        s1.pop();

    }

    public int top() {
        int temp=s1.pop();
        int res=s1.peek();
        s1.push(temp);
        return res;
    }

    public int getMin() {
        return s1.peek();
    }
}