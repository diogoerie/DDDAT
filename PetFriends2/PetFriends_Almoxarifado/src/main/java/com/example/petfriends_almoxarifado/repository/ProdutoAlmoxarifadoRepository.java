package com.example.petfriends_almoxarifado.repository;


import com.example.petfriends_almoxarifado.entity.ProdutoAlmoxarifado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoAlmoxarifadoRepository extends JpaRepository<ProdutoAlmoxarifado, Long> {
}