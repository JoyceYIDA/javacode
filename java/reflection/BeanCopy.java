package Day.reflection;

import java.lang.reflect.Field;

public class BeanCopy {

    public static void copy(Object source, Object target) {

        if(source==null||target==null){
            throw new IllegalArgumentException("目标对象或者原对象不能为空");
        }

//        1.获取对象的class
        Class sourceClass=source.getClass();
        Class targetClass=target.getClass();

//        2.获取每个class对象中的属性
        Field[] sourceFields=sourceClass.getDeclaredFields();
        Field[] targetFields=targetClass.getDeclaredFields();
//        3.源数组找目标数组中的元素
        for (Field s:sourceFields
                ) {
            for (Field t:targetFields
                    ) {
//                判断属性名是否相同
                if(s.getName().equals(t.getName())){
//                    可以通过原对象的getter方法取值，再通过目标对象的setter方法赋值
//                    也可以通过字段的赋值
                    s.setAccessible(true);
                    t.setAccessible(true);
                    try {
                        Object value=s.get(source);
                        t.set(target,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Teacher ter=new Teacher();
//        三个属性都有值
        ter.setName("joyce");
        ter.setGender(false);
        ter.setSkills("java");
//        三个属性都为null
        User user=new User();

        BeanCopy.copy(ter,user);

        System.out.println(ter);
        System.out.println(user);
    }
}
class Teacher{
    private String name;
    private String skills;
    private Boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                ", gender=" + gender +
                '}';
    }
}

class User{
    private String name;
    private String password;
    private Boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}

