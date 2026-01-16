package com.allan.dev.MovieFlix.service;

import com.allan.dev.MovieFlix.config.TokenService;
import com.allan.dev.MovieFlix.controller.request.LoginRequest;
import com.allan.dev.MovieFlix.controller.response.LoginResponse;
import com.allan.dev.MovieFlix.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthApplicationService {

    //Veio lá do springconfig
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public LoginResponse login(LoginRequest loginRequest){

        /*É um objeto padrão do Spring Security que representa:
        quem está tentando se autenticar
        com quais credenciais
         */
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

        /*
        * Pega a senha digitada, criptografa ela do mesmo jeito
         e compara com a senha criptografada do banco.
        * */
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        //quem é o usuário que acabou de provar que é quem diz ser
        User user = (User) authenticate.getPrincipal();

        String token = tokenService.gerarToken(user);

        return new LoginResponse(user.getEmail(), token);

    }
}
