package com.simoonsong.knoxclone.controller;

import com.simoonsong.knoxclone.dto.device.DeviceResponse;
import com.simoonsong.knoxclone.dto.device.DeviceStatsResponse;
import com.simoonsong.knoxclone.dto.device.RegisterDeviceRequest;
import com.simoonsong.knoxclone.entity.DeviceStatus;
import com.simoonsong.knoxclone.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<DeviceResponse>> getAllDevices() {
        return ResponseEntity.ok(deviceService.findAllDevices());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DeviceResponse> registerDevice(@RequestBody RegisterDeviceRequest request) {
        return ResponseEntity.ok(deviceService.registerDevice(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponse> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.findDeviceById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteDeviceById(@PathVariable Long id) {
        deviceService.deleteDeviceById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/deviceId/{deviceId}")
    public ResponseEntity<DeviceResponse> getDeviceByDeviceId(@PathVariable String deviceId) {
        return ResponseEntity.ok(deviceService.findDeviceByDeviceId(deviceId));
    }

    @GetMapping("/stats")
    public ResponseEntity<DeviceStatsResponse> getDeviceStats() {
        return ResponseEntity.ok(deviceService.getDeviceStats());
    }

    @PatchMapping("/{id}/retail")
    public ResponseEntity<DeviceResponse> setRetail(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.updateDeviceStatus(id, DeviceStatus.RETAIL));
    }

    @PatchMapping("/{id}/scanner")
    public ResponseEntity<DeviceResponse> setScanner(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.updateDeviceStatus(id, DeviceStatus.SCANNER));
    }

    @PatchMapping("/{id}/inactive")
    public ResponseEntity<DeviceResponse> setInactive(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.updateDeviceStatus(id, DeviceStatus.INACTIVE));
    }
}