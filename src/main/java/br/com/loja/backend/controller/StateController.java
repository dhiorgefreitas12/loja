package br.com.loja.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.loja.backend.entity.State;
import br.com.loja.backend.service.StateService;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/")
    public List<State> getAll() {
        return stateService.getAll();
    }

    @PostMapping("/")
    public State register(@RequestBody State state) {
        return stateService.register(state);
    }

    @PutMapping("/")
    public State update(@RequestBody State state) {
        return stateService.update(state);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        stateService.delete(id);
        return ResponseEntity.ok().build();
    }
}
