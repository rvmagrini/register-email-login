package com.rvmagrini.registerverificationlogin.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
	
	Optional<ConfirmationToken> findByToken(String token);
	
	Optional<ConfirmationToken> findByAppUserId(Long id);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE ConfirmationToken c " +
			"SET c.confirmedAt = ?2 " +
			"WHERE c.token = ?1")
	int updateConfirmedAt(String token, LocalDateTime confirmedAt);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE confirmation_token " +
			"SET token = ?1, " +
			"created_at = ?2,  " +
			"expires_at = ?3  " +
			"WHERE app_user_id = ?4 ",
			nativeQuery = true
			)
	int updateToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Long userId);
	

}
