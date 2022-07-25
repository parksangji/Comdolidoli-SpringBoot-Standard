package com.comdolidoli.dev.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class ComdolidoliEntity {

    @Id
    private Integer cno;

    private String cname;

    private String loc;

    @Builder
    public ComdolidoliEntity(Integer cno, String cname, String loc){
        this.cno = cno;
        this.cname = cname;
        this.loc = loc;
    }
}
