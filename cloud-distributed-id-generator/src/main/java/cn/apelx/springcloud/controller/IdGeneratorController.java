package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ID生成器 Controller
 *
 * @author lx
 * @since 2020/7/11 16:21
 */
@RestController
public class IdGeneratorController {

    private IdGeneratorService idGeneratorService;

    @GetMapping(value = "/generator/distribute/id")
    public String generatorDistributeId() {
        return String.valueOf(idGeneratorService.generatorDistributeId(null, null));
    }

    @Autowired
    public void setIdGeneratorService(IdGeneratorService idGeneratorService) {
        this.idGeneratorService = idGeneratorService;
    }
}
