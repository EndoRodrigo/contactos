package com.endorodrigo.contactos.service;

import com.endorodrigo.contactos.model.Contacto;
import com.endorodrigo.contactos.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService implements IContactoService{

    private ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public List<Contacto> findAll() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto findById(Integer id) {
        return contactoRepository.findById(id).get();
    }

    @Override
    public void save(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void deleteById(Integer id) {
        contactoRepository.deleteById(id);
    }
}
