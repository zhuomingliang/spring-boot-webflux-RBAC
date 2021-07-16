package com.example.rbac.entry;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "sys_users_roles",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    @ToString.Exclude
    private Set<SysRole> roles;

    @NotNull
    @Column
    private String username;

    @NotNull
    @Column
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        SysUser sysUser = (SysUser) o;

        return Objects.equals(id, sysUser.id);
    }

    @Override
    public int hashCode() {
        return 421708296;
    }
}
