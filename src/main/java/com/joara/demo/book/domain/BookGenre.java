package com.joara.demo.book.domain;

import com.joara.demo.support.MySchemaConstants;
import com.joara.demo.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
@Table(
		name = MySchemaConstants.TB_BOOK_GENRE,
		schema = MySchemaConstants.SCHEMA
//		catalog = MySchemaConstants.SCHEMA
)
public class BookGenre extends UuidBaseEntity {
	@Column
	private String kor;
	@Column
	private String eng;
}