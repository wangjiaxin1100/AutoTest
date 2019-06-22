package com.ab.model;

public class Getphone {
    private Integer id;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString(){
        return (
                "id:"+id+","+
                        "userName:"+phone
        );
    }

}