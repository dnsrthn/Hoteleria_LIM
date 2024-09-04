package  com.limsolutions.hotelerialim.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "pais")
public class pais implements Serializable{
    @Id
    @Column(name = "id")
        private Integer id;

        
   
}
