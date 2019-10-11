package com.brt.device.rest.controller;

import com.brt.device.core.service.bussinessDevice.BusinessDeviceService;
import com.brt.device.entity.BusinessDevice;
import com.brt.device.entity.CameraDevice;
import com.brt.device.repository.BusinessDeviceRepository;
import com.brt.device.repository.CameraDeviceRepository;
import com.brt.device.rest.vo.ResEntity;
import com.brt.device.rest.vo.ViewBusinessDevice;
import com.brt.device.rest.vo.ViewCameraDevice;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class BusinessDeviceController {
    @Autowired
    BusinessDeviceService businessDeviceService;

    @Autowired
    BusinessDeviceRepository businessDeviceRepository;
    @Autowired
    CameraDeviceRepository cameraDeviceRepository;


    @RequestMapping(value = "/businessDevice/{id}", method = RequestMethod.DELETE)
    public ResEntity deleteBusinessDevice(@PathVariable("id") Long id) {
        if(id == null){
            return new ResEntity(null, false, "参数为空");
        }
        boolean resVo = businessDeviceService.deleteBusinessDevice(id);
        if (!resVo) {
            return new ResEntity(resVo, false, "删除业务设备失败");
        }
        return new ResEntity(resVo, true, "成功时该信息无效");
    }

    @RequestMapping(value = "/businessDevice", method = RequestMethod.POST)
    public ResEntity createBusinessDevice(@RequestBody ViewBusinessDevice viewBusinessDevice){
        if(viewBusinessDevice == null){
            return new ResEntity(null, false, "参数为空");
        }
        ViewBusinessDevice resVo = businessDeviceService.createBusinessDevice(viewBusinessDevice);
        if (resVo == null){
            return new ResEntity(null, false, "新增业务设备失败");
        }
        return new ResEntity(resVo, true, "成功时该信息无效");
    }

/*    @RequestMapping(value = "/businessDevice", method = RequestMethod.POST)
    public ResEntity createBusinessDevice(@RequestBody ViewBusinessDevice viewBusinessDevice){
        System.err.println(viewBusinessDevice);
        BusinessDevice businessDevice = new BusinessDevice();
        BeanUtils.copyProperties(viewBusinessDevice, businessDevice);
        BusinessDevice businessDeviceRes = businessDeviceRepository.save(businessDevice);

        Set<ViewCameraDevice> viewCameraDevices = viewBusinessDevice.getViewCameraDevices();

        for(ViewCameraDevice viewCameraDevice:viewCameraDevices){
            CameraDevice cameraDevice = new CameraDevice();
            System.err.println(viewCameraDevice);
            BeanUtils.copyProperties(viewCameraDevice,cameraDevice);
            System.err.println(cameraDevice);
            cameraDevice.setBusinessDevice(businessDeviceRes);
            cameraDeviceRepository.save(cameraDevice);
        }

        System.err.println(businessDeviceRes);
        ViewBusinessDevice viewBusinessDeviceRes = new ViewBusinessDevice();
        BeanUtils.copyProperties(businessDeviceRes,viewBusinessDevice);
        System.err.println(viewBusinessDeviceRes);
        return new ResEntity(businessDeviceRes, true, "成功时该信息无效");
    }*/

}
