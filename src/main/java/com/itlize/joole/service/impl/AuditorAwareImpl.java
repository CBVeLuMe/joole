package com.itlize.joole.service.impl;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Art Guo");
        // Can use Spring security to return currently logged in user
        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }
}
