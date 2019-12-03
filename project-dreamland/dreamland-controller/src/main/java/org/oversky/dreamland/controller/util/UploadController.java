package org.oversky.dreamland.controller.util;

import java.io.File;
import java.io.IOException;

import org.oversky.base.service.BaseResDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	
	@PostMapping("/upload")
    @ResponseBody
    public BaseResDto upload(@RequestParam("file") MultipartFile upFile) {
		BaseResDto res = new BaseResDto();
        if (upFile.isEmpty()) {
        	res.failure("上传失败，请选择文件");
            return res;
        }

        String oldName = upFile.getOriginalFilename();
        File serverDest = new File("/home/fms/");
        log.info("-----------存放上传文件的文件夹【"+ serverDest +"】-----------");
        try {
        	if(!serverDest.isDirectory()) {
        		serverDest.mkdirs();
        	}
        	File saveFile = new File(serverDest.getAbsolutePath() + File.separator + oldName);
        	upFile.transferTo(saveFile);
    		res.success("上传成功");
            log.info("上传成功");
        } catch (IOException e) {
        	log.error(e.toString(), e);
        	res.failure(e.getMessage());
        }
        return res;
    }

}
