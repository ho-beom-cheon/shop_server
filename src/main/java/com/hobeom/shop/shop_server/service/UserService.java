package com.hobeom.shop.shop_server.service;

import com.hobeom.shop.shop_server.data.dao.UserDao;
import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.data.entity.User;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDto insertUser(String email) {
        User user = new User();
        user.setEmail("통과");

        userRepository.save(user);
        return new UserDto();
    }
}
