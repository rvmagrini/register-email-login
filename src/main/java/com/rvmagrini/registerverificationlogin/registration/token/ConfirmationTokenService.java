package com.rvmagrini.registerverificationlogin.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
	
	private final ConfirmationTokenRepository confirmationTokenRepository;
	
	public void saveConfirmationToken(ConfirmationToken token) {
		confirmationTokenRepository.save(token);
	}
	
	public Optional<ConfirmationToken> getToken(String token) {
		return confirmationTokenRepository.findByToken(token);
	}
	
	public int setConfirmedAt(String token) {
		return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
	}
	
	public int updateToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Long userId) {
		return confirmationTokenRepository.updateToken(token, createdAt, expiresAt, userId);
	}
	

}
