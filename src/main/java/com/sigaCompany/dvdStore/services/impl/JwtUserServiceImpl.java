package com.sigaCompany.dvdStore.services.impl;

import com.sigaCompany.dvdStore.entities.Owner;
import com.sigaCompany.dvdStore.entities.Role;
import com.sigaCompany.dvdStore.exceptions.AccountExistException;
import com.sigaCompany.dvdStore.repositories.OwnerRepository;
import com.sigaCompany.dvdStore.services.JwtUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * The type Jwt user service.
 */
@Service
public class JwtUserServiceImpl implements JwtUserService {
    @Autowired
    private OwnerRepository ownerRepository;

    /**
     * The Authentication configuration.
     */
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private String signingKey;

    /**
     * Instantiates a new Jwt user service.
     *
     * @param signingKey the signing key
     */
    public JwtUserServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        Owner owner = ownerRepository.findByLogin(username);
        if (owner == null) {
            throw new UsernameNotFoundException("Pas trouvé le Owner");
        }
        return owner;
    }

    @Override
    public Authentication authenticate(String username, String password) throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationConfiguration.getAuthenticationManager().authenticate(authentication);
    }

    @Override
    public UserDetails save(String username, String password) throws AccountExistException {
        UserDetails existingUser = ownerRepository.findByLogin(username);
        if (existingUser != null) {
            throw new AccountExistException();
        }
        Owner owner = new Owner();
        owner.setLogin(username);
        owner.setPassword(passwordEncoder.encode(password));
        owner.setRoles(List.of(new Role(1,"1")));
        ownerRepository.save(owner);
        return owner;
    }

    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        System.out.println(signingKey);
        Claims claims = Jwts
                        .parser()
                        .setSigningKey(signingKey)
                        .parseClaimsJws(token)
                        .getBody();
        return claims.getSubject();
    }


    @Override
    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600 * 1000);
        return
                Jwts.builder()
                        .setSubject(user.getUsername())
                        .setIssuedAt(now)
                        .setExpiration(expiryDate)
                        .signWith(SignatureAlgorithm.HS512, signingKey)
                        .compact();
    }



}
