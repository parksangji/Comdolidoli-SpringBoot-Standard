package com.comdolidoli.dev.service;

import com.comdolidoli.dev.core.exception.BusinessException;
import com.comdolidoli.dev.dto.ResponseComdoliDto;
import com.comdolidoli.dev.entity.ComdolidoliEntity;

import java.util.List;

public interface ComdolidoliService {

    public List<ResponseComdoliDto> ComdolidoliList() throws BusinessException;
    public ResponseComdoliDto ComdolidoliDetail(Integer cno) throws BusinessException;
    public ResponseComdoliDto ComdoldolInsert(ComdolidoliEntity comdolidoliEntity) throws BusinessException;
    public ResponseComdoliDto ComdolidoliUpdate(ComdolidoliEntity comdolidoliEntity) throws BusinessException;
    public void ComdolidoliDelete(Integer cno);

}
