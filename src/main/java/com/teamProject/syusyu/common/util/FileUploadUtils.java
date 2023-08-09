package com.teamProject.syusyu.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
public class FileUploadUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtils.class);

    @Value("${file.upload-dir}")
    private String uploadDir;

    /**
     * 이 메서드는 클라이언트로부터 받은 이미지 파일을 서버에 저장하는 작업을 수행합니다.
     * 저장된 파일의 상대 경로를 반환하며, 파일 저장 중에 발생하는 I/O 예외를 처리합니다.
     *
     * @param file 저장될 이미지 파일
     * @return 저장된 파일의 상대 경로
     * @throws IOException 파일 저장 중 발생하는 I/O 예외
     * @author soso
     * @since 2023/07/29
     */
    public String saveFileAndGetUri(MultipartFile file) throws IOException {
//        LOGGER.info("saveFileAndGetUri is called with file: " + file.getOriginalFilename());

        // 업로드된 파일의 원래 이름을 가져옵니다.
        String originalFilename = file.getOriginalFilename();

        // 원래 파일 이름에서 확장자를 추출하고 허용되지 않는 확장자를 가진 파일의 업로드를 막기
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if (!Arrays.asList(allowedExtensions).contains(extension.toLowerCase())) {
            LOGGER.error("허용되지 않는 파일 확장자: " + extension);
            throw new IOException("허용되지 않는 파일 확장자: " + extension);
        }

        File storagePath = new File(uploadDir);

        // directory가 실제로 존재하지 않는 경우 해당경로에 디렉토리를 생성.
        if (!storagePath.exists()) {
            boolean result = storagePath.mkdirs();
            if (result) {
                System.out.println("Directories were created successfully");
            } else {
                System.out.println("Failed to create directories");
            }
        }

        // 파일 이름에 현재 시간을 추가하여 파일 이름이 중복되지 않도록 합니다.
        String filename = originalFilename.substring(0, originalFilename.lastIndexOf("."))
                + "_" + System.currentTimeMillis() + extension;

        // 파일을 저장합니다.
        Path filePath = Paths.get(storagePath.getAbsolutePath(), filename);
        file.transferTo(filePath.toFile());

        // 현재 작업 디렉토리를 로그로 출력합니다.
        String currentDir = System.getProperty("user.dir");
        LOGGER.info("현재 작업 디렉토리: " + currentDir);

        // 저장된 파일의 상대 경로를 반환합니다.
        return "/static/image/product/" + filename;
    }

}
