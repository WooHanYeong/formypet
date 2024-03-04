package com.formypet.jpa.user.dto;

import java.util.Map;

import com.formypet.jpa.user.entity.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;


    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
    	if("naver".equals(registrationId)) {
    		return ofNaver("id",attributes);
    	}else if("kakao".equals(registrationId)){
    		return ofKakao("id",attributes);
    	}
  
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofKakao(String usernameAttributeName, Map<String, Object> attributes) {
		Map<String,Object> response = (Map<String,Object>) attributes.get("kakao_account");
		Map<String,Object> account = (Map<String,Object>) attributes.get("profile");
		return OAuthAttributes.builder()
                .name((String) account.get("nickname"))
                .email((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(usernameAttributeName)
                .build();
	}

	private static OAuthAttributes ofNaver(String usernameAttributeName, Map<String, Object> attributes) {
		Map<String,Object> response = (Map<String,Object>) attributes.get("response");
		 return OAuthAttributes.builder()
	                .name((String) response.get("name"))
	                .email((String) response.get("email"))
	                .attributes(response)
	                .nameAttributeKey(usernameAttributeName)
	                .build();
	}

	// 구글 생성자
    private static OAuthAttributes ofGoogle(String usernameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(usernameAttributeName)
                .build();
    }

    // User 엔티티 생성
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }
}
