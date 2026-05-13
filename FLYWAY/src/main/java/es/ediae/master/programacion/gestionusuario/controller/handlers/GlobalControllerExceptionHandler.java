/*package es.ediae.master.programacion.gestionusuario.controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import es.ediae.master.programacion.gestionusuario.exception.GeneralException;

public class GlobalControllerExceptionHandler {


    public ResponseEntity<String> handleUnsupportedMediaTypeException(UnsupportedMediaTypeException ex) {
        return ResponseEntity<T>.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
    }

    @ExceptionHanderler(GeneralException.class)
    public ResponseEntity<ModelMap> handleGeneralException(GeneralException ex) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("error", ex.getClass().getSimpleName());
        modelMap.addAttribute("errorCode", ex.getClass().getSimpleName());
        modelMap.addAttribute("mensajeDeError", ex.getMensajeDeError());
        return new ResponseEntity<>(modelMap, HttpStatus.NOT_IMPLEMENTED).body(modelMap);
    }
    
}*/
