import entities.Employe;
import services.SocieteArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        societe.ajouterEmploye(new Employe(2, "Benali", "Ahmed", "Informatique", 2));
        societe.ajouterEmploye(new Employe(1, "Sassi", "Noura", "RH", 1));
        societe.ajouterEmploye(new Employe(4, "Cherif", "Yassine", "Finance", 3));
        societe.ajouterEmploye(new Employe(3, "Khaled", "Amine", "Informatique", 2));

        System.out.println("Avant tri :");
        societe.displayEmploye();

        societe.trierEmployeParId();
        System.out.println("\nTri par id :");
        societe.displayEmploye();

        societe.trierEmployeParNomDepartementEtGrade();
        System.out.println("\nTri par departement, grade puis nom :");
        societe.displayEmploye();

        System.out.println("\nRecherche par nom 'Sassi' : " + societe.rechercherEmploye("Sassi"));

        Employe employe = new Employe(4, "Cherif", "Yassine", "Finance", 3);
        System.out.println("Recherche par objet : " + societe.rechercherEmploye(employe));

        societe.supprimerEmploye(employe);
        System.out.println("\nApres suppression :");
        societe.displayEmploye();

        System.out.println("\nEmployes du departement Informatique :");
        List<Employe> liste = societe.rechercherParDepartement("Informatique");
        for (Employe e : liste) {
            System.out.println(e);
        }
    }
}