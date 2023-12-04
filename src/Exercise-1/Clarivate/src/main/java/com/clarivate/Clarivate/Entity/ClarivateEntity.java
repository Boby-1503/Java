package com.clarivate.Clarivate.Entity;

import jakarta.persistence.Entity;

@Entity
public class ClarivateEntity
{
    private String category;
    private String subCategory;

    public ClarivateEntity(String category,String subCategory)
    {
        this.category=category;
        this.subCategory=subCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
