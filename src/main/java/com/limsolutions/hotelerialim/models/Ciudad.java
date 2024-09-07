package com.limsolutions.hotelerialim.models;
<<<<<<< HEAD
import java.io.Serializable;

=======

<<<<<<< HEAD
    import java.io.Serializable;

=======
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
<<<<<<< HEAD
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
=======
<<<<<<< HEAD
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
=======
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.Table;
    import java.io.Serializable;
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
    import lombok.Data;
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
    
    

    @Entity
    @Data
    @Table(name = "Ciudad")
    public class Ciudad implements Serializable {

        @Id
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
        @Column(name = "id_ciudad")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_ciudad;
 
        @Column(name = "nombre")
<<<<<<< HEAD
        @NotBlank(message = "El nombre es obligatorio")
=======
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a
        private String nombre;
    
        @ManyToOne
        @JoinColumn(name = "id_pais", nullable = false)
        private Pais id_pais;
<<<<<<< HEAD
    }
=======
=======
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_ciudad")
        private Long id_ciudad;
 
        @Column(name = "Nombre")
        private String nombre;
    
        @OneToMany
        @JoinColumn(name = "pais", nullable = false)
        private String pais;
>>>>>>> 5e9a27418b18d5d361a870c52f7cc13cd5f749ab
}
>>>>>>> b899eaeede046912b10a831bcfcda97ef953f14a

