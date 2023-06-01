package com.joara.demo.book.domain;


import com.joara.demo.support.MySchemaConstants;
import com.joara.demo.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
		name = MySchemaConstants.TB_BOOK_TAG,
		schema = MySchemaConstants.SCHEMA
		//		catalog = MySchemaConstants.SCHEMA
)
public class BookTag extends UuidBaseEntity {
	@Column
	private UUID bookId;
	@Column
	private UUID bookFreeTagId;
}
