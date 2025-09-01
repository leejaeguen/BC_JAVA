package com.worms.section01.insert;

public class Menu {
    private int menuCode;
    private String menuName;
    private int menuprice;
    private int categoryCode;
    private String orderableStatus;

    public Menu(){
    }
    public Menu(String menuName, int menuprice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuprice = menuprice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuprice() {
        return menuprice;
    }

    public void setMenuprice(int menuprice) {
        this.menuprice = menuprice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getorderableStatus() {
        return orderableStatus;
    }

    public void setorderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuprice=" + menuprice +
                ", categoryCode=" + categoryCode +
                ", categoryStatus='" + orderableStatus + '\'' +
                '}';
    }
}
