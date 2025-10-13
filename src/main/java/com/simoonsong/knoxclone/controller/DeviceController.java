package com.simoonsong.knoxclone.controller;

import com.simoonsong.knoxclone.dto.device.DeviceDto;
import com.simoonsong.knoxclone.dto.device.RegisterDeviceRequest;
import com.simoonsong.knoxclone.mapper.DeviceMapper;
import com.simoonsong.knoxclone.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.simoonsong.knoxclone.entity.Device;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<DeviceDto> getAllDevices() {
        return deviceService.findAllDevices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceDto registerDevice(@RequestBody RegisterDeviceRequest request) {
        return deviceService.registerDevice(request);
    }

    @GetMapping("/{id}")
    public DeviceDto getDeviceById(@PathVariable Long id) {
        return deviceService.findDeviceById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeviceById(@PathVariable Long id) {
        deviceService.deleteDeviceById(id);
    }

    @GetMapping("/deviceId/{deviceId}")
    public DeviceDto getDeviceByDeviceId(@PathVariable String deviceId) {
        return deviceService.findDeviceByDeviceId(deviceId);
    }
}
