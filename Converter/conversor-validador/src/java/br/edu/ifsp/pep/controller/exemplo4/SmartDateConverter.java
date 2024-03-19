package br.edu.ifsp.pep.controller.exemplo4;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter("smartDate")
public class SmartDateConverter implements Converter<Object>{
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalDate dataConvertida = null;
        System.out.println("Value: "+value);
        
        if(value == null || value.equals("")) {
            return null;
        }
        
        if(value.equalsIgnoreCase("hoje")) {
            dataConvertida = LocalDate.now();
        } else if(value.equalsIgnoreCase("amanha") || (value.equalsIgnoreCase("amanhã"))) {
            dataConvertida = LocalDate.now().plusDays(1);
        } else if(value.equalsIgnoreCase("ontem")) {
            dataConvertida = LocalDate.now().minusDays(1);
        } else {
            dataConvertida = LocalDate.parse(value, formatter);
        }
        System.out.println(dataConvertida);
        return dataConvertida;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) 
            return null;
        
        LocalDate date = (LocalDate) value;
        return date.format(formatter);
    }
    
}
