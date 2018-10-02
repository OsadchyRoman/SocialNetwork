package com.epam.training.inner.service;

import com.epam.training.inner.dao.SettingDao;
import com.epam.training.inner.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements ISettingService {

    @Autowired
    private SettingDao settingDao;


    @Override
    public void updateSetting(Setting setting) {
        settingDao.update(setting.getId(), setting.getVisionForAnonymous(), setting.getVisionForNonFriend(),
                setting.getVisionFriends(), setting.getVisionPresents(), setting.getVisionGroups(), setting.getVisionSex(),
                setting.getVisionAge(), setting.getVisionCountryCity());
    }

    @Override
    public void saveSetting(Setting setting) {
        settingDao.save(setting);
    }
}
