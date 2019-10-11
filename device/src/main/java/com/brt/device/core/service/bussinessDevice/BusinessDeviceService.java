package com.brt.device.core.service.bussinessDevice;

import com.brt.device.rest.vo.ViewBusinessDevice;

public interface BusinessDeviceService {
    boolean deleteBusinessDevice(Long id);

    ViewBusinessDevice createBusinessDevice(ViewBusinessDevice viewBusinessDevice);
}
