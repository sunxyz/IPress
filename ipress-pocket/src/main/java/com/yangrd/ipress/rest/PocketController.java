package com.yangrd.ipress.rest;

import com.yangrd.ipress.application.PocketApplicationService;
import com.yangrd.ipress.domain.pocket.Pocket;
import com.yangrd.ipress.infrastructure.command.PocketCreatedCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PocketController
 *
 * @author yangrd
 * @date 2019/05/14
 */
@AllArgsConstructor

@RestController
@RequestMapping("/pocket")
public class PocketController {

    private PocketApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PocketCreatedCommand createdCommand) {
        applicationService.save(createdCommand);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody PocketCreatedCommand command) {
        applicationService.updateById(id, command);
    }

    @GetMapping
    public List<Pocket> listAll() {
        return applicationService.listPocketByCurrentUsername();
    }
}
