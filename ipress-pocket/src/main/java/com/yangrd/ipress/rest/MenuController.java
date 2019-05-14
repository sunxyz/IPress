package com.yangrd.ipress.rest;

import com.yangrd.ipress.application.MenuApplicationService;
import com.yangrd.ipress.application.dto.MenuTree;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MenuController
 *
 * @author yangrd
 * @date 2019/05/14
 */
@AllArgsConstructor

@RestController
@RequestMapping("/menu")
public class MenuController {

    private MenuApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MenuCreatedCommand command) {
        applicationService.create(command);
    }

    @GetMapping("/tree")
    public List<MenuTree> listTree() {
        return applicationService.listTree();
    }
}
