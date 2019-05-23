package com.yangrd.ipress.rest;

import com.yangrd.ipress.application.EntryApplicationService;
import com.yangrd.ipress.domain.entry.Entry;
import com.yangrd.ipress.domain.entry.EntryRepository;
import com.yangrd.ipress.infrastructure.command.EntryCreatedCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * EntryController
 *
 * @author yangrd
 * @date 2019/05/14
 */
@AllArgsConstructor

@RestController
@RequestMapping("/entry")
public class EntryController {

    EntryApplicationService applicationService;

    EntryRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EntryCreatedCommand command) {
        applicationService.save(command);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody EntryCreatedCommand command) {
        applicationService.updateById(id, command);
    }

    @GetMapping("/{id}")
    public Entry get(@PathVariable("id") Entry entry){
        return entry;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        applicationService.deleteById(id);
    }

}
