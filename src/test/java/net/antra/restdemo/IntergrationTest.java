package net.antra.restdemo;

import net.antra.restdemo.Entity.UploadModel;
import net.antra.restdemo.dao.UploadRepository;
import net.antra.restdemo.service.UploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntergrationTest {

    @Autowired
    UploadRepository uploadRepository;

    @Autowired
    UploadService uploadService;

    @Test
    public void testSaveandLoad(){
        uploadService.saveUploadModel(new UploadModel());
        assertEquals(1,uploadService.findAll());
    }
}
