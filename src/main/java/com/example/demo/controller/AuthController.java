package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RefreshTokenRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.Trade;
import com.example.demo.service.AuthService;
import com.example.demo.service.RefreshTokenService;
import com.example.demo.service.TradeService;

import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
 
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private TradeService tradeService;
	@Autowired
    private  AuthService authService;
    @Autowired
    private  RefreshTokenService refreshTokenService;

	
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }
    
    @PostMapping("/addtrade")
    public ResponseEntity<String> addTrade(@RequestBody Trade trade) {
    	tradeService.addTrade(trade);
        return new ResponseEntity<>("Adding tarde Successful",
                OK);
    }
}
