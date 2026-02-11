package com.devariel.cadastro_de_produto.service;

import com.devariel.cadastro_de_produto.exception.ResourceNotFoundException;
import com.devariel.cadastro_de_produto.model.Producer;
import com.devariel.cadastro_de_produto.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {
    public final ProducerRepository producerRepository;

    public List<Producer> findAll(){
        return producerRepository.findAll();
    }

    public Producer findById(Long id){
        return producerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producer with id "+id+ "not found"));
    }

    public Producer save(Producer producer){
        return producerRepository.save(producer);
    }

    public void deleteById(Long id){

        if (!producerRepository.existsById(id)){
            throw new ResourceNotFoundException("Producer with id "+id+ "not found");
        }
        producerRepository.deleteById(id);
    }

    public Producer update(Producer producer, Long id){
        Producer producerById = producerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found"));
        producerById.setName(producer.getName());
        producerById.setPrice(producer.getPrice());
        return producerRepository.save(producerById);
    }
}
