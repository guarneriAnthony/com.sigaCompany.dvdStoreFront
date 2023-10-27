package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.dto.AuthRequestDto;
import com.sigaCompany.dvdStore.dto.AuthResponseDto;
import com.sigaCompany.dvdStore.entities.Owner;
import com.sigaCompany.dvdStore.exceptions.AccountExistException;
import com.sigaCompany.dvdStore.exceptions.UnauthorizedException;
import com.sigaCompany.dvdStore.services.JwtUserService;
import com.sigaCompany.dvdStore.services.impl.JwtUserServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SecurityController {
    @Autowired
    private JwtUserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto dto) throws AccountExistException {
        System.out.println("rr");
        UserDetails user = userService.save(dto.getUsername(), dto.getPassword());
        String token = userService.generateJwtForUser(user);
        return ResponseEntity.ok(new AuthResponseDto(user, token));
    }

    @PostMapping("/authorize")
    public ResponseEntity<AuthResponseDto> authorize(@RequestBody AuthRequestDto requestDTO) throws UnauthorizedException {
        System.out.println("lala");
        Authentication authentication = null;
        try {
            authentication = userService.authenticate(requestDTO.getUsername(), requestDTO.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(user);
            return ResponseEntity.ok(new AuthResponseDto(user, token));
        } catch (AuthenticationException e) {
            throw new UnauthorizedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
