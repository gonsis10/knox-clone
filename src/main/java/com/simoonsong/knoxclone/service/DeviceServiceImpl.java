package com.simoonsong.knoxclone.service;

import com.simoonsong.knoxclone.entity.Device;
import com.simoonsong.knoxclone.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device registerDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device findDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDeviceById(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public Device findDeviceByDeviceId(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId);
    }
}