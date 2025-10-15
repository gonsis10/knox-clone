package com.simoonsong.knoxclone.dto.device;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceStatsResponse {
    private Integer retailDevices;
    private Integer scannerDevices;
    private Integer inactiveDevices;
    private Integer totalDevices;
}