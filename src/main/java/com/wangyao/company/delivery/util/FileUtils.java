package com.wangyao.company.delivery.util;

import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.vo.ImageVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author wy
 * @date 2019/9/24 0024
 * @description:
 */
@Slf4j
@Component
public class FileUtils {

    @Value("${image.path}")
    private String imageDiskPath;
    @Value("${image.type}")
    private String imageTypeStr;
    @Value("${image.size}")
    private long fileSize;
    @Value("${image.scaleRatio}")
    private double scaleRatio;

    public ImageVO upload(MultipartFile file) throws Exception{

        ImageVO imageVO = new ImageVO();
        String[] imageTypes = imageTypeStr.split(",");
        String path = null;
        boolean flag = false;
        for (String type : imageTypes) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                flag = true;
                break;
            }
        }

        if(flag) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            // 获得文件类型
            String fileType = file.getContentType();
            // 获得文件后缀名称
            String imageName = fileType.substring(fileType.indexOf("/") + 1);
            // 年月日文件夹
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String basedir = sdf.format(new Date());

            String parentPath = imageDiskPath + "/" + basedir;
            File parentFile = new File(parentPath);
            if (!parentFile.exists()) {
                if (!parentFile.mkdirs()) {
                    log.error("创建文件夹失败");
                    throw new BusinessException("创建文件夹失败");
                }
            }

            if (file.getSize() > fileSize) {
                // 重新生成
                String newUUID = UUID.randomUUID().toString().replaceAll("-", "");
                String returnPath = basedir + "/" + newUUID + "." + imageName;
                path = imageDiskPath + "/" + returnPath;
                // 如果目录不存在则创建目录
                File oldFile = new File(path);
                file.transferTo(oldFile);
                // 压缩图片
                Thumbnails.of(oldFile).scale(scaleRatio).toFile(path);
                // 显示路径
                imageVO.setImage(returnPath);
            } else {
                String returnPath = basedir + "/" + uuid + "." + imageName;
                path = imageDiskPath + "/" + returnPath;
                // 如果目录不存在则创建目录
                File uploadFile = new File(path);
                file.transferTo(uploadFile);
                // 显示路径
                imageVO.setImage(returnPath);
            }
        } else {
            throw new BusinessException("图片格式不正确,支持png|jpg|jpeg");
        }

        return imageVO;
    }
}
