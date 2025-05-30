package com.endorodrigo.contactos.controller;

import com.endorodrigo.contactos.model.Contacto;
import com.endorodrigo.contactos.service.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    //@GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") Integer idContacto,
                                ModelMap modelo){
        logger.info("Mostrando el id contacto: " + idContacto);
        Contacto contacto = contactoService.findById(idContacto);
        logger.info("Contacto a editar (mostrar): " + contacto);
        modelo.put("contacto", contacto);
        return "editar"; //editar.html
    }

    @RequestMapping(value = "editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("contacto") Contacto contacto) {
        logger.debug("Agregando contacto: " + contacto.toString());
        contactoService.save(contacto);
        //return "index"; no muestra el listado de clientes
        return "redirect:/";
    }

    @RequestMapping(value = "eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable(value = "id") Integer idContacto) {
        Contacto contacto = contactoService.findById(idContacto);
        if (contacto != null) {
            contactoService.deleteById(idContacto);
            logger.info("Eliminando contacto: " + contacto);
        }

        return "redirect:/";
    }



}
