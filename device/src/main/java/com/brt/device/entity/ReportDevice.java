package com.brt.device.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Table(name = "T_REPORT_DEVICE")
public class ReportDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private String name;
    private String reserve;
    private String detail;
    private Date createTime;
    private Date updateTime;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "BUSINESS_DEVICE_ID"/*,nullable = true*/)
    private BusinessDevice businessDevice;

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

    public BusinessDevice getBusinessDevice() {
        return businessDevice;
    }

    public void setBusinessDevice(BusinessDevice businessDevice) {
        this.businessDevice = businessDevice;
    }

    @Override
    public String toString() {
        return "ReportDevice{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", reserve='" + reserve + '\'' +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                /*", businessDevice=" + businessDevice +*/
                '}';
    }
}
