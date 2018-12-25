//  // 1.创建一个Test类，包含有一个public权限的int型成员变量与一个char类型的成员变量，观察在main方法中的初始值。 

// class Test{
//     public int i;
//     public char j;
// }
// public class Day5{
//     public static void main(String[] args){
//         Test test=new Test();
//         System.out.println(test.i);
//         System.out.println(test.j);
//     }
//   }
//     //输出结果为0和空格 int型的默认值是0 char类型的默认值是\u0000 
    
//     // 2.编写一个程序，展示无论你创建了某个特定类的多少个对象，这个类的某个特定的static成员变量只有一个属性。
//     class Student{
//       public String name;
//       public int age;
//       public static String school;
//     }
// public class Day5{
//     public static void main(String[] args){
//       Student stu1=new Student();
//       Student stu2=new Student();
//       stu1.name="小红";
//       stu1.age=9;
//       Student.school="光明小学";
//       stu2.name="小明";
//       stu2.age=11;
//       Student.school="育才小学";
//       System.out.println(stu1.name+stu1.age+"岁的时候在"+stu1.school+"上学");
//       System.out.println(stu2.name+stu2.age+"岁的时候在"+stu2.school+"上学");
//       //输出结果为：小红9岁的时候在育才小学上学
//       //小明11岁的时候在育才小学上学 static修饰的school属性只有一个
//     }
// }
    
    // 3.一个斐波那契数列是由数字1、1、2、3、5、8、13、21、34等等组成的，其中每一个数字(从第三个数字起)都是前两个数字的和。
    //创建一个方法，接受一个整数参数，并显示从第一个元素开始总共由该参数指定的个数所构成的所有斐波那契数字。
    //例如，如果运行 java Fibonacci 5(Fibonacci为类名)，那么输出应该是1、1、2、3、5。 

    public class Day5{
        public static void main(String args[]){
            for(int i=0;i<=5;i++){
                System.out.println(fib(i));
            }
        }
        public static int fib(int i){
            if(i==1||i==2){
                return 1;
            }
            else{
                return fib(i-1)+fib(i-2);
            }
        }
    }

    // 4.创建一个带默认构造方法（即无参构造）的类，在构造方法中打印一条消息"Hello Constructor";
//     //再为这个类添加一个重载构造方法，令其接收一个字符串参数，并在这个有参构造方法中把"Hello Constructor"和接收的参数一起打印出来

//     class Print{
//           public Print(){
//               System.out.println("1.Hello Constructor");
//           } 
//           public Print(String p){
//             this();
//             System.out.println(p);
//           }
//     }
//  public class Day5{
//     public static void main(String[] args){
//      Print p=new Print("abc");
//     }
//  }