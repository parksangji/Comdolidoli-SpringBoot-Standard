package com.comdolidoli.dev.service.impl;
import org.assertj.core.api.Assertions;

import com.comdolidoli.dev.dto.ResponseComdoliDto;
import com.comdolidoli.dev.entity.ComdolidoliEntity;
import com.comdolidoli.dev.repository.ComdolidoliRepository;
import com.comdolidoli.dev.service.ComdolidoliService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ActiveProfiles({"dev","db-h2"}) // dev 와 db-h2 property를 받을 수 있음
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComdolidoliServiceImplTest {

    @Autowired
    ComdolidoliService comdolidoliService;

    @Autowired
    ComdolidoliRepository comdolidoliRepository;

    @Test
    @Order(1)
    @Commit
    @Transactional
    public void 서비스_입력() throws Exception{
        List<ComdolidoliEntity> cList = new ArrayList<>();
        cList.add(ComdolidoliEntity.builder().cno(10).cname("ACCOUNTING").loc("SEOUL").build());
        cList.add(ComdolidoliEntity.builder().cno(20).cname("RESEARCH").loc("DALLAS").build());
        cList.add(ComdolidoliEntity.builder().cno(30).cname("SALES").loc("CHICAGO").build());
        cList.add(ComdolidoliEntity.builder().cno(40).cname("OPERATIONS").loc("BUSAN").build());

        for(ComdolidoliEntity comdolidoliEntity : cList){
            comdolidoliService.ComdoldolInsert(comdolidoliEntity);
        }
        for(ComdolidoliEntity comdolidoliEntity : cList){
            Integer cno = comdolidoliEntity.getCno();
            ResponseComdoliDto responseComdoliDto = comdolidoliService.ComdolidoliDetail(cno);
            Assertions.assertThat(responseComdoliDto.getCno()).isEqualTo(cno);
        }
    }

    @Test
    @Order(2)
    @Commit
    @Transactional
    public void 서비스_수정() throws Exception {
        String updataCname = "Computer Scientist";
        comdolidoliService.ComdolidoliUpdate(ComdolidoliEntity.builder().cno(10).cname(updataCname).loc("SEOUL").build());
        ResponseComdoliDto responseComdoliDto = comdolidoliService.ComdolidoliDetail(10);
        log.debug(responseComdoliDto.getCname().toString());
        Assertions.assertThat(responseComdoliDto.getCname()).isEqualTo(updataCname);
    }


    @Test
    @Order(3)
    @Commit
    @Transactional
    public void 서비스_삭제() throws Exception {

        Integer [] integers = {10, 20, 30, 40};

        for(Integer i : integers){
            comdolidoliService.ComdolidoliDelete(i);

            boolean isPresent = comdolidoliRepository.findById(i).isPresent();
            log.debug(String.valueOf(isPresent));
            Assertions.assertThat(isPresent).isEqualTo(false);
        }
    }

}