package tn.esprit.services;

import tn.esprit.entities.Departement;
import tn.esprit.interfaces.IDepartement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepartementHashSet implements IDepartement<Departement> {
    private final Set<Departement> departements = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement departement) {
        departements.add(departement);
    }

    @Override
    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement departement : departements) {
            if (departement.getNomDepartement() != null
                    && departement.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement departement) {
        return departements.contains(departement);
    }

    @Override
    public void supprimerDepartement(Departement departement) {
        departements.remove(departement);
    }

    @Override
    public void afficherDepartements() {
        for (Departement departement : departements) {
            System.out.println(departement);
        }
    }

    @Override
    public void trierDepartementsParId() {
        List<Departement> resultat = new ArrayList<>(departements);
        resultat.sort(Comparator.comparingInt(Departement::getId));
        afficher(resultat);
    }

    @Override
    public void trierDepartementsParNomEtNombreEmployes() {
        List<Departement> resultat = new ArrayList<>(departements);
        resultat.sort(Comparator.comparing(
                        Departement::getNomDepartement,
                        Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER))
                .thenComparingInt(Departement::getNombreEmployes)
                .thenComparingInt(Departement::getId));
        afficher(resultat);
    }

    private void afficher(List<Departement> departementsTries) {
        for (Departement departement : departementsTries) {
            System.out.println(departement);
        }
    }
}
