package com.epam.training.inner.service;

import com.epam.training.inner.model.Setting;

public interface ISettingService {
    void updateSetting(Setting setting);

    void saveSetting(Setting setting);
}
