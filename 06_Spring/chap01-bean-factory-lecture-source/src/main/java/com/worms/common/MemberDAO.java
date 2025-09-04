package com.worms.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/* 설명. @Repository도 @Component 계열이라 bean이 된다. */
@Repository
//@Component
public class MemberDAO {

    public MemberDAO(){
        System.out.println("콩 될 때 이거 쓰나?");
    }
}
