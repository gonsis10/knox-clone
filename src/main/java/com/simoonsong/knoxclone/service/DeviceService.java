package com.simoonsong.knoxclone.service;

import com.simoonsong.knoxclone.dto.device.DeviceResponse;
import com.simoonsong.knoxclone.dto.device.DeviceStatsResponse;
import com.simoonsong.knoxclone.dto.device.RegisterDeviceRequest;
import com.simoonsong.knoxclone.entity.Device;
import com.simoonsong.knoxclone.entity.DeviceStatus;
import com.simoonsong.knoxclone.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public List<DeviceResponse> findAllDevices() {
        return deviceRepository.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    public DeviceResponse registerDevice(RegisterDeviceRequest request) {
        Device device = Device.builder()
                .deviceId(request.getDeviceId())
                .deviceModel(request.getDeviceModel())
                .status(DeviceStatus.INACTIVE)
                .build();

        Device savedDevice = deviceRepository.save(device);
        return convertToResponse(savedDevice);
    }

    public DeviceResponse findDeviceById(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found with id: " + id));
        return convertToResponse(device);
    }

    public void deleteDeviceById(Long id) {
        deviceRepository.deleteById(id);
    }

    public DeviceResponse findDeviceByDeviceId(String deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId).orElseThrow();
        return convertToResponse(device);
    }

    public DeviceStatsResponse getDeviceStats() {
        List<Device> allDevices = deviceRepository.findAll();

        int retailDevices = (int) allDevices.stream()
                .filter(device -> DeviceStatus.RETAIL.equals(device.getStatus()))
                .count();

        int scannerDevices = (int) allDevices.stream()
                .filter(device -> DeviceStatus.SCANNER.equals(device.getStatus()))
                .count();

        int inactiveDevices = (int) allDevices.stream()
                .filter(device -> DeviceStatus.INACTIVE.equals(device.getStatus()))
                .count();

        return DeviceStatsResponse.builder()
                .retailDevices(retailDevices)
                .scannerDevices(scannerDevices)
                .inactiveDevices(inactiveDevices)
                .totalDevices(allDevices.size())
                .build();
    }

    private DeviceResponse convertToResponse(Device device) {
        return DeviceResponse.builder()
                .id(device.getId())
                .deviceId(device.getDeviceId())
                .deviceModel(device.getDeviceModel())
                .status(device.getStatus())
                .build();
    }
}