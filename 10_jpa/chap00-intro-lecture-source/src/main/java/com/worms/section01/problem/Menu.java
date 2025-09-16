package com.worms.section01.problem;

public class Menu {
    private int MenuCode;
    private String MenuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public Menu(int menuCode, int menuPrice, String menuName, int categoryCode, String orderableStatus) {
        MenuCode = menuCode;
        this.menuPrice = menuPrice;
        MenuName = menuName;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public Menu(){}

    public int getMenuCode() {
        return MenuCode;
    }

    public void setMenuCode(int menuCode) {
        MenuCode = menuCode;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "MenuCode=" + MenuCode +
                ", MenuName='" + MenuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
