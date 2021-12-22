package com.example.demo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CountryRepository;
import java.util.Optional;
import com.example.demo.models.CountryModel;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;
    
    public ArrayList<CountryModel> obtenerPaises(){
        return (ArrayList<CountryModel>) countryRepository.findAll();
    }

    public CountryModel guardarPais(CountryModel pais){
        return countryRepository.save(pais);
    }

    public Optional<CountryModel> obtenerPorId(Long id){
        return countryRepository.findById(id);
    }


    public ArrayList<CountryModel>  obtenerPorPrioridad(Integer prioridad) {
        return countryRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarPais(Long id) {
        try{
            countryRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}