import java.util.*;

public class Poke{
  private String name;//name of pokemon
  private String type;//pokemon type[fire, water..]
  private int healthL;//Health left for pokemon
  private int healthTot;//Total health for pokemon
  Random rand = new Random();// rand instance
  private String bar;//healthbar string initizalized
  private int attack=0;//attack hp value
  private int dodge=0;//dodge hp value
  private boolean ifAlive = true;//pokemon defeated or not

  //default constructor
  public Poke(){
    name = "";
    type = "";
    healthL = 0;
    healthTot = 0;
  }

  //constructor with params
  public Poke(String name, String type, int healthL, int healthTot){
    this.name = name;
    this.type = type;
    this.healthL = healthL;
    this.healthTot = healthTot;
  }

  //Getter and accessor methods
  public String getName(){
    return name;
  }
  public String getType(){
    return type;
  }
  public int getHealthL(){
    return healthL;
  }
  public int getHealthTot(){
    return healthTot;
  }

  //Setter and mutator methods
  public void setName(String name){
    this.name = name;
  }
  public void settype(String type){
    this.type = type;
  }
  public void setHealthL(int healthL){
    this.healthL = healthL;
  }
  public void setHealthTot(int healthTot){
    this.healthTot = healthTot;
  }

  /**
 * Computing attack value; to attack opponent
 * @param Poke hurt: opponent's object, including health and name, for decreasing health
 */
  public void attack(Poke hurt){
    attack = (rand.nextInt(159)/10)*10;
    hurt.setHealthL(hurt.getHealthL()-attack);
    if(hurt.getHealthL()<=0){
      hurt.ifAlive = false;
    }
    System.out.println("Attacking... -"+attack+"hp");
    }
  //accessor
  public int getAttack(){
    return attack;
  }
  //mutator
  public void setAttack(int newAttack){
    attack = newAttack;
  }
  //getter
  public boolean isAlive(){
    return ifAlive;
  }

   /**
   * Computing dodge value
   * @param Poke hurter: opponent's object, 
   including health, name and attack value that they attacked with
   */
  public void dodge(Poke hurter){
      if(hurter.attack==0){
        hurter.attack=1;
      }
      dodge = (rand.nextInt(hurter.attack));
      healthL+=dodge;
  System.out.println("Dodging...+"+dodge+"hp");
  }

  /**
 * Increases health by 40 hp, this is healing
 */
  public void heal(){
    int heal = 40;
    if((healthL+heal)>healthTot){
      System.out.println("You cannot heal anymore, your health is too high:");
    }
    else if((healthL+heal)<=healthTot){
      healthL+=heal;
      System.out.println("Healing...+"+heal+"hp");
    }
  }

  /**
 * Displaying health bar; for every 10 hp, there is a '|'
 * @return bar: health bar display with health shown by '|' and total health covered by '-'
 */
  public String healthBar(){
    bar="";
    for(int i=0;i<(healthL/10);i++){
      bar+="|";
    }
    for(int j=0;j<(healthTot/10)-(healthL/10);j++){
      bar+="-";
    }
    return bar;
  }

  /**
 * Prints it's battle name; this is displayed without showing hp
 * @return (name+"["+type+"] "); : This returns a formatted call card for the pokemon, which includes name and type
 */
  public String battleName(){
    return (name+"["+type+"] ");
  }
  

  //toString to printout object and class
  public String toString(){
    return name +", "+type+", "+healthL+"/"+healthTot+" hp \n"+healthBar()+"\n";
  }
  



  


}