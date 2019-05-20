package DS1;

public interface Stack<T> {
    /**
     * 入栈
     * @return
     */
    boolean push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();

    /**
     * 获取栈的大小
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}
