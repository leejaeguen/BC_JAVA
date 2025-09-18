package com.worms.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "category_and_menu")
@Table(name = "tbl_category")
public class CategoryAndMenu {
    @Id
    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private String refCategoryCode;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_code") // 자식의 fk 제약조건이 걸린 컬럼명 작성
    private List<Menu> menuList;

    public CategoryAndMenu(String categoryCode, String categoryName, String refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public CategoryAndMenu() {}

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(String refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenu{" +
                "categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode='" + refCategoryCode + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
