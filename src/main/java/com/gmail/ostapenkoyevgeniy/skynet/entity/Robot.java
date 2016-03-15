package com.gmail.ostapenkoyevgeniy.skynet.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("year")
    private int year;

    public Robot() {}

    public Robot(int id, String name, String type, int year) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    // TODO delete
    public static List<Robot> getTestRobots() {
        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot(1, "T-200", "droid", 1991));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        robots.add(new Robot(2, "T-400", "droid", 1993));
        robots.add(new Robot(3, "T-600", "droid", 1995));
        robots.add(new Robot(4, "T-800", "droid", 1998));
        return robots;
    }
}
