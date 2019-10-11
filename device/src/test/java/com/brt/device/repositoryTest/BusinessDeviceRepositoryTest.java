package com.brt.device.repositoryTest;

import com.brt.device.entity.BusinessDevice;
import com.brt.device.entity.CameraDevice;
import com.brt.device.repository.BusinessDeviceRepository;
import com.brt.device.repository.CameraDeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessDeviceRepositoryTest {
    @Autowired
    BusinessDeviceRepository businessDeviceRepository;
    @Autowired
    CameraDeviceRepository cameraDeviceRepository;

    @Test
    public void gitTest(){
        System.err.println("3rd test for git");
    }

    @Test
    public void createBusinessDevice(){
        BusinessDevice businessDevice = new BusinessDevice();
        businessDevice.setCode("10000");
        businessDevice.setName("东京热式摄像机组");
        businessDevice.setDetail("什么都有！");
        businessDevice.setDeviceType("2");
        businessDevice.setCreateTime(new Date());
        businessDevice.setUpdateTime(new Date());

//        System.err.println(businessDevice);
        businessDeviceRepository.save(businessDevice);
        System.err.println(businessDevice);
    }

    @Test
    public void findBusinessDevice(){
        BusinessDevice businessDevice = new BusinessDevice();
        businessDevice = businessDeviceRepository.getOne(1L);
        System.err.println(businessDevice);

    }

    @Test
/*    @Transactional*/
    public void createCameraDevice(){
        CameraDevice cameraDevice = new CameraDevice();
        cameraDevice.setCode("10003");
        cameraDevice.setName("东热式摄像头1号");
        cameraDevice.setDetail("什么都有！");
        cameraDevice.setCreateTime(new Date());
        cameraDevice.setUpdateTime(new Date());

        BusinessDevice businessDevice = businessDeviceRepository.findById(1L).get();
        cameraDevice.setBusinessDevice(businessDevice);
        cameraDeviceRepository.save(cameraDevice);
        System.err.println(cameraDevice);
    }

    @Test
    public void optionalTest(){
        Optional<Integer> opt = Optional.of(1);
        System.err.println(opt.get());
    }
}
