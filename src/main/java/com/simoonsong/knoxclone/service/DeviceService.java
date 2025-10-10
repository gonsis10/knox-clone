package com.simoonsong.knoxclone.service;

import com.simoonsong.knoxclone.entity.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findAllDevices();
    Device registerDevice(Device device);
    Device findDeviceById(Long id);
    void deleteDeviceById(Long id);
    Device findDeviceByDeviceId(String deviceId);
}
