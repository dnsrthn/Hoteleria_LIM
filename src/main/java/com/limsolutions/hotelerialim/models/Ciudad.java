package com.limsolutions.hotelerialim.models;

    import java.io.Serializable;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
    import lombok.Data;
    
    

    @Entity
    @Data
    @Table(name = "Ciudad")
    public class Ciudad implements Serializable {

        @Id
        @Column(name = "id_ciudad")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_ciudad;
 
        @Column(name = "nombre")
        private String nombre;
    
        @ManyToOne
        @JoinColumn(name = "id_pais", nullable = false)
        private Pais id_pais;
}

