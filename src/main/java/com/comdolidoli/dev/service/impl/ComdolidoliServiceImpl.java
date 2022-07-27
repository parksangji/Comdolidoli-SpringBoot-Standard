package com.comdolidoli.dev.service.impl;

import com.comdolidoli.dev.core.exception.BusinessException;
import com.comdolidoli.dev.dto.ResponseComdoliDto;
import com.comdolidoli.dev.entity.ComdolidoliEntity;
import com.comdolidoli.dev.repository.ComdolidoliRepository;
import com.comdolidoli.dev.service.ComdolidoliService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ComdolidoliServiceImpl implements ComdolidoliService {

    final ComdolidoliRepository comdolidoliRepository;

    @Override
    public List<ResponseComdoliDto> ComdolidoliList() throws BusinessException {

        List<ResponseComdoliDto> responseComdoliDtoList = new ArrayList<>();

        comdolidoliRepository.findAll().forEach(comdolidoliEntity -> {
            log.debug(comdolidoliEntity.toString());
            responseComdoliDtoList.add(new ResponseComdoliDto(comdolidoliEntity));
        });
        return responseComdoliDtoList;
    }

    @Override
    public ResponseComdoliDto ComdolidoliDetail(Integer cno) throws BusinessException {

        Optional<ComdolidoliEntity> optionalComdolidoliEntity = comdolidoliRepository.findById(cno);
        ComdolidoliEntity comdolidoliEntity = optionalComdolidoliEntity.orElseThrow(()-> new BusinessException("해당 번호에 대한 정보가 없습니다."));
        return new ResponseComdoliDto(comdolidoliEntity);
    }

    @Override
    @Transactional
    public ResponseComdoliDto ComdoldolInsert(ComdolidoliEntity comdolidoliEntity) throws BusinessException {
        Optional<ComdolidoliEntity> optionalComdolidoliEntity =  comdolidoliRepository.findById(comdolidoliEntity.getCno());
        if(!optionalComdolidoliEntity.isPresent()) {
            comdolidoliEntity = comdolidoliRepository.save(comdolidoliEntity);
        }else{
            throw new BusinessException("이미 번호가 존재합니다.");
        }
        return new ResponseComdoliDto(comdolidoliEntity);
    }

    @Override
    @Transactional
    public ResponseComdoliDto ComdolidoliUpdate(ComdolidoliEntity comdolidoliEntity) throws BusinessException {
        Optional<ComdolidoliEntity> optionalComdolidoliEntity =  comdolidoliRepository.findById(comdolidoliEntity.getCno());
        if(optionalComdolidoliEntity.isPresent()) {
            return new ResponseComdoliDto(comdolidoliRepository.save(comdolidoliEntity));
        }else{
            throw new BusinessException("번호가 존재하지 않습니다.");
        }
    }

    @Override
    @Transactional
    public void ComdolidoliDelete(Integer cno) {
        comdolidoliRepository.deleteById(cno);
    }
}
