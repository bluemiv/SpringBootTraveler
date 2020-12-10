package com.tistory.memostack.traveler.login.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "role_map")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class RoleMap {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // N : 1
  @ManyToOne private User user;

  // N : 1
  @ManyToOne private RoleCode roleCode;

  @Column(nullable = false, length = 50)
  @CreationTimestamp
  private LocalDateTime registeredAt;

  private LocalDateTime updatedAt;
}
