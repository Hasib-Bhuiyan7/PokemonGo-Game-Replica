import java.util.*;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int choice1 = 0;
    int choice2 = 0;
    int choice3 = 0;
    int num = 0;
    String lose = "";
    //object instances for Poke class ofr the pokemons
    Poke p1 = new Poke("Pikachu", "Electric", 240, 250);
    Poke p2 = new Poke("Charmeleon", "Fire", 240, 250);
    Poke p3 = new Poke("Blastoise", "Water", 240, 350);
    Poke p4 = new Poke("Dugtrio", "Ground", 300, 350);
    Poke p5 = new Poke("Alakazam", "Psychic", 130, 250);
    Poke p6 = new Poke("Haunter", "Ghost", 120, 250);
    //Original object holding all other pokemon objects; orginal set
    PokeClass pokemonGo = new PokeClass(p1, p2, p3, p4, p5, p6);
    //Comptuing the object's attributes in an array; pokemon in array
    Poke[] set = pokemonGo.pokeArray();
    System.out.println("");
    // System.out.println(pokemonGo);
    System.out.println(
        "Welcome to PokemonGo! Ofcourse this is'nt the real game, but it's  still very fun!\nGo ahead, one of you must choose 3 pokemons from the choices listed:");//intro
    System.out.println(pokemonGo);
    System.out.println("Remember, you cannot pick the same pokemon, more than once!\n");
    System.out.print("Pick your first pokemon:");
    choice1 = in.nextInt();//first pick
    choice1 = limited(6, choice1);//limit and boundaries to picking
    do {
      System.out.print("Pick your second pokemon:");
      choice2 = in.nextInt();
    } while (choice2 == choice1 || choice2 > 6 || choice2 < 1);//2nd pick with it's limit
    do {
      System.out.print("Pick your third pokemon:");
      choice3 = in.nextInt();
    } while (choice3 == choice1 || choice3 == choice2 || choice3 > 6 || choice3 < 1);//third pick with limit
    PokeClass PokePlayer1 = new PokeClass(set[choice1 - 1], set[choice2 - 1], set[choice3 - 1]);//class object holding player 1's pokemons
    System.out.println("\n" + PokePlayer1);//print out
    System.out.println("Nice Pick! Now the unfortunate second player gets the remaining pokemons:");
    Poke[] player1Arr = (PokePlayer1.pokeArray());//array for player 1's pokmon set
    Poke[] player2Arr = (pokemonGo.setFor2ndPlayer(PokePlayer1.pokeArray()));//array for player 2's pokmon set
    PokeClass PokePlayer2 = new PokeClass(player2Arr[0], player2Arr[1], player2Arr[2]);//Player 2's pokemons in an class object
    System.out.println(PokePlayer2);

    System.out.println("Player 2, you go ahead choose your first pokemon to battle with:(1,2,3)");
    int f2choice = in.nextInt();//choosing pokemon to fight with
    f2choice = limited(3, f2choice);
    System.out.println(player2Arr[f2choice - 1]+"\n");
    System.out.println("Next is you player 1, choose your pokemon to battle with:(1,2,3)");
    int f1choice = in.nextInt();//choosing first pokemon to fight with
    f1choice = limited(3, f1choice);
    System.out.println(player1Arr[f1choice - 1]);




    boolean player1stat=true;//boolean for if player loses
    boolean player2stat=true;//boolean for if player loses
    int newChoice = 0;
    System.out.println("\nBEGIN BATTLE");
    while ((player1Arr[0].isAlive() == true && player1Arr[1].isAlive() == true && player1Arr[2].isAlive() == true)
        || (player2Arr[0].isAlive() == true && player2Arr[1].isAlive() == true && player2Arr[2].isAlive() == true)) {
      num++;//round number count
      System.out.println("\nRound " + num);
      System.out.println(player1Arr[f1choice - 1].battleName()+"VS "+player2Arr[f2choice - 1].battleName());//printing battle names; without hp's
      System.out.println("\nPlayer 2, What are you going to do next, \n1-attack, \n2-dodge, \n3-Heal");//3 choices to pick from
      //resetting attack hp's for new round
      player2Arr[f2choice - 1].setAttack(0);
      player1Arr[f1choice - 1].setAttack(0);
      if (player2Arr[0].isAlive() == false && player2Arr[1].isAlive() == false && player2Arr[2].isAlive() == false){
          System.out.println("\nOhh no, i guess you just lost all your pokemons, that means you lose player2");
          player2stat = false;
          break;
        }//if player loses all pokemon than break the code; and player loses
      while (player2Arr[f2choice - 1].isAlive() == false) {
        System.out.println("\nPlayer 2, this pokemon has lost; please pick another pokemon from your set:");
        lose = winner(player1Arr[f1choice - 1], player2Arr[f2choice - 1]);
        System.out.println(PokePlayer2);
        newChoice = in.nextInt();
        newChoice = limited(3, newChoice);
        f2choice = newChoice;
        player1Arr[f1choice - 1].setAttack(0);
      }//if one pokemon lost, than replace that one with a new choice
  
      int actChoice = in.nextInt();
      actChoice = limited(3, actChoice);
      if (actChoice == 1) {
        player2Arr[f2choice - 1].attack(player1Arr[f1choice - 1]);//attack option
      } else if (actChoice == 2) {
        player2Arr[f2choice - 1].dodge(player1Arr[f1choice - 1]);//dodge option
      } else if (actChoice == 3) {
        player2Arr[f2choice - 1].heal();//healing option
      }//Choosing from the 3 choice above


      //Code for player 1 fighting mechanics
      if (player1Arr[0].isAlive() == false && player1Arr[1].isAlive() == false && player1Arr[2].isAlive() == false){
          System.out.println("\nOhh no, i guess you just lost all your pokemons, that means you lose player 1");
          player1stat = false;
          break;
        }//if player loses all pokemon than break the code; and player loses 
      while (player1Arr[f1choice - 1].isAlive() == false) {
        System.out.println("\nPlayer 1, this pokemon has lost; please pick another pokemon from your set:");
        lose = winner(player1Arr[f1choice - 1], player2Arr[f2choice - 1]);
        System.out.println(PokePlayer1);
        newChoice = in.nextInt();
        newChoice = limited(3, newChoice);
        f1choice = newChoice;
        player2Arr[f2choice - 1].setAttack(0);
      }//If 1 pokemon is defeated, than replace it with another alive one
      System.out.println("\nPlayer 1, make your next move:\n1-attack, \n2-dodge, \n3-Heal");
      actChoice = in.nextInt();
      actChoice = limited(3, actChoice);
      if (actChoice == 1) {
        player1Arr[f1choice - 1].attack(player2Arr[f2choice - 1]);//attack option
      } else if (actChoice == 2) {
        player1Arr[f1choice - 1].dodge(player2Arr[f2choice - 1]);//dodge option
      } else if (actChoice == 3) {
        player1Arr[f1choice - 1].heal();//healing option
      }
      System.out.println("\n" + lose + " "+num);//prints out the losers and winners of round
      System.out.println("\n\nAt the moment on the battleground we have:\nPlayer 1:" + player1Arr[f1choice - 1]);//Prints out current pokemons qualifying into a next round
      System.out.println("Player 2:" + player2Arr[f2choice - 1] + "\n\n");


      

    System.out.println("Before next round begins, Player 1, Do you want to replace your pokemon with another from your set?:(1 for yes/2 for no)");//replacing option out of user choice
    int ifReplace = in.nextInt();
    ifReplace = limited(2, ifReplace);
    if (ifReplace == 1) {
      do {
        System.out.println(
            "With which pokemon would you like to replace, your exisitng battle pokemon, Select a pokemon that is not defeated:");
        System.out.println(PokePlayer1);
        int replaceChoice = in.nextInt();
        replaceChoice = limited(3, replaceChoice);
        f1choice = replaceChoice;
      } while (player1Arr[f1choice - 1].isAlive() == false);
    }//if they want to replace, then they pick the choice number, and choose from their pokemons

    System.out.println(
        "Before next round begins, Player 2, Do you want to replace your pokemon with another from your set?:(1 for yes/2 for no)");
    ifReplace = in.nextInt();
    ifReplace = limited(2, ifReplace);
    if (ifReplace == 1) {
      do {
        System.out.println(
            "\nWith which pokemon would you like to replace, your exisitng battle pokemon, Select a pokemon that is not defeated:\n");
        System.out.println(PokePlayer2);
        int replaceChoice = in.nextInt();
        replaceChoice = limited(3, replaceChoice);
        f2choice = replaceChoice;
      } while (player2Arr[f2choice - 1].isAlive() == false);
    }//if they want to replace, then they pick the choice number, and choose from their pokemons
    System.out.println("\nPlayer 2: " + player2Arr[f2choice - 1]);
    System.out.println("Player 1: " + player1Arr[f1choice - 1]);//Print new pokemons fighting
  }
    if(player1stat==false){
      System.out.println("*Winner*\n"+PokePlayer2);
    }//if all pokemons lose for player 1 than: decalare winner
    else if(player2stat==false){
      System.out.println("*Winner*\n"+PokePlayer1);
    }//if all pokemons lose for player 2 than: decalare winner
    System.out.println("Nice game played!, I hope you come back and play again");
  }





  /**
 * Gives a limit, boundary to the numbers the user can choose from, and if choses other numbers, it repeats
 * @param int lim, int choice: lim is the limit given, and choice is the number picken
 * @return choice: Once an appropriate choice is given it reutrns it
 */
  public static int limited(int lim, int choice) {
    Scanner in = new Scanner(System.in);
    while (choice > lim || choice < 1) {
      System.out.println("Please try an appropriate number from the number bounds:");
      choice = in.nextInt();
    }
    return choice;
  }

  /**
 * Prints winner of the battle in the round
 * @param Poke play1, Poke play2: comparing 2 pokemon class objects for winner
 * @return wins: returning string printing the winner and loser
 */
  public static String winner(Poke play1, Poke play2) {
    String wins = "";
    if (play1.isAlive() == false) {
      wins += ("Player 1: " + play1 + " --is defeated; \nPlayer 2: " + play2 + " --wins");
    } else if (play2.isAlive() == false) {
      wins += ("Player 2: " + play2 + " --is defeated; \nPlayer 1: " + play1 + " --wins");
    }
    wins += ("\nThat's it for the round");
    return wins;
  }


}
