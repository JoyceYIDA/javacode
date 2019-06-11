package com.dom4j.read;

/**
 * javabean
 *
 * 1)当前类是一个具体类
 * 2）在类中提供私有的字段（属性） private String id（id属性字段）
 * 3）提供对外的公共方法setXXX/getXXX/isXXX public void setID/...（将id首字母小写，bean属性）
 * 4）类实现序列化：serializable接口（JDK中大量常用的类：如String等都实现了该接口）
 *
 * */
public class Contact {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
