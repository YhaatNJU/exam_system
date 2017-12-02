package com.homework.examSystem.web.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yha
 * @decription 累计失败次数的验证器
 * @create 2017-11-19 16:13
 **/
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{

    private Cache<String, AtomicInteger> passwordRetryCache;



    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager, String cacheAlias) {

        passwordRetryCache = cacheManager.getCache(cacheAlias);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        //retry count+1
        AtomicInteger count = passwordRetryCache.get(username);
        if (count == null){
            count = new AtomicInteger(0);
            passwordRetryCache.put(username, count);
        }
        if (count.intValue() >= 5){
            //retry count > 5
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (matches){
            passwordRetryCache.remove(username);
        }else {
            count.incrementAndGet();
            passwordRetryCache.put(username, count);
        }

        return matches;
    }
}
