package com.simoonsong.knoxclone.service;

import com.simoonsong.knoxclone.dto.device.DeviceDto;
import com.simoonsong.knoxclone.dto.device.RegisterDeviceRequest;
import com.simoonsong.knoxclone.mapper.DeviceMapper;
import com.simoonsong.knoxclone.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<DeviceDto> findAllDevices() {
        return deviceRepository.findAll().stream().map(deviceMapper::toDto).toList();
    }

    @Override
    public DeviceDto registerDevice(RegisterDeviceRequest device) {
        return deviceMapper.toDto(deviceRepository.save(deviceMapper.toEntity(device)));
    }

    @Override
    public DeviceDto findDeviceById(Long id) {
        return deviceMapper.toDto(deviceRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteDeviceById(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public DeviceDto findDeviceByDeviceId(String deviceId) {
        return deviceMapper.toDto(deviceRepository.findByDeviceId(deviceId));
    }
}