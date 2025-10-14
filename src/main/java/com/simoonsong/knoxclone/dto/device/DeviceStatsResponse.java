package com.simoonsong.knoxclone.dto.device;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceStatsResponse {
    private Integer activeDevices;
    private Integer inactiveDevices;
    private Integer lockedDevices;
    private Integer totalDevices;
}