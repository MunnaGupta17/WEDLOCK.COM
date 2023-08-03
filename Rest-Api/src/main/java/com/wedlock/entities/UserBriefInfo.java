package com.wedlock.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBriefInfo {
	
	private String profilePicture;
	private String name;
	private Integer age;
	private LocalDate dateOfBirth;

}
