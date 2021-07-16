package com.example.rbac.config;

import com.example.rbac.security.RbacReactiveAuthorizationManager;
import com.example.rbac.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityWebFluxConfig {
    private final SysUserService sysUserService;

    @Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http.formLogin().and().authorizeExchange()
                .pathMatchers("/**").access(new RbacReactiveAuthorizationManager(sysUserService))//自定义的鉴权服务，通过鉴权的才能继续访问某个请求
//                .pathMatchers("/download").access((authentication, context) ->
//                authentication
//                        .map(Authentication::getName)
//                        .map(username -> username.equals(context.getVariables().get("username")))
//                        .map(AuthorizationDecision::new)
//        )
//                .pathMatchers("/users/{username}").access((authentication, context) ->
//                    authentication
//                        .map(Authentication::getName)
//                        .map(username -> username.equals(context.getVariables().get("username")))
//                        .map(AuthorizationDecision::new)
//                 )
//                .and().authorizeExchange().anyExchange().authenticated()
//                .authenticationManager(myReactiveAuthenticationManager)//自定义登录验证。自动扫描注入，无需手动注入
////                .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
//                .pathMatchers(HttpMethod.OPTIONS).permitAll() //option 请求默认放行
//               .and()
//                .authorizeExchange()
//                .anyExchange().authenticated()
//                .pathMatchers("/**").access(new RbacReactiveAuthorizationManager())//自定义的鉴权服务，通过鉴权的才能继续访问某个请求
//                .loginPage("/auth/login")//指定登录请求路径
//                .authenticationSuccessHandler(loginSuccessHandlerWebFlux) //认证成功
//                .authenticationFailureHandler(loginFailedHandlerWebFlux) //登陆验证失败
//                .and().exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint)  //未登录访问资源时的处理类，若无此处理类，前端页面会弹出登录窗口
//                .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandlerWebFlux)//访问被拒绝时自定义处理器
                .and().csrf().disable();//必须支持跨域
//                .logout().logoutUrl("/auth/logout");
//                .logoutSuccessHandler(logoutSuccessHandlerWebFlux);//成功登出时调用的自定义处理类

        return http.build();
    }
}