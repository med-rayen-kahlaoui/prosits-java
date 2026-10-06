package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    public static final int NUMBER_OF_CAGES = 25;
    private int animalCount;

    public Zoo() {
        this("Zoo sans nom", "");
    }

    public Zoo(String name, String city) {
        this.animals = new Animal[NUMBER_OF_CAGES];
        this.animalCount = 0;
        setName(name);
        setCity(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Donnez un nom au zoo.");
        }
        this.name = name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public boolean isZooFull() {
        return animalCount >= NUMBER_OF_CAGES;
    }

    public int searchAnimal(Animal animal) {
        if (animal == null || animal.getName() == null) return -1;

        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equalsIgnoreCase(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("Impossible d'ajouter l'animal : aucune information n'a ete fournie.");
            return false;
        }

        if (isZooFull()) {
            System.out.println("Il n'y a plus de place pour accueillir " + animal.getName() + ".");
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println(animal.getName() + " est deja dans le zoo.");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Dans " + name + ", on peut rencontrer :");
        if (animalCount == 0) {
            System.out.println("Pour le moment, aucun animal n'a encore ete accueilli.");
            return;
        }
        for (int i = 0; i < animalCount; i++) {
            System.out.println("[" + i + "] " + animals[i]);
        }
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            String animalName = animal == null ? "inconnu" : animal.getName();
            System.out.println("On n'a pas trouve " + animalName + " dans ce zoo.");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;

        if (z1.animalCount >= z2.animalCount) {
            return z1;
        } else {
            return z2;
        }
    }

    @Override
    public String toString() {
        return name + " (ville : " + city +
                ", animaux : " + animalCount + "/" + NUMBER_OF_CAGES + ")";
    }
}
