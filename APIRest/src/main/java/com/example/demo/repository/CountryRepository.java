package com.example.demo.repository;
import com.example.demo.models.CountryModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryModel, Long> {
    public abstract ArrayList<CountryModel> findByPrioridad(Integer prioridad);

}
