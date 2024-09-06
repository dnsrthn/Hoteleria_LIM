package com.limsolutions.hotelerialim.models;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.Table;
    import java.io.Serializable;
    import lombok.Data;
    
    

    @Entity
    @Data
    @Table(name = "Ciudad")
    public class Ciudad implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_ciudad")
        private Long id_ciudad;
 
        @Column(name = "Nombre")
        private String nombre;
    
        @OneToMany
        @JoinColumn(name = "pais", nullable = false)
        private String pais;
}

