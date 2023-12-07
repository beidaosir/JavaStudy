package com.hnu.po;

public class Pcas {

    private String code;
    private String name;
    private String parent;
    private Integer type;

    public Pcas() {
    }

    public Pcas(String code, String name, String parent, Integer type) {
        this.code = code;
        this.name = name;
        this.parent = parent;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
