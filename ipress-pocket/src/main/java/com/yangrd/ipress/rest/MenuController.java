package com.yangrd.ipress.rest;

import com.yangrd.ipress.application.MenuApplicationService;
import com.yangrd.ipress.application.dto.FolderFlat;
import com.yangrd.ipress.application.dto.MenuTree;
import com.yangrd.ipress.infrastructure.IDGenerator;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        applicationService.save(command);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody MenuCreatedCommand command) {
        applicationService.updateById(id, command);
    }

    @GetMapping("/tree")
    public Set<MenuTree> listTree(String pocketId) {
        return applicationService.getCurrentUserMenuTrees(pocketId);
    }

    @GetMapping("/folder")
    public List<FolderFlat> listFolderFlat(String pocketId) {
        return applicationService.listFolderFlatByCurrentUsername(pocketId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        applicationService.deleteById(id);
    }

    @GetMapping("/{id}/parents")
    public List<String> listParentsId(@PathVariable String id){
        return applicationService.listParentsId(id);
    }


}
