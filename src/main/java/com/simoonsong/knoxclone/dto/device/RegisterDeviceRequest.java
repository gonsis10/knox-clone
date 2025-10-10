package com.simoonsong.knoxclone.dto.device;

public record RegisterDeviceRequest(
    String deviceId,
    String deviceModel
) {}
