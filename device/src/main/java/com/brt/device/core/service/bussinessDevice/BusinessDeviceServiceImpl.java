package com.brt.device.core.service.bussinessDevice;

import com.brt.device.entity.BusinessDevice;
import com.brt.device.entity.CameraDevice;
import com.brt.device.entity.LocationDevice;
import com.brt.device.entity.ReportDevice;
import com.brt.device.repository.BusinessDeviceRepository;
import com.brt.device.repository.CameraDeviceRepository;
import com.brt.device.repository.LocationDeviceRepository;
import com.brt.device.repository.ReportDeviceRepository;
import com.brt.device.rest.vo.ViewBusinessDevice;
import com.brt.device.rest.vo.ViewCameraDevice;
import com.brt.device.rest.vo.ViewLocationDevice;
import com.brt.device.rest.vo.ViewReportDevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class BusinessDeviceServiceImpl implements BusinessDeviceService {
    @Autowired
    BusinessDeviceRepository businessDeviceRepository;
    @Autowired
    LocationDeviceRepository locationDeviceRepository;
    @Autowired
    ReportDeviceRepository reportDeviceRepository;
    @Autowired
    CameraDeviceRepository cameraDeviceRepository;

    /**
     * 根据id删除业务设备及其关联设备
     * @param id 业务设备id
     * @return true：功能实现成功，false：功能实现失败。
     */
    @Override
    public boolean deleteBusinessDevice(Long id) {
        Optional<BusinessDevice> businessDeviceOpt= businessDeviceRepository.findById(id);
        if (!businessDeviceOpt.isPresent()){
            return false;
        }
        businessDeviceRepository.deleteById(id);
        Optional<BusinessDevice> businessDeviceRes= businessDeviceRepository.findById(id);
        if(!businessDeviceRes.isPresent()){
            return true;
        }
        return false;
    }

    /**
     * 新增业务设备及其关联设备
     * @param viewBusinessDevice 业务设备及其关联设备信息
     * @return 业务设备及其关联设备信息
     */
    @Override
    public ViewBusinessDevice createBusinessDevice(ViewBusinessDevice viewBusinessDevice) {
        BusinessDevice businessDevice = new BusinessDevice();
        BeanUtils.copyProperties(viewBusinessDevice, businessDevice);
        businessDevice.setCreateTime(new Date());
        if (businessDevice.getDeviceType().equals("0")){
            //该业务设备为纯业务设备
            businessDeviceRepository.save(businessDevice);
        }else if(businessDevice.getDeviceType().equals("1")){
            //该业务设备关联定位设备
            businessDeviceRepository.save(businessDevice);
            //定位设备持久化
            LocationDevice locationDevice = new LocationDevice();
            ViewLocationDevice viewlocationDevice = viewBusinessDevice.getViewlocationDevice();
            BeanUtils.copyProperties(viewlocationDevice, locationDevice);
            locationDevice.setBusinessDevice(businessDevice);
            locationDeviceRepository.save(locationDevice);
        }else if(businessDevice.getDeviceType().equals("2")){
            //该业务设备关联报警设备
            businessDeviceRepository.save(businessDevice);
            //报警设备持久化
            ReportDevice reportDevice = new ReportDevice();
            ViewReportDevice viewReportDevice = viewBusinessDevice.getViewReportDevice();
            BeanUtils.copyProperties(viewReportDevice, reportDevice);
            reportDevice.setBusinessDevice(businessDevice);
            reportDeviceRepository.save(reportDevice);
        }else if(businessDevice.getDeviceType().equals("3")){
            //该业务设备关联摄像头设备
            businessDeviceRepository.save(businessDevice);
            //摄像头设备持久化
            Set<ViewCameraDevice> viewCameraDeviceSet = viewBusinessDevice.getViewCameraDevices();
            for(ViewCameraDevice viewCameraDevice:viewCameraDeviceSet){
                CameraDevice cameraDevice = new CameraDevice();
                BeanUtils.copyProperties(viewCameraDevice, cameraDevice);
                cameraDevice.setBusinessDevice(businessDevice);
                cameraDeviceRepository.save(cameraDevice);
            }
        }
        viewBusinessDevice.setId(businessDevice.getId());
        return viewBusinessDevice;
    }
}
