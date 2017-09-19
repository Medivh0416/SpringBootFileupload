package net.antra.restdemo.service;

import net.antra.restdemo.Entity.UploadModel;
import net.antra.restdemo.dao.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadServiceImpl implements UploadService{

    @Autowired
    UploadRepository uploadRepository;
    @Override
    public void saveUploadModel(UploadModel uploadModel) {
        uploadRepository.save(uploadModel);
    }

    @Override
    public List<UploadModel> findAll() {
        return uploadRepository.findAll();
    }

    @Override
    public UploadModel findById(Integer id) {
        return uploadRepository.findOne(id);
    }
}
