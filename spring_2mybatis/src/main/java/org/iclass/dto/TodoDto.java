package org.iclass.dto;

import java.sql.Date;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
	private long tno;
	private String title;			//제목
						
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
	//private Date dueDate;		//할일 기한 날짜. mybatis에서 날짜타입을 Date 아닌
									//				ㄴ LocalDate 적용되는지 확인필요!!
									//				ㄴ 스프링의 다른 기능 사용을 위해 날짜타입 LocalDate 로 함
	private String writer;			//작성
	private boolean finished;		//완료여부
	
	
}

/*
 * CREATE TABLE tbl_todo(
 *  tno number(6) PRIMARY KEY, 
 *  title varchar2(100) NOT NULL, 
 *  dueDate DATE NOT NULL, 
 *  writer varchar2(50) NOT NULL, 
 *  finished number(2) DEFAULT 0 
 *  );
 * 
 * CREATE SEQUENCE todoSeq START WITH 20111;
 */
