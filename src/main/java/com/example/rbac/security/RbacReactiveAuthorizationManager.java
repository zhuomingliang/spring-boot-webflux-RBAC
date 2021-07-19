package com.example.rbac.security;

import com.example.rbac.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
public class RbacReactiveAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    private final HashMap<String, HashMap<String, ArrayList<String>>> user_roles = new HashMap<>();

    private final SysUserService sysUserService;

//    public RbacReactiveAuthorizationManager() {
//        ArrayList<String> role_permissions = new ArrayList<>();
//        role_permissions.add("/");
//        role_permissions.add("/download");
//        HashMap<String, ArrayList<String>> roles = new HashMap<>();
//        roles.put("dev", role_permissions);
//        user_roles.put("user", roles);
//    }

    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext context) {
        return authentication
                .map(auth -> {
                    String username = auth.getName();
                    log.info(username);

                    sysUserService.findByUsername(username).subscribe(s -> {
                        log.info("22222");
                        log.info(s.toString());
                    });
//                    ArrayList<String> role_permissions = user_roles.get(username).get("dev");
//                    String path = context.getExchange().getRequest().getPath().value();
//                    boolean granted = role_permissions.contains(path);

//                    log.debug(role_permissions.toString());
//                    log.debug(path);
//                    log.debug(String.valueOf(granted));
                    return new AuthorizationDecision(true);
                })
                .defaultIfEmpty(new AuthorizationDecision(false));
    }
}
