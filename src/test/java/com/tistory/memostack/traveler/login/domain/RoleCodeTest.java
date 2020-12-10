package com.tistory.memostack.traveler.login.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleCodeTest {

  @Test
  void 생성_테스트() {
    // given
    final String roleName = "ROLE_ADMIN";

    // when
    final RoleCode roleCode =
        RoleCode.builder().roleName(roleName).registeredAt(LocalDateTime.now()).build();

    // then
    assertEquals(roleName, roleCode.getRoleName());
  }
}
