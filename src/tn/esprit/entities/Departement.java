package tn.esprit.entities;

import java.util.Locale;
import java.util.Objects;

public class Departement {
    private int id;
    private String nomDepartement;
    private int nombreEmployes;

    public Departement() {
    }

    public Departement(int id, String nomDepartement, int nombreEmployes) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.nombreEmployes = nombreEmployes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Departement)) {
            return false;
        }
        Departement departement = (Departement) obj;
        return id == departement.id
                && Objects.equals(normaliser(nomDepartement), normaliser(departement.nomDepartement));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, normaliser(nomDepartement));
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", nombreEmployes=" + nombreEmployes +
                '}';
    }

    private static String normaliser(String nom) {
        return nom == null ? null : nom.toLowerCase(Locale.ROOT);
    }
}
