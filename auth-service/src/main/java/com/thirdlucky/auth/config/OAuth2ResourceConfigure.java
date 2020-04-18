package com.thirdlucky.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class OAuth2ResourceConfigure extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .and()
                //  永远不会创建session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 权限需要和认证服务器部分对应
                .antMatchers("/").hasAuthority("SystemContext")
                .antMatchers("/view/**").hasAuthority("SystemContextView")
                .antMatchers("/insert/**").hasAuthority("SystemContextInsert")
                .antMatchers("/update/**").hasAuthority("SystemContextUpdate")
                .antMatchers("/delete/**").hasAuthority("SystemContextDelete")
        ;
    }
}
