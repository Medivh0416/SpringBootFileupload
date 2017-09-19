package net.antra.restdemo.service;

import net.antra.restdemo.Entity.UploadModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UploadService {
    void saveUploadModel(UploadModel uploadModel);

    List<UploadModel> findAll();

    UploadModel findById(Integer id);
}
