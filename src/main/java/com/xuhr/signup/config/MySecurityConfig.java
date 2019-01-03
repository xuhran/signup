//package com.xuhr.signup.config;
//
///*
// *@ClassName MySecurityConfig
// *@Description TODO
// *@Author xuhr12
// *@Date 2019-01-02 10:06
// *@Version 1.0
// */
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
////        定制请求的授权规则
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/all").hasRole("administrator");
//        http.formLogin()
//                .loginPage("/login").permitAll();
//
//
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("xuhr").password("xuhr").roles("administrator")
//                .and()
//                .withUser("guige").password("guige").roles("member");
//
//    }
//}
