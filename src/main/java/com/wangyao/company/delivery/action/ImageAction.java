package com.wangyao.company.delivery.action;

import com.wangyao.company.delivery.exception.BusinessException;
import com.wangyao.company.delivery.util.FileUtils;
import com.wangyao.company.delivery.vo.ImageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author wy
 * @date 2019/9/24 0024
 * @description:
 */
@RestController
@RequestMapping("/web/image")
@Api(value = "ImageAction", description = "图片服务")
public class ImageAction {

    @Resource
    private FileUtils fileUtils;

    /**
     * 上传图片
     *
     * @param file 图片的base64字符串
     * @return 图片http地址
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ApiOperation(value = "uploadImage", notes = "上传图片")
    ImageVO uploadImage(@ApiParam(required = true, name = "file", value = "file") @RequestParam("file") MultipartFile file) throws Exception {
        ImageVO imageVO;
        try {
            imageVO = fileUtils.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("图片上传失败");
        }


        return imageVO;
    }
}
