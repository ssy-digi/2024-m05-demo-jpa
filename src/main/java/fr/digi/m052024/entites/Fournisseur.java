package fr.digi.m052024.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOM", length = 25, nullable = false)
    private String raisonSociale;
    @Transient
    private String siret;

    public Fournisseur() {
    }

    public Fournisseur(String raisonSociale, String siret) {
        this.raisonSociale = raisonSociale;
        this.siret = siret;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", raisonSociale='").append(raisonSociale).append('\'');
        sb.append(", siret='").append(siret).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
