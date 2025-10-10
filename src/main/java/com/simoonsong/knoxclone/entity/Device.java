package com.simoonsong.knoxclone.entity;

import jakarta.persistence.*;

@Entity
public class Device {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceId;
    private String deviceModel;
    @Enumerated(EnumType.STRING)
    private DeviceStatus status;
}
