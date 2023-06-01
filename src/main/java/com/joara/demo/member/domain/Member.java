package com.joara.demo.member.domain;




import com.joara.demo.member.domain.type.AccountStatus;
import com.joara.demo.member.domain.type.Gender;
import com.joara.demo.support.MySchemaConstants;
import com.joara.demo.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.*;

import java.time.OffsetDateTime;

import static com.joara.demo.support.Constants.DEFAULT_TIMEZONE_ID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
		name = MySchemaConstants.TB_MEMBER,
		schema = MySchemaConstants.SCHEMA
//		catalog = MySchemaConstants.SCHEMA
)
public class Member extends UuidBaseEntity {
	
	@Column
	public String email;
	@Column
	public String password;
	@Column
	public String name;
	@Column
	public String nickname;
	@Column
	public String phone;
	@Column
	@Enumerated(EnumType.STRING)
	public Gender gender;
	@Column
	public OffsetDateTime birth;
	@Column
	@Builder.Default
	public OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
	@Column
	public OffsetDateTime updatedAt;
	@Column
	public OffsetDateTime deletedAt;
	@Column
	@Enumerated(EnumType.STRING)
	public AccountStatus status;
}

