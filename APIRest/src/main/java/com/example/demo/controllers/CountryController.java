package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CountryModel;
import com.example.demo.services.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pais")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping()
    public ArrayList<CountryModel> obtenerPaises(){
        return countryService.obtenerPaises();
    }

    @PostMapping()
    public CountryModel guardarPais(@RequestBody CountryModel pais){
        return this.countryService.guardarPais(pais);
    }

    @GetMapping( path = "/{id}")
    public Optional<CountryModel> obtenerPaisPorId(@PathVariable("id") Long id) {
        return this.countryService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<CountryModel> obtenerPaisPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.countryService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.countryService.eliminarPais(id);
        if (ok){
            return "Se eliminó el pais con id " + id;
        }else{
            return "No pudo eliminar el pais con id" + id;
        }
    }

}