package tn.esprit;

import tn.esprit.entities.Departement;
import tn.esprit.services.DepartementHashSet;

public class Main {
    public static void main(String[] args) {
        DepartementHashSet gestion = new DepartementHashSet();

        Departement informatique = new Departement(1, "Informatique", 25);
        Departement ressourcesHumaines = new Departement(2, "Ressources humaines", 10);
        Departement finance = new Departement(3, "Finance", 15);

        gestion.ajouterDepartement(informatique);
        gestion.ajouterDepartement(ressourcesHumaines);
        gestion.ajouterDepartement(finance);
        gestion.ajouterDepartement(new Departement(1, "Informatique", 30));

        System.out.println("Départements :");
        gestion.afficherDepartements();

        System.out.println("\nRecherche par nom : "
                + gestion.rechercherDepartement("informatique"));
        System.out.println("Recherche par département : "
                + gestion.rechercherDepartement(informatique));

        System.out.println("\nTri par identifiant :");
        gestion.trierDepartementsParId();

        System.out.println("\nTri par nom et nombre d'employés :");
        gestion.trierDepartementsParNomEtNombreEmployes();

        gestion.supprimerDepartement(finance);
        System.out.println("\nAprès suppression de Finance :");
        gestion.afficherDepartements();
    }
}
