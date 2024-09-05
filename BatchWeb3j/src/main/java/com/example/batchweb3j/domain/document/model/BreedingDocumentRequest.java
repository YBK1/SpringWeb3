package com.example.batchweb3j.domain.document.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BreedingDocumentRequest {
	private String docType;
	private UUID applicant;
	private Detail detail;

	@Builder
	@Getter
	public static class Detail {
		String scientificName;
		String area;
		int count;
		String purpose;
		LocalDate registerDate;
		UUID motherUUID;
		UUID fatherUUID;
	}
}

