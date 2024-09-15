package com.limsolutions.hotelerialim.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.limsolutions.hotelerialim.models.Hotel;
import com.limsolutions.hotelerialim.service.CloudinaryService;
import com.limsolutions.hotelerialim.service.HotelService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("HoteleriaLIMSolutions/v1/Hotel")
//Para postman y web: http://localhost:8085/HoteleriaLIMSolutions/v1/Hotel/
public class HotelController {

    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    @Autowired
   private CloudinaryService cloudiService;


    @PostMapping("/registro-hotel")
    public ResponseEntity<?> registrarHotel(@RequestPart("hotelPhoto") MultipartFile hotelPhoto,
    @Valid @RequestBody Hotel hotelAgregar){

        Map<String,Object> errores = new HashMap<>();
        try{
            logger.info("Guardando nuevo registro de Hotel: "+ hotelAgregar);

            Map<String,Object> uploadResult = cloudiService.uploadImg(hotelPhoto, "hoteles"); //metadata de la imagen en cloudi almacenada en variable tipo Map
            String urlPhoto = uploadResult.get("url").toString(); //el get key es segun la llave de busqueda que es la url para imagen
            String img = urlPhoto.substring(urlPhoto.indexOf("hotelPhotos/"));

            hotelService.registrarHotel(hotelAgregar);

            logger.info("Hotel " + hotelAgregar + " registrado correctamente");
            return new ResponseEntity<>(HttpStatus.CREATED);

         }catch(CannotCreateTransactionException e){
            logger.error("Error al procesar la transaccion");
            errores.put("Mensaje", "Error al crear la transaccion");
            errores.put("Error",e.getMessage());
            return new ResponseEntity<>(errores,HttpStatus.SERVICE_UNAVAILABLE);
         }catch(IOException e){
         logger.error("Error de entrada de archivos");
         errores.put("Mensaje", "Error al subir la imagen");
         errores.put("Error",e.getMessage());
         return new ResponseEntity<>(errores,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(DataAccessException e){
            logger.error("Error al conectar a la base de datos");
            errores.put("Mensaje", "Error al conectar a la base de datos");
            errores.put("Error",e.getMessage());
            return new ResponseEntity<>(errores,HttpStatus.SERVICE_UNAVAILABLE);
         }catch(ConstraintViolationException e) {
            logger.error("Violación de restricciones de datos");
            errores.put("Mensaje", "Los datos del hotel no cumplen las restricciones");
            errores.put("Error", e.getMessage());
            return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
        }catch(HttpMessageNotReadableException e) {
            logger.error("Error al leer el cuerpo de la solicitud");
            errores.put("Mensaje", "El formato de la solicitud es inválido");
            errores.put("Error", e.getMessage());
            return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/hoteles")
    public List<Hotel> listarHoteles(){
        var hotel = hotelService.listarHoteles();
        hotel.forEach((objHoteles -> logger.info(objHoteles.toString())));
        return hotel;
    }

    @GetMapping("/buscar-hotel/{idHotel}")
    public ResponseEntity <Hotel> buscarHotel(@PathVariable Long idHotel){
        Hotel hotel = hotelService.buscarHotel(idHotel);
        if(hotel == null){
            logger.error("No se pudo encontrar el hotel indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(hotel);
    }

    @PatchMapping("cambiar-estado/{idHotel}")
    public ResponseEntity<Hotel> actualizarEstado(@PathVariable Long idHotel,@RequestBody Hotel hotelRecibido) {
        Hotel  hotelEditar = hotelService.buscarHotel(idHotel);

        if(hotelEditar == null){
            logger.error("No se pudo encontrar el hotel indicado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hotelEditar.setEstado(hotelRecibido.getEstado());
        hotelService.registrarHotel(hotelEditar);
        return ResponseEntity.ok(hotelEditar);
    }


    @PutMapping("/editar-hotel/{idHotel}")
        public ResponseEntity <Hotel> editarHotel (@PathVariable Long idHotel, @RequestBody Hotel hotelRecibido){
            Hotel  hotelEditar = hotelService.buscarHotel(idHotel);
            if(hotelEditar == null){
                logger.error("No se pudo encontrar el hotel indicado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                hotelEditar.setNombre(hotelRecibido.getNombre());
                hotelEditar.setCalificacion(hotelRecibido.getCalificacion());
                hotelEditar.setDireccion(hotelRecibido.getDireccion());
                hotelEditar.setCorreo(hotelRecibido.getCorreo());
                hotelEditar.setTelefono(hotelRecibido.getTelefono());
                hotelEditar.setIngresos(hotelRecibido.getIngresos());
                hotelEditar.setHotelPhoto(hotelRecibido.getHotelPhoto());
                hotelEditar.setEstado(hotelRecibido.getEstado());
                hotelEditar.setId_pais(hotelRecibido.getId_pais());
                hotelEditar.setId_ciudad(hotelRecibido.getId_ciudad());
                hotelService.registrarHotel(hotelEditar);
                logger.info("Guardando registros modificados del hotel");
            }
                return ResponseEntity.ok(hotelEditar);
        }

}
