package com.worms.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.worms.xmlmapper.Template.getSqlSession;

public class ElementService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menus = mapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuAndCategoryDTO> menus = mapper.selectResultMapAssociationTest();
        menus.forEach(System.out::println);

        System.out.println("첫 번째 메뉴의 카테고리 이름 조회: "
                + menus.get(0).getCategory().getCategoryName());

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<CategoryAndMenuDTO> categories = mapper.selectResultMapCollectionTest();
        categories.forEach(System.out::println);

        System.out.println();
        System.out.println("'식사' 카테고리의 메뉴들 ");
        System.out.println(categories.get(3).getMenus());

        sqlSession.close();
    }
}