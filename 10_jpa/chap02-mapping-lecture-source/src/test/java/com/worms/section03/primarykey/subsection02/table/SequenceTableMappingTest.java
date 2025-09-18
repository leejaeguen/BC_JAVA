package com.worms.section03.primarykey.subsection02.table;

import com.worms.section03.primarykey.subsection01.identity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class SequenceTableMappingTest {
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
    public void 식별자_매핑_테스트() {
        com.worms.section03.primarykey.subsection01.identity.Member member = new com.worms.section03.primarykey.subsection01.identity.Member();
//        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setEmail("hong@gmail.com");
        member.setAddress("서울시 서초구");
        member.setEnrollDate(new java.util.Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");

        com.worms.section03.primarykey.subsection01.identity.Member member2 = new com.worms.section03.primarykey.subsection01.identity.Member();
//        member.setMemberNo(1);
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("유관순");
        member2.setEmail("yu@gmail.com");
        member2.setAddress("서울시 강남구");
        member2.setEnrollDate(new java.util.Date());
        member2.setMemberRole("ROLE_ADMIN");
        member2.setStatus("Y");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /* 설명. PK전략을 GenerationType.IDENTITY로 가져가면 persist 시점에 insert가 무조건 발생한다.(즉시 flush() 호출됨) */
        System.out.println("persist 전 member: " + member);
        entityManager.persist(member);
        entityManager.persist(member2);
        System.out.println("persist 후(flush 된 후) member: " + member);

        /* 설명. persist 당시에는 부여되지 않은 pk값으로 commit 이후 조회를 하면 가능할까? */
        com.worms.section03.primarykey.subsection01.identity.Member selectedMember = entityManager.find(Member.class, 1);
        System.out.println("selectedMember = " + selectedMember);

        transaction.commit();
    }

}
