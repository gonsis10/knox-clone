package com.simoonsong.knoxclone.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "devices")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String deviceId;
    @Column(nullable = false)
    private String deviceModel;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;
}