package com.devariel.cadastro_de_produto.repository;

import com.devariel.cadastro_de_produto.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
