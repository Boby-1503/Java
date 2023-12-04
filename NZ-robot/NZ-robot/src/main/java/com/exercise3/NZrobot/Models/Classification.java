package com.exercise3.NZrobot.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class Classification {
    private String name;
    private String type;
    private String classNumber;
    private String image;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getImage() {
        return image;
    }
}