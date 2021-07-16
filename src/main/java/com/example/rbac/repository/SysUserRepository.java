package com.example.rbac.repository;

import com.example.rbac.entry.SysUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SysUserRepository extends ReactiveCrudRepository<SysUser, Long> {
    Mono<SysUser> findByUsername(String username);
}
