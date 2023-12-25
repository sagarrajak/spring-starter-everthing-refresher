package com.springstarter.springstarterweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;

	@NotBlank(message = "Please add department name!")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

	public void  mergeDepartment(DepartmentEntity mergeFrom) {
		if (Objects.nonNull(mergeFrom.departmentAddress) && !"".equalsIgnoreCase(mergeFrom.departmentAddress)) {
			this.setDepartmentAddress(mergeFrom.departmentAddress);
		}
		if (Objects.nonNull(mergeFrom.departmentCode) && !"".equalsIgnoreCase(mergeFrom.departmentCode)) {
			this.setDepartmentCode(mergeFrom.departmentCode);
		}
		if (Objects.nonNull(mergeFrom.departmentName) && !"".equalsIgnoreCase(mergeFrom.departmentName)) {
			this.setDepartmentName(mergeFrom.departmentName);
		}
	}
}
