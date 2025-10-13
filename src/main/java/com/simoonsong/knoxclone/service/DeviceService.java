package com.simoonsong.knoxclone.service;

import com.simoonsong.knoxclone.dto.device.DeviceDto;
import com.simoonsong.knoxclone.dto.device.RegisterDeviceRequest;

import java.util.List;

public interface DeviceService {
    List<DeviceDto> findAllDevices();
    DeviceDto registerDevice(RegisterDeviceRequest device);
    DeviceDto findDeviceById(Long id);
    void deleteDeviceById(Long id);
    DeviceDto findDeviceByDeviceId(String deviceId);
}
