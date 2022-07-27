package com.comdolidoli.dev.dto;


import com.comdolidoli.dev.core.dto.BaseDto;
import com.comdolidoli.dev.entity.ComdolidoliEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestComdoliDto extends BaseDto {

    private Integer cno;
    private String cname;
    private String loc;

    @Builder
    public RequestComdoliDto(Integer cno,String cname, String loc){
        this.cname = cname;
        this.cno = cno;
        this.loc = loc;
    }

    public ComdolidoliEntity toEntity(){
        return ComdolidoliEntity.builder().cno(cno).cname(cname).loc(loc).build();
    }
}
