import java.util.*;

public class PokeClass{
  int constructorType;
  Poke p1;
  Poke p2;
  Poke p3;
  Poke p4;
  Poke p5;
  Poke p6;
  
  //Constructor for 6 pokemons
  public PokeClass(Poke p1, Poke p2, Poke p3, Poke p4, Poke p5, Poke p6){
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
    this.p5 = p5;
    this.p6 = p6;
    constructorType=6;
  }
  //Construcotr for 3 pokemons, for a single player
  public PokeClass(Poke p1, Poke p2, Poke p3){
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    constructorType=3;
  }

  /**
 * Takes the attributes from the constructors and puts it in an array
 * @return arr: Array for the class object
 */
  public Poke[] pokeArray(){
    ArrayList<Poke>numbers=new ArrayList<Poke>();
    if (constructorType==6){
      numbers.add(p1);
      numbers.add(p2);
      numbers.add(p3);
      numbers.add(p4);
      numbers.add(p5);
      numbers.add(p6);
      }
    else if(constructorType==3){
      numbers.add(p1);
      numbers.add(p2);
      numbers.add(p3);
    }
    Poke[] arr = new Poke[numbers.size()];
    for(int i=0; i<numbers.size();i++){
      arr[i]=numbers.get(i);
    }
    return arr;
  }


  /**
 * takes array for a player, and the array from the orignal set of pokemons, and computes the pokemons left for the 2nd player
 * @param Poke[] s: The array from the first player
 */
  public Poke[] setFor2ndPlayer(Poke[] s){
    boolean b = true;
    int r=0;
    Poke[] originalSet=pokeArray();
    //System.out.println(originalSet[1]);
    ArrayList<Poke>player2set=new ArrayList<Poke>();
    for(int i=0;i<pokeArray().length;i++){
      b=true;
      for(int j=0;j<s.length;j++){
        if (originalSet[i]==s[j]){
          b = false;
        }
      }
      if (b==true){
        player2set.add(originalSet[i]);
        while(r<3){
          r++;
        }
      }
    }
    Poke[] player2Array = new Poke[player2set.size()];
    for(int i=0; i<player2set.size();i++){
      player2Array[i]=player2set.get(i);
    }
    //System.out.println(player2Array[0]);
    return player2Array;
  }

  //toString() Printing class Object depending on it's constructors and attributes given
  public String toString(){
    String r="";
    if(constructorType==6){ 
      r=("1)"+p1.toString()+"\n2)"+p2.toString()+"\n3)"+p3.toString()+"\n4)"+p4.toString()+"\n5)"+p5.toString()+"\n6)"+p6.toString()+"\n");
      }
      
    else if(constructorType==3){
r=("1)"+p1.toString()+"\n2)"+p2.toString()+"\n3)"+p3.toString()+"\n");
      }
    return r;
    }
 
}
  
  
