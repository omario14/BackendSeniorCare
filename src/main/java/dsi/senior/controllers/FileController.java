package dsi.senior.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsi.senior.entities.FileDB;
import dsi.senior.message.ResponseFile;
import dsi.senior.services.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin("http://localhost:8081")
public class FileController {
  @Autowired
  private FileStorageService storageService;
  
  @PostMapping("/upload")
  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  public ResponseFile uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
	  FileDB attachment = null;
      String downloadURl = "";
   
    	attachment = storageService.store(file);
    	downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();
      return new ResponseFile(attachment.getId(),
    		  attachment.getName(),
              downloadURl,
              file.getContentType(),
              file.getSize());
    
  }
  @GetMapping("/files")

  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();
      return new ResponseFile(
    		  dbFile.getId(),
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(files);
  }
  @GetMapping("/files/{id}")
  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  
  @DeleteMapping("/deletefile/{id}")
  public void removeFile(@PathVariable String id) {
	  storageService.deleteFile(id);
  }
}