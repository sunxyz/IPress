package com.yangrd.ipress.rest;

import com.yangrd.ipress.application.MenuApplicationService;
import com.yangrd.ipress.application.dto.FolderFlat;
import com.yangrd.ipress.application.dto.MenuTree;
import com.yangrd.ipress.infrastructure.IDGenerator;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.IdGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Set;

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
        command.setId(IDGenerator.genId());
        command.setType(0);
        applicationService.create(command);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody MenuCreatedCommand command) {
        applicationService.update(id, command);
    }

    @GetMapping("/tree")
    public Set<MenuTree> listTree() {
        return applicationService.listTree();
    }

    @GetMapping("/folder")
    public List<FolderFlat> listFolderFlat() {
        return applicationService.listFolderFlat();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        applicationService.delete(id);
    }


}
