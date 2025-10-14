package com.simoonsong.knoxclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simoonsong.knoxclone.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// jpa interface that auto generates sql queries for device entity
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByDeviceId(String deviceId);
}