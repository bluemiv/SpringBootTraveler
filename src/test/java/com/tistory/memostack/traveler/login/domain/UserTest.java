package com.tistory.memostack.traveler.login.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class UserTest {

  @Test
  void 생성_테스트() {
    // given
    final String username = "tester";
    final String password = new BCryptPasswordEncoder().encode("1234");
    final String email = "tester@google.com";
    final String phoneNumber = "010-1234-1234";
    final LocalDateTime now = LocalDateTime.now();

    // when
    final User user =
        User.builder()
            .username(username)
            .password(password)
            .email(email)
            .phoneNumber(phoneNumber)
            .registeredAt(now)
            .build();

    // then
    assertEquals(username, user.getUsername());
    assertEquals(password, user.getPassword());
    assertEquals(email, user.getEmail());
    assertEquals(phoneNumber, user.getPhoneNumber());
    assertEquals(now, user.getRegisteredAt());
    assertEquals(
        "User(id=null, username="
            + username
            + ", password="
            + password
            + ", email="
            + email
            + ", phoneNumber="
            + phoneNumber
            + ", registeredAt="
            + now
            + ", updatedAt=null, roleMapList=null)",
        user.toString());
  }
}
