/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CursoDao;
import br.edu.ifsp.pep.model.Curso;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("cursoConverter")
public class CursoConverter implements Converter<Curso>{
    
    @Override
    public Curso getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()) {
            return null;
        }
        CursoDao cursoDao = CDI.current().select(CursoDao.class).get();
        return cursoDao.findById(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Curso curso) {
        if(curso == null) {
            return null;
        }
        return curso.getId().toString();
        
    }
    
}
