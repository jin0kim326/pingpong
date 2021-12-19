package com.douzone.pingpong.controller.api;

import com.douzone.pingpong.controller.api.dto.file.UploadFileResponse;
import com.douzone.pingpong.domain.file.UploadFile;
import com.douzone.pingpong.util.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class ApiFileController {
    private final FileStore fileStore;

    @PostMapping("/upload")
    public UploadFileResponse upload(
            @RequestParam(value = "file") MultipartFile file
    ) throws IOException {

        UploadFile uploadFile = fileStore.storeFile(file);

        return new UploadFileResponse(uploadFile);
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws
            IOException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }


//
//    @GetMapping("/api/download/{filename}")
//    public ResponseEntity<Object> download(@PathVariable("filename") String filename) {
//        System.out.println("파일 다운로드");
//        String path = "C:"+filename;
//
//        try {
//            Path filePath = Paths.get(path);
//            Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
//
//            File file = new File(path);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
//
//            return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
//        } catch(Exception e) {
//            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
//        }
//    }
}
