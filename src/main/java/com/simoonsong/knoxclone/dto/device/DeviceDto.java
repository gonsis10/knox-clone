package com.simoonsong.knoxclone.dto.device;

public record DeviceDto(
    Long id,
    String deviceId,
    String deviceModel,
    String status
) {}
