package com.comdolidoli.dev.controller.web;

import com.comdolidoli.dev.dto.RequestComdoliDto;
import com.comdolidoli.dev.dto.ResponseComdoliDto;
import com.comdolidoli.dev.service.ComdolidoliService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class ComdolidoliController {

    final ComdolidoliService comdolidoliService;

    @GetMapping(value = "/comdolidoli")
    public String ComdolidoliList(ModelMap modelMap) throws  Exception{
        modelMap.addAttribute("comdolidoilList",comdolidoliService.ComdolidoliList());
        return "comdolidoliList";
    }

    @GetMapping(value = "/comdolidoli/{id}")
    public String ComdolidoliListDetail(@PathVariable("id") int cno,ModelMap modelMap) throws Exception{
        modelMap.addAttribute("comdolidoli", comdolidoliService.ComdolidoliDetail(cno));
        return "comdolidoliDetail";
    }

    @PostMapping(value = "/comdolidoli")
    public String ComdolidoliInsert(RequestComdoliDto requestComdoliDto) throws Exception{
        comdolidoliService.ComdoldolInsert(requestComdoliDto.toEntity());
        return "redirect:/comdolidoli";
    }
    @PostMapping(value = "/comdolidoli/update")
    public String ComdolidoliUpdate(RequestComdoliDto requestComdoliDto) throws Exception{
        comdolidoliService.ComdolidoliUpdate(requestComdoliDto.toEntity());
        return "redirect:/comdolidoli";
    }
    @PostMapping(value = "/comdolidoli/delete")
    public String ComdolidoliDelete(String cno) throws Exception{
        comdolidoliService.ComdolidoliDelete(Integer.parseInt(cno));
        return "redirect:/comdolidoli";
    }
}
