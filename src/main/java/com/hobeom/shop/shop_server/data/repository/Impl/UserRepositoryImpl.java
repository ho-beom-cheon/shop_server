package com.hobeom.shop.shop_server.data.repository.Impl;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hobeom.shop.shop_server.data.entity.QUserEntity.userEntity;

@Repository // 레포지토리 빈으로 등록
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
public abstract class UserRepositoryImpl implements UserRepository{
    // JPAQueryFactory를 주입받음
    private final JPAQueryFactory query;
    @Override // 메서드 재정의
    public UserEntity findByUserId(String userId) {
        return query.select(userEntity)              // userEntity 조회
                .from(userEntity)                    // userEntity에서 조회
                .where(userEntity.userId.eq(userId)) // userId가 userId와 같은 것을 조회
                .fetchOne();                         // 하나의 결과를 반환
    }
}
