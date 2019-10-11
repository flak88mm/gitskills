package com.brt.device.rest.vo;

import java.util.Date;

public class ViewLocationDevice {
    private Long id;
    private Long code;
    private String name;
    private String reserve;
    private String detail;
    private Date createTime;
    private Date updateTime;
    private Long businessDeviceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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

    public Long getBusinessDeviceId() {
        return businessDeviceId;
    }

    public void setBusinessDeviceId(Long businessDeviceId) {
        this.businessDeviceId = businessDeviceId;
    }

    @Override
    public String toString() {
        return "ViewCameraDevice{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", reserve='" + reserve + '\'' +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", businessDeviceId=" + businessDeviceId +
                '}';
    }
}
