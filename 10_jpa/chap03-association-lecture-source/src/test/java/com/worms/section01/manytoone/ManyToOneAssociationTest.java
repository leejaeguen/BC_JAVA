package com.worms.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

public class ManyToOneAssociationTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void 다대일_연관관계_객체_그래프_탐색을_이용한_조회_테스트() {
        int menuCode = 15;

        /* 설명. 만약에 메뉴만 보고 싶다면?
         *      : FetchType.EAGER가 아닌 FetchType.LAZY로 바꿔 주어야 한다.
         *      조인도 하고 싶다면?
         *      : jpql을 활용한 fetch join을 진행하면 된다.
         * */
        /* 설명. 1. 메뉴만 조회한 경우 */
        MenuAndCategory foundMenu = entityManager.find(MenuAndCategory.class, menuCode);
        System.out.println("foundMenu = " + foundMenu);

        /* 설명. 2. 카테고리와 fetch 조인을 하는 경우 */
        String jpql = "select m from menu_and_category m join fetch m.category where m.menuCode ="
                + menuCode;
        TypedQuery<MenuAndCategory> typeMenu = entityManager.createQuery(jpql, MenuAndCategory.class);
        MenuAndCategory menu = typeMenu.getSingleResult();
        System.out.println("menu = " + menu);
        System.out.println("카테고리만 확인: " + menu.getCategory());
    }
}