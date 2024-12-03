public class Warrior {

    public static void main(String[] args) {
        Wizard wizard = new Wizard("Merlin", 100, 10, 5);
        Warrior warrior = new Warrior("Ragnar", 100, 7, 10);
        Archer archer = new Archer("John", 95, 8, 8);


        System.out.println(wizard.getName() + "'s health: " + wizard.getHealth());
        System.out.println(warrior.getName() + "'s health: " + warrior.getHealth());
        System.out.println(archer.getName() + "'s health: " + archer.getHealth());
        System.out.println("Game is starting...");
        warrior.setHealth(wizard);
        archer.setHealth(wizard);
        System.out.println(wizard.getName() + " attacks " + warrior.getName() + ". Health updated: " + wizard.getHealth());
        System.out.println(wizard.getName() + " attacks " + archer.getName() + ". Health updated: " + wizard.getHealth());
        System.out.println("Archer health: "+ archer.getHealth());
        System.out.println("Warrior health: "+ warrior.getHealth());
    }
}


class Wizard {
    private String name;
    private int health;
    private int darkMagic;
    private int wizardArmor;

    public Wizard(String name, int health, int darkMagic, int wizardArmor) {
        this.name = name;
        this.health = health;
        this.darkMagic = darkMagic;
        this.wizardArmor = wizardArmor;
    }

    public String getName() {
        return name;
    }

    public int getDarkMagic() {
        return darkMagic;
    }

    public void setHealth(Warrior attack) {
        health = health - (attack.getSword() - wizardArmor);
    }

    public int getHealth() {
        return health;
    }

}

class Warrior {
    private String name;
    private int health;
    private int sword;
    private int metalArmor;

    public Warrior(String name, int health, int sword, int metalArmor) {
        this.name = name;
        this.health = health;
        this.sword = sword;
        this.metalArmor = metalArmor;
    }

    public String getName() {
        return name;
    }

    public int getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(Wizard attack) {
        health = health - (attack.getDarkMagic() - metalArmor);
    }

}

class Archer {
    private String name;
    private int health;
    private int arrow;
    private int archerArmor;

    public Archer(String name, int health, int arrow, int archerArmor) {
        this.name = name;
        this.health = health;
        this.arrow = arrow;
        this.archerArmor = archerArmor;
    }

    public String getName() {
        return name;
    }

    public int getArrow() {
        return arrow;
    }

    public int getHealth() {
        return health;
    }

    public int getArcherArmor() {
        return archerArmor;
    }
        public void setHealth (Wizard attack){
            health = health - (attack.getDarkMagic() - archerArmor);
        }
    }


