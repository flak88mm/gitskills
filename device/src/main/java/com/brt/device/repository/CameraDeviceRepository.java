package com.brt.device.repository;

import com.brt.device.entity.CameraDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraDeviceRepository extends JpaRepository<CameraDevice,Long> {
}
