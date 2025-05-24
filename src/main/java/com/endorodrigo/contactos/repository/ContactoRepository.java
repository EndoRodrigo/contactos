package com.endorodrigo.contactos.repository;

import com.endorodrigo.contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto,Integer> {
}
