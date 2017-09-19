package net.antra.restdemo;

import net.antra.restdemo.Entity.UploadModel;
import net.antra.restdemo.Exception.NullFileException;
import net.antra.restdemo.controller.UploadController;
import net.antra.restdemo.dao.UploadRepository;
import net.antra.restdemo.service.UploadServiceImpl;
import net.antra.restdemo.utils.FileUploadUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoUnitTests {

	@Mock
	private UploadRepository uploadRepository;
	@InjectMocks
	private UploadServiceImpl uploadService;

	private UploadModel uploadModel;

	@Before
	public void setupMock(){
		MockitoAnnotations.initMocks(this);
		uploadModel=new UploadModel();
		uploadModel.setFileId(1);
	}

	@Test(expected = NullFileException.class)
	public void testFile() throws IOException {
		MockMultipartFile mf=new MockMultipartFile("test",new byte[0]);
		FileUploadUtils.saveFiles(mf,"test");
	}

	@Test
	public void testGetAllFile(){
		UploadModel[] mocklist=new UploadModel[]{new UploadModel(),new UploadModel()};
		Mockito.when(uploadRepository.findAll()).thenReturn(Arrays.asList(mocklist));
		assertEquals(2,uploadService.findAll());
	}

	public void testGetFileById(){
		Mockito.when(uploadRepository.findOne(1)).thenReturn(uploadModel);
		assertEquals(uploadModel.getFileId(),uploadService.findById(1));
	}

}
