import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom du zoo");
        String zooName = sc.nextLine();

        System.out.println(" Le Zoo " + zooName + " est composé de " + Zoo.MAX_CAGES + " cages");

        Zoo myZoo = new Zoo(zooName, "Ariana");

        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal aigle = new Animal("Rapaces", "Aigle royal", 3, false);
        Animal serpent = new Animal("Reptiles", "Python", 2, false);

        System.out.println("\n--- Ajout d'animaux ---");
        System.out.println("Ajout du lion : " + myZoo.addAnimal(lion));
        System.out.println("Ajout de l'aigle : " + myZoo.addAnimal(aigle));
        System.out.println("Ajout du serpent : " + myZoo.addAnimal(serpent));

        System.out.println("\n--- Liste des animaux du zoo ---");
        myZoo.displayAnimals();

        System.out.println("\n--- Recherche d'animaux ---");
        int indexLion = myZoo.searchAnimal(lion);
        System.out.println("Index du lion : " + indexLion);

        Animal lionBis = new Animal("Félins", "Lion", 5, true);
        int indexLionBis = myZoo.searchAnimal(lionBis);
        System.out.println("Index du lion bis (objet différent, même nom) : " + indexLionBis);

        System.out.println("\n--- Test d'unicité ---");
        boolean ajoutDoublon = myZoo.addAnimal(lionBis);
        System.out.println("Ajout du lion bis (doublon) réussi ? " + ajoutDoublon);

        System.out.println("\n--- Remplissage du zoo jusqu'à la capacité max ---");
        for (int i = myZoo.getNbAnimals(); i < Zoo.MAX_CAGES + 1; i++) {
            Animal a = new Animal("Famille" + i, "Animal" + i, i % 20, i % 2 == 0);
            boolean ajoute = myZoo.addAnimal(a);
            if (!ajoute) {
                System.out.println("Impossible d'ajouter Animal" + i + " : le zoo est plein.");
            }
        }

        System.out.println("Le zoo est-il plein ? " + myZoo.isZooFull());
        System.out.println("Nombre d'animaux dans le zoo : " + myZoo.getNbAnimals());

        System.out.println("\n--- Suppression du serpent ---");
        boolean suppression = myZoo.removeAnimal(serpent);
        System.out.println("Suppression réussie ? " + suppression);
        System.out.println("Nombre d'animaux après suppression : " + myZoo.getNbAnimals());

        boolean suppressionInexistant = myZoo.removeAnimal(new Animal("X", "Inconnu", 1, false));
        System.out.println("Suppression d'un animal inexistant réussie ? " + suppressionInexistant);

        System.out.println("\n--- Résumé du zoo ---");
        myZoo.displayZoo();
        System.out.println(myZoo);

        System.out.println("\n--- Comparaison de deux zoos ---");
        Zoo autreZoo = new Zoo("Zoo Voisin", "Tunis");
        autreZoo.addAnimal(new Animal("Félins", "Tigre", 4, true));

        Zoo zooLePlusGrand = Zoo.comparerZoo(myZoo, autreZoo);
        System.out.println("Le zoo avec le plus d'animaux est : " + zooLePlusGrand.getName()
                + " (" + zooLePlusGrand.getNbAnimals() + " animaux)");

        sc.close();
    }
}