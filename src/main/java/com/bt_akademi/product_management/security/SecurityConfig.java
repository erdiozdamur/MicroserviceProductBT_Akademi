package com.bt_akademi.product_management.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
    web tabanlı güvenlik sağlamak için
    @EnableWebSecurity "annotation"ı
    ve WebSecurityConfigurerAdapter sınıfı
    kullanılır.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Value("${service.security.secure-key-username}")
    private String secureKeyUsername;

    @Value("${service.security.secure-key-password}")
    private String secureKeyPassword;

    // Session kullanılmayacak. JSON Web Token (JWT) kullanılacak.
    // https://www.prismacsi.com/cross-site-request-forgery-csrf-nedir
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        super.configure(httpSecurity);

        httpSecurity.csrf().disable();
    }
}
