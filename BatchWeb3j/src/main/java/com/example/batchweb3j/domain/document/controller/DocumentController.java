package com.example.batchweb3j.domain.document.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.batchweb3j.domain.document.model.BreedingDocumentRequest;
import com.example.batchweb3j.domain.s3.service.ImageUploadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/main/document")
@RequiredArgsConstructor
public class DocumentController {
	private final ImageUploadService imageUploadService;

	@PostMapping(value = "/register/breed", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> registerBreedingDocument(
		@RequestPart("data") BreedingDocumentRequest requestData,
		@RequestPart("locationSpecification") MultipartFile locationSpecification,
		@RequestPart("multiplicationMethod") MultipartFile multiplicationMethod,
		@RequestPart("shelterSpecification") MultipartFile shelterSpecification) {

		// S3에 이미지를 업로드
		try{
			imageUploadService.upload(locationSpecification, "test");
		}catch (Exception e){
			e.printStackTrace();
		}

		// 블록체인에 업로드 ( 미구현 )
		// try{
		//
		// }
		// catch(Exception e){
		// 	e.printStackTrace();
		// }

		// 응답
		return new ResponseEntity<>("Application with images received successfully!", HttpStatus.OK);
	}
}
