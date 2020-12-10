package com.tistory.memostack.traveler.login.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role_code")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
@Accessors(chain = true)
public class RoleCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String roleName;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleCode")
  private List<RoleMap> roleMapList = new ArrayList<>();

  @Column(nullable = false, length = 50)
  @CreationTimestamp
  private LocalDateTime registeredAt;

  private LocalDateTime updatedAt;
}
