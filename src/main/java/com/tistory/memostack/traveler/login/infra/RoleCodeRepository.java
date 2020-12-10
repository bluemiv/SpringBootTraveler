package com.tistory.memostack.traveler.login.infra;

import com.tistory.memostack.traveler.login.domain.RoleCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleCodeRepository extends JpaRepository<RoleCode, Long> {}
