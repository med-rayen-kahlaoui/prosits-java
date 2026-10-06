package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Friguia Park", "Bouficha");
        Zoo secondZoo = new Zoo("Belvedere", "Tunis");

        Animal lion = new Animal("Felins", "Simba", 5, true);
        Animal elephant = new Animal("Elephantides", "Dumbo", 10, true);
        Animal tiger = new Animal("Felins", "Shere Khan", 7, true);
        Animal duplicateLion = new Animal("Felins", "Simba", 5, true);

        System.out.println("On ajoute quelques animaux a Friguia Park.");
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(duplicateLion);

        System.out.println("\nVoici les animaux qui vivent actuellement a Friguia Park :");
        myZoo.displayAnimals();

        int index = myZoo.searchAnimal(elephant);
        System.out.println("Dumbo est a la position " + index + " dans la liste.");

        Animal unknownAnimal = new Animal("Oiseaux", "Chouette", 2, false);
        System.out.println("Chouette n'est pas dans le zoo (position " + myZoo.searchAnimal(unknownAnimal) + ").");

        System.out.println("\nOn retire Dumbo du zoo : " + myZoo.removeAnimal(elephant));
        myZoo.displayAnimals();

        System.out.println("\nVoyons si Friguia Park a encore de la place, puis quel zoo accueille le plus d'animaux.");
        secondZoo.addAnimal(new Animal("Oiseaux", "Picoti", 1, false));

        System.out.println(myZoo.getName() + " a-t-il encore de la place ? " + !myZoo.isZooFull());

        Zoo maxZoo = Zoo.comparerZoo(myZoo, secondZoo);
        System.out.println("Pour le moment, " + maxZoo.getName() + " accueille le plus d'animaux.");
    }
}
