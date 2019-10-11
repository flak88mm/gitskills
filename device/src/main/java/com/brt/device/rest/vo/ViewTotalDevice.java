package com.brt.device.rest.vo;

public class ViewTotalDevice {
    private ViewBusinessDevice viewBusinessDevice;
    private ViewCameraDevice viewCameraDevice;
    private ViewLocationDevice viewLocationDevice;
    private ViewReportDevice viewReportDevice;

    public ViewBusinessDevice getViewBusinessDevice() {
        return viewBusinessDevice;
    }

    public void setViewBusinessDevice(ViewBusinessDevice viewBusinessDevice) {
        this.viewBusinessDevice = viewBusinessDevice;
    }

    public ViewCameraDevice getViewCameraDevice() {
        return viewCameraDevice;
    }

    public void setViewCameraDevice(ViewCameraDevice viewCameraDevice) {
        this.viewCameraDevice = viewCameraDevice;
    }

    public ViewLocationDevice getViewLocationDevice() {
        return viewLocationDevice;
    }

    public void setViewLocationDevice(ViewLocationDevice viewLocationDevice) {
        this.viewLocationDevice = viewLocationDevice;
    }

    public ViewReportDevice getViewReportDevice() {
        return viewReportDevice;
    }

    public void setViewReportDevice(ViewReportDevice viewReportDevice) {
        this.viewReportDevice = viewReportDevice;
    }
}
