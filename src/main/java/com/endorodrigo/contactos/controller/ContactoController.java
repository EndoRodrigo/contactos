package com.endorodrigo.contactos.controller;

import com.endorodrigo.contactos.model.Contacto;
import com.endorodrigo.contactos.service.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ContactoController {

    public static Logger logger = LoggerFactory.getLogger(ContactoController.class);

    private ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio(ModelMap model) {
        List<Contacto> contactos = contactoService.findAll();
        logger.debug("Contactos de la lista: " + contactos.toString());
        model.put("contactos", contactos);
        return "index";
    }

    @RequestMapping(value = "agregar", method = RequestMethod.GET)
    public String agregar(ModelMap model) {
        return "agregar";
    }

    @RequestMapping(value = "agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto) {
        logger.debug("Agregando contacto: " + contacto.toString());
        contactoService.save(contacto);
        //return "index"; no muestra el listado de clientes
        return "redirect:/";
    }

}
