package com.brt.device.rest.controller;

import com.brt.device.entity.BusinessDevice;
import com.brt.device.entity.CameraDevice;
import com.brt.device.entity.LocationDevice;
import com.brt.device.repository.BusinessDeviceRepository;
import com.brt.device.repository.CameraDeviceRepository;
import com.brt.device.repository.LocationDeviceRepository;
import com.brt.device.rest.vo.ResEntity;
import com.brt.device.rest.vo.ViewBusinessDevice;
import com.brt.device.rest.vo.ViewLocationDevice;
import com.brt.device.rest.vo.ViewTotalDevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("Test")
public class BusinessDeviceControllerTest {
    @Autowired
    BusinessDeviceRepository businessDeviceRepository;
    @Autowired
    LocationDeviceRepository locationDeviceRepository;
    @Autowired
    CameraDeviceRepository cameraDeviceRepository;

    @GetMapping("/business/{id}")
    public BusinessDevice findById(@PathVariable("id") Long id){
        BusinessDevice businessDevice = businessDeviceRepository.getOne(id);
        return businessDevice;
    }

    @GetMapping("/businesses")
    public List<BusinessDevice> findAll(){
        List<BusinessDevice> list = businessDeviceRepository.findAll();
        return list;
    }

    @PostMapping("business")
    public BusinessDevice createBusinessDevice(@RequestBody BusinessDevice businessDevice){
        System.err.println(businessDevice);
        businessDevice.setId(null);
        BusinessDevice save = businessDeviceRepository.save(businessDevice);
        System.err.println(save.getId());
        return save;
    }

    @DeleteMapping("/business/{id}")
    public void delete(@PathVariable("id") Long id){
        System.err.println(businessDeviceRepository.getOne(id));
        businessDeviceRepository.deleteById(id);
        System.err.println("success!");
    }


    @PostMapping("businessPlus")
    public BusinessDevice createBusinessDevicePlus(@RequestBody BusinessDevice businessDevice){
        System.err.println(businessDevice);
        businessDevice.setId(null);
        //提出下级设备 待上级设备id生成后再保存
        Set<CameraDevice> set = businessDevice.getCameraDevices();
        businessDevice.setCameraDevices(null);
        BusinessDevice save = businessDeviceRepository.save(businessDevice);

        //保存下级设备
        for(CameraDevice cameraDevice:set){
            cameraDevice.setBusinessDevice(save);
           /* save.getCameraDevices().add(cameraDevice);*/
            cameraDeviceRepository.save(cameraDevice);
        }
        return save;
    }

    @GetMapping("/copy")
    public void copy(@RequestBody BusinessDevice businessDevice){
        System.err.println(businessDevice);
        Set<CameraDevice> list = businessDevice.getCameraDevices();
        for(CameraDevice cameraDevice:list){
            System.err.println(cameraDevice);
        }
    }

/*    @PostMapping("/businessDevice")
    public ResEntity createDevice(ViewBusinessDevice viewBusinessDevice){
        if(viewBusinessDevice == null){
            return new ResEntity(null, false, "参数为空");
        }

        return new ResEntity(resVo, true, "新增设备成功");
    }*/

/*    @PostMapping("/total")
    public void createDevice(ViewTotalDevice viewTotalDevice){
        ViewBusinessDevice viewBusinessDevice = viewTotalDevice.getViewBusinessDevice();
        ViewLocationDevice viewLocationDevice = viewTotalDevice.getViewLocationDevice();
        BusinessDevice businessDevice = new BusinessDevice();
        LocationDevice locationDevice = new LocationDevice();
        BeanUtils.copyProperties(viewBusinessDevice,businessDevice);
        BeanUtils.copyProperties(viewLocationDevice,locationDevice);
        System.err.println(businessDevice);
        System.err.println(locationDevice);
    }*/
}
