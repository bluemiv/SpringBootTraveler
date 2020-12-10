package com.tistory.memostack.traveler.login.infra;

import com.tistory.memostack.traveler.login.domain.RoleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapRepository extends JpaRepository<RoleMap, Long> {}
