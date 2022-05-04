package com.abritech.demoauth.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyCloakRoleConvertor implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        var realmAccess = (Map<String, Object>)source.getClaims().get("realm_access");
        if(CollectionUtils.isEmpty(realmAccess)){
            return new ArrayList<>();
        }

        Collection<GrantedAuthority> returnValue =  ((List<String>) realmAccess.get("roles"))
                .stream().map(role -> "ROLE_"+role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return returnValue;
    }
}
