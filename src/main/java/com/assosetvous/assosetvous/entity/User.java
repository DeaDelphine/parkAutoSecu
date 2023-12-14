package com.assosetvous.assosetvous.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Data
@Entity
@RequiredArgsConstructor
@Table(name="USER")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDUSER")
	private long id;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ROLE")
	private Role role; // Role_USER (read, edit) , ROLE_ADMIN (...., delete)

	@Column(name = "PROFILEIMAGE")
	private String profileImageUrl;

	@JsonIgnore
	@Column(name = "AUTHORITIES")
	private String authorities; //[]=tableau de strings // Authorities = permissions (read, edit, delete)

	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	@Column(name = "IS_NOT_LOCKED")
	private boolean isNotLocked;

	private Date lastLoginDate = new Date();
	private Date lastLoginDateDisplay = new Date();
	private Date joinDate = new Date();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public String getPassword(){
		return password;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}





}
