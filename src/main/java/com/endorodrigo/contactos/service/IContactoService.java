package com.endorodrigo.contactos.service;

import com.endorodrigo.contactos.model.Contacto;

import java.util.List;

public interface IContactoService {
    public List<Contacto> findAll();
    public Contacto findById(Integer id);
    public void save(Contacto contacto);
    public void deleteById(Integer id);
}
