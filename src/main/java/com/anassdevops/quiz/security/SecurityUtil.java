package com.anassdevops.quiz.security;

public class SecurityUtil {

    public static final String AUTH_HEAD = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final String SECRET = "mySecret1234";
    public static final long ACCESS_TOKEN_DURATION = 10*60*1000; // 10 min
    public static final long REFRESH_TOKEN_DURATION = 30*60*1000; // 30 min

}
