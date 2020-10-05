
public class Healer{
    
//declaraing instance variables
private String name;
private int level; 
private int maxHealth;
private int health; 
private int attack;
private int defense; 
private int magicAttack;
private int magicDefense;
private int agility;
private int wisdom;
private int exp;

    //constructor for lvl 1 chars
    public Healer(String n) {
       name = n; 
        level = 1;
        maxHealth = 16;
        health = maxHealth; 
        attack = 4;
        defense = 6;
        magicAttack = 5;
        magicDefense = 10;
        agility = 3; 
        wisdom = 12;
        exp = 0;
    }
    
    //constructor for higher lvl chars
    public Healer(String n, int lev) {
       name = n;
       level = lev;
       maxHealth = 16*lev;
       health = maxHealth; 
       attack = 4*lev; 
       defense = 6*lev;
       magicAttack = 5*lev;
       magicDefense = 10*lev;
       agility = 3*lev;
       wisdom = 12*lev;
       exp = 0;
    }
     public void levelUp() { //void methods don't need return statement only do return;
        level++;      // ^ empty parameters mean nothing inside
        maxHealth += 16; 
        health += 16;
        attack += 4;
        defense += 6;
        magicAttack += 5;
        magicDefense += 10;
        agility += 3;
        wisdom += 12;
    }
    public void gainExp(int expGain) {
        if(expGain > 1000)
            expGain = 1000;
        exp += expGain; 
        if(exp >= 1000) {   //needs brackets because has 2 resulting commands
            levelUp();     //calling method from line 47
            exp -= 1000;  // can also do exp = exp - 1000 too
        }
    }
public String toString() {
     String str = "";
     str += "Name: " + name + "\n";
     str += "Level " + level + "Healer\n";
     str += "Current EXP: " + exp + "\n";
     str += health + "/" + maxHealth + " Health\n";
     str += "Attack: " + attack + " Defense: " + defense + "\n";
     str += "Magic Attack: " + magicAttack + " Magic Defense: " + magicDefense + "\n";
     str += "Agility: " + agility + " Wisdom: " + wisdom + "\n\n";
     return str;
 }
 public int attack(int targetDef, int targetAgi) {
     boolean hit = hitCheck(targetAgi);
     if(hit)
        return calcDamage(targetDef);
     else
        return 0;
 }
 private boolean hitCheck (int targetAgi) {
     double probability = (double)agility/targetAgi; //our agi/targetAgi, need double bc percentage
     if(Math.random() < probability) { //when math.random is less than 0.75 it is true
        System.out.println("Hit!");
         return true;
      }
     else {
        System.out.println("Miss");
        return false;
      }
    }
 
    private int calcDamage(int targetDef) {
        int damage = (int)(1.36*attack*Math.pow(2.72, -(double)targetDef/attack) + 0.5);
        System.out.println(damage + " Damage");
        return damage;
    }
 
    public int heal(int targetHealth, int targetMax) {
        int heal = wisdom; 
        if(heal > targetMax - targetHealth)
            heal = targetMax - targetHealth; 
        System.out.println("Heal " + heal);
        return heal; 
    }
    
    
}
