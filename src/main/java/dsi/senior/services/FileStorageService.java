package dsi.senior.services;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import dsi.senior.entities.FileDB;
import dsi.senior.repositories.FileDBDao;

@Service
public class FileStorageService {

	
	@Autowired
	  private FileDBDao fileDBRepository;
	
	  public FileDB store(MultipartFile file) throws Exception {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                + fileName);
            }
	    
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    return fileDBRepository.save(FileDB);
	    } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
       }
	    
	    }
	  
	  
	  
	  
	  public FileDB getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	  
	  public Stream<FileDB> getAllFiles() {
		  Spliterator<FileDB> spliterator = fileDBRepository.findAll().spliterator();
		  return StreamSupport.stream(spliterator, false);
	  }
	  
	  public void deleteFile(String id) {
		   fileDBRepository.deleteById(id);
	  }
}