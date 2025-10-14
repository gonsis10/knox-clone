package com.simoonsong.knoxclone.dto.device;

import com.simoonsong.knoxclone.entity.DeviceStatus;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {
    private Long id;
    private String deviceId;
    private String deviceModel;
    private DeviceStatus status;
}
