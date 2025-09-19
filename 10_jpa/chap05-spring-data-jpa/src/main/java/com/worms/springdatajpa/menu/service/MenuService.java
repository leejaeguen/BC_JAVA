package com.worms.springdatajpa.menu.service;

import com.worms.springdatajpa.menu.controller.CategoryDTO;
import com.worms.springdatajpa.menu.dto.MenuDTO;
import com.worms.springdatajpa.menu.entity.Category;
import com.worms.springdatajpa.menu.entity.Menu;
import com.worms.springdatajpa.menu.repository.CategoryRepository;
import com.worms.springdatajpa.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuService {
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository
            , ModelMapper modelMapper
            , CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    /* 설명. 1. findById(), Optional이 반환되는 점을 고려(get(), orElseXXX()) */
    public MenuDTO findMenuByCode(int menuCode) {

        Menu menu = menuRepository.findById(menuCode)
                .orElseThrow(IllegalArgumentException::new);
        log.debug("service계층에서 하나의 메뉴 상세보기: {}", menu);
        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 설명. 2. findAll() (페이징 처리 전) */
    public List<MenuDTO> findMenuList() {

        /* 설명. 내가 원하는 속성에 대한 정렬 가능(feat.Sort.by) */
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());
        log.debug("service계층에서 모든 메뉴보기: {}", menus);

        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명. 3. findAll() (페이징 처리 후) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {

        /* 설명.
         *  넘어온 Pageable 객체를 커스터마이징
         *  1. page 값이 넘어오면 인덱스 개념으로 바꾼다.(front에서 페이지 번호가 그대로 넘어왔다는 가정)
         *  2. 한 페이지에 뿌릴 사이즈는 유지
         *  3. 정렬 기준을 내림차순으로 변경
         * */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());
        Page<Menu> menuList = menuRepository.findAll(pageable);

        /* 설명. Page는 자체로 stream이다. */
        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));

    }


    public List<CategoryDTO> findAllCategory() {
        List<Category> categories = categoryRepository.findAllCategories();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void registMenu(MenuDTO newMenu) {
        menuRepository.save(modelMapper.map(newMenu, Menu.class));
    }
}