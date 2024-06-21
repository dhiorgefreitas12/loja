package br.com.loja.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.State;
import br.com.loja.backend.repository.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAll() {
        return stateRepository.findAll();
    }

    public State register(State state) {
        state.setCreationdate(new Date());
        State stateNew = stateRepository.saveAndFlush(state);
        return stateNew;
    }

    public State update(State state) {
        state.setUpdatedate(new Date());
        return stateRepository.saveAndFlush(state);
    }

    public void delete( Long id) {
        State state = stateRepository.findById(id).get();
        stateRepository.delete(state);
    }

}
