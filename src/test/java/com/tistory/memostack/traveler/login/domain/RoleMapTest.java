package com.tistory.memostack.traveler.login.domain;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleMapTest {

  @Test
  void 생성_테스트() {
    // given
    final LocalDateTime now = LocalDateTime.now();
    final String username = "tester";
    final String roleName = "ROLE_ADMIN";

    // when
    final RoleMap roleMap =
        RoleMap.builder()
            .registeredAt(now)
            .user(
                User.builder()
                    .username(username)
                    .password(new BCryptPasswordEncoder().encode("1234"))
                    .email("tester@google.com")
                    .phoneNumber("010-1234-1234")
                    .registeredAt(now)
                    .build())
            .roleCode(RoleCode.builder().roleName(roleName).registeredAt(now).build())
            .build();

    // then
    assertEquals(username, roleMap.getUser().getUsername());
    assertEquals(roleName, roleMap.getRoleCode().getRoleName());
  }
}
