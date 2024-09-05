package com.example.batchweb3j.domain.s3.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:s3.properties")
public class ImageUploadService {
	private final AmazonS3 amazonS3;

	// application.properties 파일에서 받아 온 S3 버킷 이름
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	// MultipartFile을 받아 S3에 업로드하는 메서드
	public String upload(MultipartFile multipartFile, String dirName) throws IOException {
		// MultipartFile을 File 객체로 변환
		File uploadFile = convert(multipartFile)
			.orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File 변환 실패"));
		// 변환된 파일을 S3에 업로드하고 URL을 반환
		return upload(uploadFile, dirName);
	}

	// File 객체를 S3에 업로드하고 URL을 반환하는 메서드
	private String upload(File uploadFile, String dirName) {
		// 업로드할 파일의 경로 설정
		String fileName = dirName + "/" + uploadFile.getName();
		// S3에 파일 업로드
		String uploadImageUrl = putS3(uploadFile, fileName);
		// 로컬 서버에서 임시 파일 삭제
		removeNewFile(uploadFile);
		// 업로드된 파일의 URL 반환
		return uploadImageUrl;
	}

	// 로컬 서버에서 임시 파일을 삭제하는 메서드
	private void removeNewFile(File uploadFile) {
		uploadFile.delete();
	}

	// 파일을 S3에 업로드하고 URL을 반환하는 메서드
	private String putS3(File uploadFile, String fileName) {
		// S3에 파일 업로드 요청
		amazonS3.putObject(new PutObjectRequest(bucket, fileName, uploadFile)
			.withCannedAcl(CannedAccessControlList.PublicRead));
		// 업로드된 파일의 URL 반환
		return amazonS3.getUrl(bucket, fileName).toString();
	}

	// MultipartFile을 File 객체로 변환하는 메서드
	private Optional<File> convert(MultipartFile file) throws IOException {
		// 원본 파일 이름 가져옴
		String originalFilename = file.getOriginalFilename();
		// UUID 생성
		String uuid = UUID.randomUUID().toString();
		// UUID와 원본 파일 이름을 조합하여 고유한 파일 이름 생성 -> 공백은 _로 변환
		String uuidFileName = uuid + "_" + originalFilename.replaceAll("\\s", "_");

		// 변환 할 파일 객체 생성
		File convertFile = new File(uuidFileName);
		// 새로운 파일 생성 시도
		if (convertFile.createNewFile()) {
			try (FileOutputStream fos = new FileOutputStream(convertFile)) {
				fos.write(file.getBytes());
			}
			return Optional.of(convertFile);
		}
		return Optional.empty();
	}
}
