package com.hobeom.shop.shop_server.data.repository.Impl;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 레포지토리 빈으로 등록
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
public abstract class UserRepositoryImpl implements UserRepository{

    @PersistenceContext //
    private EntityManager em;

    // qureydsl 사용
     private final JPAQueryFactory queryFactory;


    @Override // 메서드 재정의
    public Optional<UserEntity> findByUserId(long userId) {
        UserEntity userEntity = em.find(UserEntity.class, userId); // userId로 UserEntity 조회
        return Optional.ofNullable(userEntity); // userEntity가 null이 아니면 userEntity 반환
    }

    @Override // 메서드 재정의
    public UserEntity save(UserEntity userEntity) {
        em.persist(userEntity); // userEntity를 영속화
        return userEntity;      // userEntity 반환
    }

    @Override // 메서드 재정의
    public void delete(UserEntity userEntity) {
        em.remove(userEntity); // userEntity 삭제
    }
}
