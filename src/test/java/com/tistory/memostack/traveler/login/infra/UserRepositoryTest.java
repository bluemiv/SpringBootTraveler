package com.tistory.memostack.traveler.login.infra;

import com.tistory.memostack.traveler.login.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
class UserRepositoryTest {

  @Autowired private UserRepository userRepository;

  @Test
  void findByUsername() {
    final String username = "tester";
    final String password = new BCryptPasswordEncoder().encode("1234");
    userRepository.save(
        User.builder()
            .username(username)
            .password(password)
            .registeredAt(LocalDateTime.now())
            .build());
    Optional<User> optionalUser = userRepository.findByUsername(username);

    assertTrue(optionalUser.isPresent());
    optionalUser.ifPresent(
        user -> {
          assertEquals(username, user.getUsername());
          assertEquals(password, user.getPassword());
        });
  }

  @Test
  void findByEmail() {}
}
