package net.antra.restdemo.utils;

import net.antra.restdemo.Entity.UploadModel;
import net.antra.restdemo.Exception.NullFileException;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadUtils {
    private final static String PATH_FODER = "src/main/resources/files/";

    public static UploadModel saveFiles(MultipartFile file, String desc) throws IOException {
        if(file.isEmpty()){
            throw new NullFileException("File is null");
        }
        Logger log = LogUtiles.getLog();
        byte[] bytes = file.getBytes();
        Path path = Paths.get(PATH_FODER);

        if (!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            log.debug("Created Directorories");
            Files.createDirectories(path);
        }
        String type = "." + file.getContentType().split("/")[1];
        path = Paths.get(PATH_FODER + file.hashCode() + type);
        System.out.println(path);
        Files.write(path, bytes);
        log.debug(path+"FileUploaded");
        UploadModel uploadModel = new UploadModel(file.getOriginalFilename(), file.getSize(), path.toString(), desc);
        return uploadModel;
    }
}
