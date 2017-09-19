package net.antra.restdemo.controller;

import net.antra.restdemo.Entity.UploadModel;
import net.antra.restdemo.Exception.NullFileException;
import net.antra.restdemo.service.UploadService;
import net.antra.restdemo.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping(value = "/api/upload",produces = "application/json")
    public ResponseEntity upload(MultipartFile file,String desc) {
        try {
            UploadModel uploadModel=FileUploadUtils.saveFiles(file,desc);
            uploadService.saveUploadModel(uploadModel);
        } catch (NullFileException e) {
            e.printStackTrace();
            return new ResponseEntity("Fill is null",HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Something went wrong",HttpStatus.OK);
        }
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @GetMapping(value = "/api/findAll", produces = "application/json")
    public List<UploadModel> findAll(){
        return uploadService.findAll();
    }

    @GetMapping(value="/api/find/{id}",produces = "application/json")
    public UploadModel findById(@PathVariable("id") Integer id){
        return uploadService.findById(id);
    }
}
