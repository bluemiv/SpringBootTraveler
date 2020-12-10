package com.tistory.memostack.traveler.login.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Accessors(chain = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(length = 50)
  private String email;

  @Column(length = 50)
  private String phoneNumber;

  @Column(nullable = false, length = 50)
  @CreationTimestamp
  private LocalDateTime registeredAt;

  private LocalDateTime updatedAt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<RoleMap> roleMapList = new ArrayList<>();
}
