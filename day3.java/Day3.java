//  //对象数组的动态初始化
//  class Person{
//      private String name;
//      private int age;
//      public Person(String name,int age){
//          this.name=name;
//          this.age=age;
//      }
//  public void getInfo(){
//      System.out.println("姓名:"+this.name+"，年龄:"+this.age);
//  }
// }
//      public class Day3{
//          public static void main(String[] args){
//              Person[]per=new Person[3];//数组动态初始化；每个元素的默认值都其对应数据类型的默认值
//              per[0]=new Person("爸爸",43);
//              per[1]=new Person("妈妈",41);
//              per[2]=new Person("妹妹",11);
//              for(int i=0;i<per.length;i++){
//                  per[i].getInfo();
//              }
//          }
//      } 
     //对象数组静态初始化 
     class Person{
        private String name;
        private int age;
        public Person(String name,int age){
     this.name=name;
     this.age=age;
        }
     
     public void getInfo(){
       System.out.println("姓名："+this.name+"年龄："+this.age);
     }
    }    
     public class Day3{
         public static void main(String[] args){
        Person[]per=new Person[]{
            new Person("爸爸",43),
            new Person("妈妈",41),
            new Person("妹妹",11)
        };//对象数组静态初始化
        for(int i=0;i<per.length;i++){
            per[i].getInfo();
          }
        }
      }