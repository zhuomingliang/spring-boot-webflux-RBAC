package com.example.rbac.service;

import com.example.rbac.entry.SysUser;
import com.example.rbac.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SysUserService {
    private final SysUserRepository sysUserRepository;

    public Mono<SysUser> findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
