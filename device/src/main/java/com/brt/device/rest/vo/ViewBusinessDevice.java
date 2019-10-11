package com.brt.device.rest.vo;

import java.util.Date;
import java.util.Set;

public class ViewBusinessDevice {
    private Long id;
    private String code;
    private String name;
    private String reserve;
    private String detail;
    private String deviceType;
    private Date createTime;
    private Date updateTime;
    private ViewLocationDevice viewlocationDevice;
    private ViewReportDevice viewReportDevice;
    private Set<ViewCameraDevice> viewCameraDevices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ViewLocationDevice getViewlocationDevice() {
        return viewlocationDevice;
    }

    public void setViewlocationDevice(ViewLocationDevice viewlocationDevice) {
        this.viewlocationDevice = viewlocationDevice;
    }

    public ViewReportDevice getViewReportDevice() {
        return viewReportDevice;
    }

    public void setViewReportDevice(ViewReportDevice viewReportDevice) {
        this.viewReportDevice = viewReportDevice;
    }

    public Set<ViewCameraDevice> getViewCameraDevices() {
        return viewCameraDevices;
    }

    public void setViewCameraDevices(Set<ViewCameraDevice> viewCameraDevices) {
        this.viewCameraDevices = viewCameraDevices;
    }

    @Override
    public String toString() {
        return "ViewBusinessDevice{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", reserve='" + reserve + '\'' +
                ", detail='" + detail + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", viewLocationDevice=" + viewlocationDevice +
                ", viewReportDevice=" + viewReportDevice +
                ", viewCameraDevices=" + viewCameraDevices +
                '}';
    }
}
