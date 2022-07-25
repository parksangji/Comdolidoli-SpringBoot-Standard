package com.comdolidoli.dev.repository;

import com.comdolidoli.dev.entity.ComdolidoliEntity;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@ActiveProfiles({"dev","db-maria"}) // dev 와 db-h2 property를 받을 수 있음
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestComdolidoliRepository {

    @Autowired
    ComdolidoliRepository deptRepository;

    @Test
    @Order(1)
    @Commit
    public void A001_DEPT_TABLE_입력(){
        List cList = new ArrayList<ComdolidoliEntity>();
        cList.add(ComdolidoliEntity.builder().cno(10).cname("ACCOUNTING").loc("SEOUL").build());
        cList.add(ComdolidoliEntity.builder().cno(20).cname("RESEARCH").loc("DALLAS").build());
        cList.add(ComdolidoliEntity.builder().cno(30).cname("SALES").loc("CHICAGO").build());
        cList.add(ComdolidoliEntity.builder().cno(40).cname("OPERATIONS").loc("BUSAN").build());
        deptRepository.saveAll(cList);

        Assertions.assertThat(deptRepository.findById(10).isPresent()).isEqualTo(true);
        Assertions.assertThat(deptRepository.findById(20).isPresent()).isEqualTo(true);
        Assertions.assertThat(deptRepository.findById(30).isPresent()).isEqualTo(true);
        Assertions.assertThat(deptRepository.findById(40).isPresent()).isEqualTo(true);

    }

    @Test
    @Order(2)
    @Commit
    public void A002_DEPT_TABLE_수정(){
       String changeCname = "ACOUNTINGSEOUL";
       deptRepository.save(ComdolidoliEntity.builder().cno(10).cname(changeCname).loc("SEOUL").build());
       ComdolidoliEntity c = deptRepository.findById(10).get();
       Assertions.assertThat(changeCname).isEqualTo(c.getCname());

    }

    @Test
    @Order(3)
    @Commit
    public void A003_DEPT_TABLE_삭제(){
        Integer [] cnos = {10,20,30,40};
        for(Integer cno :cnos){
            deptRepository.delete(ComdolidoliEntity.builder().cno(cno).build());
            boolean isPresent = deptRepository.findById(cno).isPresent();
            log.debug(String.valueOf(isPresent));
            Assertions.assertThat(isPresent).isEqualTo(false);
        }
    }
}
