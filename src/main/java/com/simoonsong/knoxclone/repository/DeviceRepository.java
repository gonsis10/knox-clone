package com.simoonsong.knoxclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simoonsong.knoxclone.entity.Device;
import org.springframework.stereotype.Repository;

// jpa interface that auto generates sql queries for device entity
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByDeviceId(String deviceId);
}