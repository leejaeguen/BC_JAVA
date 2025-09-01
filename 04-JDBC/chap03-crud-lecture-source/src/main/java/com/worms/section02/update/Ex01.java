package com.worms.section02.update;

import com.worms.section02.update.MenuService;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("변경 할 메뉴 번호를 입력하세요: ");
        int menuCode = sc.nextInt();
        System.out.println("변경 할 메뉴 이름을 입력하세요: ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.println("변경 할 메뉴 가격을 입력하세요: ");
        int menuprice = sc.nextInt();

        Menu menu = new Menu(menuCode, menuName, menuprice);
        MenuService service = new MenuService();
        service.modifyMenu(menu);
    }
}
