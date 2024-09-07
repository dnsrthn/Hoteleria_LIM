package  com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

@Entity
@Data
@Table(name = "Pais")
public class Pais implements Serializable{
    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_pais;

    @NotBlank(message = "Necesita llenar el campo de nombre")
    private String nombre;

        
   
}
