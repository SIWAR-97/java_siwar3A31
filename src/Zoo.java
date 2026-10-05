public class Zoo {

    public static final int MAX_CAGES = 25;

    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int nbAnimals = 0;


    public Zoo() {
        this.animals = new Animal[MAX_CAGES];
        this.nbrCages = MAX_CAGES;
    }


    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[MAX_CAGES];
        this.nbrCages = MAX_CAGES;
    }


    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbAnimals() {
        return nbAnimals;
    }


    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Échec : le zoo " + name + " est plein (" + nbrCages + " cages).");
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("Échec : " + animal.getName() + " est déjà présent dans le zoo.");
            return false;
        }
        animals[nbAnimals] = animal;
        nbAnimals++;
        return true;
    }


    public void displayAnimals() {
        if (nbAnimals == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (int i = 0; i < nbAnimals; i++) {
            System.out.println(animals[i]);
        }



    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < nbAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbAnimals - 1] = null;
        nbAnimals--;
        return true;
    }

    public boolean isZooFull() {
        return nbAnimals >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.nbAnimals >= z2.nbAnimals) ? z1 : z2;
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d'animaux : " + nbAnimals);
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                ", nbAnimals=" + nbAnimals +
                '}';
    }
}