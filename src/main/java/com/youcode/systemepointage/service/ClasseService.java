package com.youcode.systemepointage.service;

import com.youcode.systemepointage.dao.ClasseDAOImp;
import com.youcode.systemepointage.dao.GenericDAO;
import com.youcode.systemepointage.dao.PromotionDAOImp;
import com.youcode.systemepointage.model.Classe;
import com.youcode.systemepointage.model.Promotion;

import java.util.Collection;
import java.util.Optional;

public class ClasseService implements GenericService<Classe, Integer>{
    private GenericDAO<Classe, Integer> classeDAOImp = new ClasseDAOImp();

    @Override
    public Classe create(Classe classe) {
        return classeDAOImp.create(classe);
    }

    @Override
    public Optional<Classe> find(Integer id) {
        return  classeDAOImp.find(id);
    }

    @Override
    public Collection<Classe> findAll() {
        return classeDAOImp.findAll();
    }

    @Override
    public Classe update(Classe classe) {
        return classeDAOImp.update(classe);
    }

    @Override
    public boolean delete(Integer id) {
        return classeDAOImp.delete(id);
    }
}
