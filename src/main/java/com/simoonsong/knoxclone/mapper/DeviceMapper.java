package com.simoonsong.knoxclone.mapper;

import com.simoonsong.knoxclone.dto.device.DeviceDto;
import com.simoonsong.knoxclone.dto.device.RegisterDeviceRequest;
import com.simoonsong.knoxclone.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "ACTIVE")
    Device toEntity(RegisterDeviceRequest dto);

    DeviceDto toDto(Device device);
}
