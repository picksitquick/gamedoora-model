package com.gamedoora.model.dao;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class Users extends Audit implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "provider_token", nullable = false)
	String providerToken;

	@Id
	@Column(name = "user_id", nullable = false)
	private String emailId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "provider_id")
	private long providerId;

	@Column(name = "password")
	private String password;

	@Column(name = "sign_in_count")
	private int signInCount;

	@Column(name = "session_token")
	private String sessionToken;

	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@Column(name = "photo_url")
	private String photoUrl;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "last_sign_in")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastSignIn;

	@Column(name = "last_sign_ip")
	private String lastSignIp;

	@Column(name = "current_sign_ip")
	private String currentSignIp;

	@Column(name = "current_sign_in")
	@Temporal(TemporalType.TIMESTAMP)
	Date currentSignIn;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<Roles> role;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_skills", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "skills_id"))
	Set<Skills> skills;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "studio_user_requests" , joinColumns = @JoinColumn(name = "studio_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	Set<Studios> studiosSet;
	//verify the table name studio_user

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_notification" , joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "notification_id"))
	Set<Notifications> notifications;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_board", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "boardId"))
	Set<KanBan> kanBanSet;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ProjectUser> projectUsers;
}
