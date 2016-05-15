package com.amazingfour.crms.service.impl;

import com.amazingfour.crms.dao.BaseDao;
import com.amazingfour.crms.dao.CloudFileDao;
import com.amazingfour.crms.domain.CloudFile;
import com.amazingfour.crms.domain.UserFile;
import com.amazingfour.crms.service.CloudFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Huy on 2016-01-08.
 */
@Service("cloudFileService")
public class CloudFileServiceImpl extends AbstractService<CloudFile, Long> implements CloudFileService {
    @Resource
    private CloudFileDao cloudFileDao;

    @Resource
    public void setCloudFileDao(CloudFileDao cloudFileDao) {
        this.cloudFileDao = cloudFileDao;
        super.setBaseDao(this.cloudFileDao);
    }

    //批量删除文件
    public int deleteBatch(List<String> fileUrls) {
        return cloudFileDao.deleteBatch(fileUrls);
        /*if(rows==fileUrls.size()){
            return true;
        }else{
            return false;
        }*/
    }

    public CloudFile findByBussinessKey(String bussinessKey) {
        return cloudFileDao.findByBussinessKey(bussinessKey);
    }

    public void insertUF(UserFile userFile) {
        cloudFileDao.insertUF(userFile);
    }

    public List<CloudFile> findByUserId(Map<String, Object> map) {
        return cloudFileDao.findByUserId(map);
    }

    public int countById(Map<String, Object> map) {
        return cloudFileDao.countById(map);
    }
}

