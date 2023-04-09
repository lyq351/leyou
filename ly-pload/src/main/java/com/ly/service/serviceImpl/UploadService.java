package com.ly.service.serviceImpl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.ly.service.IUploadService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService implements IUploadService {
    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif" , "image/png");

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Autowired
    private FastFileStorageClient storageClient;


    @Override
    public String upload(MultipartFile file) {
        LOGGER.info("入参：{}",file.getName());
        //1. 校验文件大小
        //2. 校验文件的媒体类型
        //3. 校验文件的内容
        long size = file.getSize(); //文件大小
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        if (!CONTENT_TYPES.contains(contentType)) {
            LOGGER.info("文件类型不符合：{}",originalFilename);
            return null;
        }

        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                LOGGER.info("文件内容不合法：{}",originalFilename);
            }
            //file.transferTo(new File("E:\\qly\\images\\" + originalFilename));
            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
            //return "http://image.ly.com/" + originalFilename;
            return "http://image.ly.com/" + storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
