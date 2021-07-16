package com.example.rbac.repository;

import com.example.rbac.entry.SysUser;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SysUserRepository extends ReactiveCrudRepository<SysUser, Long> {
    @Query("select * from sys_user where username = :username")
    Mono<SysUser> findByUsername(@Param("username") String username);
}
