package com.worms.section01.manytoone;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @Column(name = "category_code")
    private String categoryCode;
    
    @Column(name = "category_name")
    private String categoryName;
    
    /* 설명. Null값이 들어갈 수 있는 엔티티의 필드는 참조자료형을 쓰자 */
    @Column(name = "ref_category_code")
    private String refCategoryCode;

    public Category(String categoryCode, String categoryName, String refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public Category() {}

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(String refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode='" + refCategoryCode + '\'' +
                '}';
    }
}
