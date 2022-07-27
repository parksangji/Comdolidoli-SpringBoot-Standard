package com.comdolidoli.dev.dto;

import com.comdolidoli.dev.core.dto.BaseDto;
import com.comdolidoli.dev.entity.ComdolidoliEntity;
import lombok.*;

@Getter
@Setter
@ToString
public class ResponseComdoliDto extends BaseDto {
    private Integer cno;
    private String cname;
    private String loc;

    @Builder
    public ResponseComdoliDto(ComdolidoliEntity comdolidoliEntity) {
        this.cno = comdolidoliEntity.getCno();
        this.cname = comdolidoliEntity.getCname();
        this.loc = comdolidoliEntity.getLoc();
    }
}
