package kr.geun.o.hwp.sample.controller;

import kr.geun.o.hwp.sample.entity.CircleEntity;
import kr.geun.o.hwp.sample.repo.CircleRepo;
import kr.geun.o.hwp.sample.type.ColorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CircleController
 *
 * @author akageun
 * @since 2019-09-03
 */
@Slf4j
@RestController
@RequestMapping("/circle")
public class CircleController {

    @Autowired
    private CircleRepo circleRepo;

    @GetMapping("/all")
    public String findAll() {
        for (CircleEntity circleEntity : circleRepo.findAll()) {
            log.info("test : {}, {}, {}", circleEntity.getId(), circleEntity.getColorType(), circleEntity.getSize());
        }


        return "OK";
    }

    @PostMapping("/save")
    public String save(
        @RequestParam("color") ColorType colorType,
        @RequestParam("size") int size
    ) {
        circleRepo.save(
            CircleEntity.builder()
                .colorType(colorType)
                .size(size)
                .build()
        );

        return "OK";
    }
}
