package com.formypet.jpa.user.entity;

import java.util.ArrayList;
import java.util.List;

import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.cart.entity.Cart;
import com.formypet.jpa.product.entity.ProductReply;
import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.dto.UserLoginDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "userentity")
@Table(name = "userentity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userId;
    
    private String userPassword;

    private String userName;

    private String userAddress;
    
    private String userAddressDetail;
    
    private String userBirthDate;
    
    
    public static User toEntity(UserLoginDto dto) {
        return User.builder()
                         .userId(dto.getUserId())
                         .userPassword(dto.getUserPassword())
                         .build();
    }
    
    public static User toEntity(UserDto dto) {
    	return User.builder()
    					 .userId(dto.getUserId())
    					 .userPassword(dto.getUserPassword())
    					 .userName(dto.getUserName())
    					 .userAddress(dto.getUserAddress())
    					 .userAddressDetail(dto.getUserAddressDetail())
    					 .userBirthDate(dto.getUserBirthDate())
    					 .build();
    
    }
    
    //유저와 상품댓글관계설정
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<ProductReply> productReplyList =new ArrayList<>();
    
    //유저와 장바구니 관계설정
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name="cart_id")
    private Cart cart;
    
    // 유저와 게시판 관계 설정
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Board> boards = new ArrayList<>();
    
 }
   
