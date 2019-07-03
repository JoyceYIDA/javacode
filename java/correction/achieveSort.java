package AJuly.correction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 成绩排序
 * 定义一个学生类
 * 实现方法：先输入人数，再输入排序策略（0或1），输入多组人名和成绩
 * 按排序策略输出
 */

class Student{
    public String name;
    public int score;

    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }
}
public class achieveSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //输入人数
            int num=sc.nextInt();
            //排序策略
            int option=sc.nextInt();
            //输入的学生的姓名和成绩
            List<Student> studentList=new ArrayList<>();
            for(int i=0;i<num;i++){
                studentList.add(new Student(sc.next(),sc.nextInt()));
            }

            /*排序策略：0为降序；1为升序

             */

            if(option==0){
                studentList.sort((o1, o2) -> o2.score-o1.score);
            }else if(option==1){
                studentList.sort((o1, o2) -> o1.score-o2.score);
            }
            for(Student student:studentList){
                System.out.println(student.name+" "+ student.score);
            }
        }
    }
}
