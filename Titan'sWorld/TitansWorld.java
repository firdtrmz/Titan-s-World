import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class TitansWorld {


    public static void main(String[] args) throws IOException {
        SortList<Character> CList = new SortList<Character>();
        DoublyLinkedList<Character> List2 = new DoublyLinkedList<Character>();
        FileWriter out = new FileWriter("Eren's Allies.txt", true);
        PrintWriter outFile = new PrintWriter(out);
        DoublyLinkedList<String> listchar = new DoublyLinkedList<String>();
        DoublyLinkedList<Character> list = new DoublyLinkedList<Character>();
        Scanner scanplay = new Scanner(System.in);
        boolean PlayAgain = true;

     Titan:
     while(PlayAgain) {
         System.out.println("Do you want to play the game?");
         System.out.println("A: Soldiers Arrangements and Grouping\nB: Titan Evaluation and Killing Priority\nC: Scouting Mission inside the Wall\nD: Best Path to Kill Titan\nE: Marley Word Converter\nF: Protecting Wall of Maria\n");
         System.out.print("Choose your game: ");
         String play = scanplay.nextLine();

         switch (play) {
             case "A": {
//                Scanner sc = new Scanner(System.in);
                 System.out.println("------Eren's Allies------");
                 System.out.println("");
                 while (true) {
                     System.out.println("");

                     System.out.println("Do you want to enter allies?");
                     String input = scanplay.nextLine();

                     if (input.equalsIgnoreCase("yes")) {
                         int i = 0;
                         System.out.println("\nName (name and surname): ");
                         String name = scanplay.nextLine();

                         System.out.println("Enter Character (height, weight, strength, agility, intelligence, coordination, leadership) : ");
                         String input1 = scanplay.nextLine();
                         int i2 = 0;
                         //to split the Character and store into listchar

                         for (String s : input1.split(" ")) {

                             i2++;
                             listchar.add(i2, s);

                         }

                         //listchar.iterateForward();
                         System.out.println("");
                         //remove the Character in listchar and assign to the string Character
                         String height = listchar.remove(0);
                         String weight = listchar.remove(0);
                         String strength = listchar.remove(0);
                         String agility = listchar.remove(0);
                         String intel = listchar.remove(0);
                         String coor = listchar.remove(0);
                         String lead = listchar.remove(0);

                         //add the Character to a new object
                         Character character = new Character(name, height, weight, strength, agility, intel, coor, lead);
                         //add the object to the list
                         list.add(i, character);
                         //character.remove(name, height, weight, strength, agility, intel, coor, lead);
                         outFile.print(name);
                         outFile.print(" " + height);
                         outFile.print(" " + weight);
                         outFile.print(" " + strength);
                         outFile.print(" " + agility);
                         outFile.print(" " + intel);
                         outFile.print(" " + coor);
                         outFile.print(" " + lead);
                         outFile.println();
                         list.clear();
                         i++;
                         continue;
                     }

                     outFile.close();
                     if (!input.equalsIgnoreCase("yes")) {
                         break;
                     }

                 }
                 //list.clear();

                 System.out.println("");
                 System.out.println("------Soldiers Available------");
                 try {

                     //File myObj = new File("filename.txt");
                     FileReader fr = new FileReader("Eren's Allies.txt");
                     Scanner myReader = new Scanner(fr);
                     while (myReader.hasNextLine()) {
                         String data = null;
                         data = myReader.nextLine();

                         int i2 = 0;
                         int i = 0;
                         listchar.clear();
                         //System.out.println(data);

                         for (String s : data.split(" ")) {


                             listchar.add(i, s);
                             i++;


                         }
                         String name = listchar.remove(0) + " " + listchar.remove(0);

                         String height = listchar.remove(0);
                         String weight = listchar.remove(0);
                         String strength = listchar.remove(0);
                         String agility = listchar.remove(0);
                         String intel = listchar.remove(0);
                         String coor = listchar.remove(0);
                         String lead = listchar.remove(0);
                         Character character = new Character(name, height, weight, strength, agility, intel, coor, lead);
                         list.add(i2, character);


                     }
                     myReader.close();
                 } catch (FileNotFoundException e) {
                     System.out.println("An error occurred.");
                     e.printStackTrace();

                 }

                 while (true) {

                     List2.clear();
                     CList.clear();

                     System.out.println("");
                     System.out.print("Do you want to sort attribute? : ");
                     String input1 = scanplay.nextLine();
                     if (input1.equalsIgnoreCase("yes")) {
                         System.out.print("\nSorting attribute: ");
                         String attribute = scanplay.nextLine();
                         System.out.println("");
                         System.out.println("Sorting from highest to lowest : \n");
                         switch (attribute) {
                             case "height":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getHeight());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getHeight())) {
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             case "weight":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getWeight());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getWeight())) {
                                             //String printed = "";
                                             //System.out.println(list.show(j));
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             case "strength":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getStrength());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getStrength())) {
                                             //String printed = "";
                                             //System.out.println(list.show(j));
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             case "agility":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getAgility());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getAgility())) {
                                             //String printed = "";
                                             //System.out.println(list.show(j));
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             case "intelligence":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getIntel());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getIntel())) {
                                             //String printed = "";
                                             //System.out.println(list.show(j));
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             case "coordination":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getCoor());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getCoor())) {
                                             //String printed = "";
                                             //System.out.println(list.show(j));
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             case "leadership":
                                 for (int k = 0; k < list.size(); k++) {
                                     int height = Integer.parseInt(list.show(k).getLead());
                                     CList.addNode(height);
                                 }
                                 CList.sortList();
                                 //CList.display();
                                 for (int i = 0; i < list.size(); i++) {
                                     for (int j = 0; j < list.size(); j++) {
                                         if (CList.show(i) == Integer.parseInt(list.show(j).getLead())) {
                                             //String printed = "";
                                             //System.out.println(list.show(j));
                                             if (!List2.contains(list.show(j))) {
                                                 System.out.println(list.show(j).getName() + " " + CList.show(i));

                                                 List2.add(0, list.show(j));
                                             }

                                         }


                                     }
                                 }

                                 break;
                             default:
                                 System.out.print("Attribute not found.");

                         }

                         //System.out.println("");
                         continue;
                     }
                     if (!input1.equalsIgnoreCase("yes")) {
                         break;
                     }
                 }

                 //System.out.print("Do you want to search for ability? : ");
                 //String input1 = sc.nextLine();
                 while (true) {
                     List2.clear();
                     System.out.println("");
                     System.out.print("Do you want to search for ability? : ");
                     String input1 = scanplay.nextLine();
                     if (input1.equalsIgnoreCase("yes")) {

                         System.out.print("Finding ability : ");
                         String ability = scanplay.nextLine();
                         System.out.print("Value: ");
                         String valueAbility = scanplay.nextLine();
                         System.out.println("");

                         switch (ability) {
                             case "height":
                                 System.out.println("Soldier: ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getHeight().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             case "weight":
                                 System.out.println("Soldier: ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getWeight().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             case "strength":
                                 System.out.println("Soldier: ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getStrength().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             case "agility":
                                 System.out.println("Soldier: ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getAgility().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             case "intelligence":
                                 System.out.println("Soldier : ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getIntel().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             case "coordination":
                                 System.out.println("Soldier : ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getCoor().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             case "Leadership":
                                 System.out.println("Soldier : ");
                                 for (int i = 0; i < list.size(); i++) {
                                     if (list.show(i).getLead().equalsIgnoreCase(valueAbility)) {
                                         System.out.print(list.show(i).getName() + ", ");
                                         List2.add(0, list.show(i));
                                     }
                                 }
                                 if (List2.isEmpty())
                                     System.out.println("Value not found.");
                                 break;
                             default:
                                 System.out.print("Ability not found.");
                         }
                         System.out.println("");
                         continue;
                     }
                     if (!input1.equalsIgnoreCase("yes")) {
                         break;
                     }
                 }
                 //scanplay.close();
                 System.out.println();
             }
             continue Titan;

             case "B": {
                 System.out.println("------Titan Evaluation and Killing Priority------");
                 System.out.println();

                 DoublyLinkedListEV<TitanTag> CheckList = new DoublyLinkedListEV<TitanTag>();
                 NormalTitan a = new NormalTitan();
                 Random t = new Random();
                 int num = t.nextInt(10) + 1;
                 System.out.println("Number of Titans: " + num);
                 System.out.println();
                 System.out.println("Generating " + num + " Titans ....");
                 int risk = 0;
                 java.util.PriorityQueue<Integer> q = new java.util.PriorityQueue<>();
                 for (int d = 1; d <= num; d++) {
                     Titan s = new Titan();
                     String[] o = {"Normal Titan", "Abnormal Titan", "Nine Titan"};
                     Random r = new Random();
                     int randomNumber = r.nextInt(o.length);
                     //to find normal Titan's risk with specific characteristic
                     if (randomNumber == 0) {
                         if (a.Height() > 20) {//3
                             if (a.WalkingLegs() == 4) {//3
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 15;//3+3+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 13;//3+3+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 14;//3+3+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 12;//3+3+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//3+3+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//3+3+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 14;//3+3+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 12;//3+3+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//3+3+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//3+3+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+3+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+3+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//3+3+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//3+3+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+3+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+3+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//3+3+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+3+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             } else if (a.WalkingLegs() == 2) {//2
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 14;//3+2+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 12;//3+2+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//3+2+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//3+2+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+2+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+2+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//3+2+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//3+2+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+2+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+2+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//3+2+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+2+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+2+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+2+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//3+2+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+2+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//3+2+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+2+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             } else {//1
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//3+1+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//3+1+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+1+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+1+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//3+1+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+1+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//3+1+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//3+1+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//3+1+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+1+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//3+1+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//3+1+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//3+1+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//3+1+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//3+1+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//3+1+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//3+1+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//3+1+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             }

                         } else if (a.Height() > 10) {//2
                             if (a.WalkingLegs() == 4) {//3
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 14;//2+3+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 12;//2+3+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//2+3+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//2+3+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//2+3+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//2+3+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//2+3+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//2+3+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//2+3+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//2+3+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+3+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+3+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//2+3+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//2+3+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+3+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+3+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//2+3+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//2+3+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             } else if (a.WalkingLegs() == 2) {//2
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//2+2+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//2+2+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//2+2+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//2+2+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+2+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+2+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//2+2+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//2+2+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+2+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+2+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//2+2+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//2+2+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+2+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+2+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//2+2+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//2+2+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//2+2+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//2+2+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             } else {//1
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//2+1+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//2+1+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+1+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+1+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//2+1+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//2+1+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//2+1+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//2+1+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//2+1+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//2+1+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//2+1+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//2+1+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//2+1+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//2+1+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//2+1+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//2+1+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 8;//2+1+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 6;//2+1+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             }
                         } else {//1
                             if (a.WalkingLegs() == 4) {//3
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 13;//1+3+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 11;//1+3+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//1+3+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//1+3+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//1+3+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//1+3+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//1+3+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//1+3+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//1+3+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//1+3+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+3+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+3+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//1+3+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//1+3+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+3+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+3+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//1+3+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//1+3+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             } else if (a.WalkingLegs() == 2) {//2
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 12;//1+2+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 10;//1+2+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//1+2+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//1+2+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+2+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+2+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//1+2+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//1+2+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+2+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+2+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//1+2+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//1+2+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+2+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+2+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//1+2+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//1+2+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 8;//1+2+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 6;//1+2+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             } else {//1
                                 if (a.Speed() > 20) {//3
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 11;//1+1+3+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 9;//1+1+3+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+1+3+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+1+3+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//1+1+3+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//1+1+3+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else if (a.Speed() > 10) {//2
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 10;//1+1+2+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 8;//1+1+2+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//1+1+2+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//1+1+2+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 8;//1+1+2+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 6;//1+1+2+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 } else {//1
                                     if ("Not repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//3
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 9;//1+1+1+3+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 7;//1+1+1+3+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else if ("Repeated pattern".equalsIgnoreCase(a.WalkingPattern())) {//2
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 8;//1+1+1+2+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 6;//1+1+1+2+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     } else {//1
                                         if ("Can climb".equalsIgnoreCase(a.ClimbingSkill())) {
                                             risk = 7;//1+1+1+1+3
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         } else {
                                             risk = 5;//1+1+1+1+1
                                             q.offer(risk);
                                             System.out.println("Titan " + d + ": Normal Titan (" + a.Height() + "m, " + a.WalkingLegs() + " legs, " + a.Speed() + "ms, " + a.WalkingPattern() + ", " + a.ClimbingSkill() + ") Risk " + risk);
                                         }
                                     }
                                 }
                             }
                         }

                     } else if (randomNumber == 1) {
                         System.out.println("Titan " + d + ": Abnormal Titan Risk 15");
                         risk = 15;
                         q.offer(s.AbnormalTitan());
                     } else {
                         Random k = new Random();
                         int i = k.nextInt(7);
                         s.NineTitan();
                         q.offer(s.NineTitan());
                         switch (i) {
                             case 0:
                                 System.out.println("Titan " + d + ": Nine Titan (Beast Titan) Risk 19");
                                 break;
                             case 1:
                                 System.out.println("Titan " + d + ": Nine Titan (Jaw Titan) Risk 19");
                                 break;
                             case 2:
                                 System.out.println("Titan " + d + ": Nine Titan (Collosal Titan) Risk 19");
                                 break;
                             case 3:
                                 System.out.println("Titan " + d + ": Nine Titan (Armoured Titan) Risk 19");
                                 break;
                             case 4:
                                 System.out.println("Titan " + d + ": Nine Titan (War Hammer Titan) Risk 19");
                                 break;
                             case 5:
                                 System.out.println("Titan " + d + ": Nine Titan (Cart Titan) Risk 19");
                                 break;
                             case 6:
                                 System.out.println("Titan " + d + ": Nine Titan (Female Titan) Risk 19");
                                 break;
                         }
                         risk = 19;
                     }
                     TitanTag ti = new TitanTag(d, risk);
                     CheckList.addLast(ti);
                 }
                 System.out.print("Sequence to be killed : ");
                 //while(!CheckList.isEmpty())
                 //System.out.println(CheckList.removeFirst().toString());
                 while (!q.isEmpty()) {
                     Integer r = q.poll();
                     for (int i = 0; i < CheckList.size(); i++) {
                         //Integer r =q.poll();
                         if (r.equals(CheckList.show(i).getRisk())) {
                             System.out.print(CheckList.remove(i));
                             if (!CheckList.isEmpty())
                                 System.out.print(" --> ");
                             else
                                 System.out.println("");
                             //continue;
                         }
                     }
                 }

                 System.out.println();

             }
             continue Titan;

             case "C": {
                 System.out.println("------Scouting Mission inside the Wall------");
                 System.out.println();


                 System.out.print("Enter starting point : ");
                 int startingPoint = scanplay.nextInt();

                 ScoutingClass scoutClass = new ScoutingClass();

                 int[][] paradisMap = {
                         {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},// 0
                         {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 1
                         {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},// 2
                         {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},// 3
                         {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},// 4
                         {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},// 5
                         {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},// 6
                         {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},// 7
                         {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},// 8
                         {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},// 9
                         {0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},// 10
                         {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},// 11
                         {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},// 12
                         {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},// 13
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},// 14
                         {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},// 15
                 };

                 for (int i = 0; i < paradisMap.length; i++) {
                     for (int j = 0; j < paradisMap.length; j++) {
                         System.out.print(paradisMap[i][j] + " ");
                     }
                     System.out.println();
                 }
                 scoutClass.hamiltonianCycle(paradisMap, startingPoint);
                 //scan.close();

                 System.out.println();

             }
             continue Titan;

             case "D": {
                 System.out.println("------Best Path to Kill Titan------");
                 System.out.println();

                 //Number of vertices
                 int vertices = 16;

                 ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
                 for (int i = 0; i < vertices; i++) {
                     adjacent.add(new ArrayList<>());
                 }

                 BestPathToKillTitan path = new BestPathToKillTitan();
                 //Given graph in the question
                 path.addEdge(adjacent, 0, 1);
                 path.addEdge(adjacent, 0, 5);
                 path.addEdge(adjacent, 0, 7);
                 path.addEdge(adjacent, 1, 2);
                 path.addEdge(adjacent, 1, 4);
                 path.addEdge(adjacent, 1, 6);
                 path.addEdge(adjacent, 2, 3);
                 path.addEdge(adjacent, 2, 11);
                 path.addEdge(adjacent, 2, 13);
                 path.addEdge(adjacent, 3, 10);
                 path.addEdge(adjacent, 4, 6);
                 path.addEdge(adjacent, 4, 10);
                 path.addEdge(adjacent, 5, 6);
                 path.addEdge(adjacent, 5, 7);
                 path.addEdge(adjacent, 5, 12);
                 path.addEdge(adjacent, 6, 8);
                 path.addEdge(adjacent, 6, 15);
                 path.addEdge(adjacent, 7, 9);
                 path.addEdge(adjacent, 8, 10);
                 path.addEdge(adjacent, 9, 12);
                 path.addEdge(adjacent, 9, 15);
                 path.addEdge(adjacent, 10, 14);
                 path.addEdge(adjacent, 11, 13);
                 path.addEdge(adjacent, 13, 14);
                 path.addEdge(adjacent, 14, 15);

                 //Enter source and destination
                 //           Scanner scanpath = new Scanner(System.in);
                 System.out.print("Enter source: ");
                 int source = scanplay.nextInt();

                 System.out.print("Enter destination: ");
                 int destination = scanplay.nextInt();


                 //Function call
                 System.out.println();
                 System.out.println("The best path: ");
                 path.printPaths(adjacent, vertices, source, destination);
                 //scanplay.close();
                 System.out.println();
             }
             continue Titan;

             case "E": {
                 System.out.println("------Marley Word Converter------");
                 System.out.println();

                 //Scanner scanner = new Scanner(System.in);//create scanner
                 System.out.print("Enter Marley Sentence :\t");
                 String marleysc = scanplay.next();//create scanner nextline

                 String temp = "";//another bekas


                 CustomHashMap<java.lang.Character, java.lang.Character> marley = new CustomHashMap<>();

                 marley.put('a', 'j');
                 marley.put('b', 'c');
                 marley.put('c', 't');
                 marley.put('d', 'a');
                 marley.put('e', 'k');
                 marley.put('f', 'z');
                 marley.put('g', 'x');
                 marley.put('h', 'i');
                 marley.put('i', 'w');
                 marley.put('j', 'x');
                 marley.put('k', 'o');
                 marley.put('l', 'n');
                 marley.put('m', 'g');
                 marley.put('n', 'b');
                 marley.put('o', 'f');
                 marley.put('p', 'h');
                 marley.put('q', 'l');
                 marley.put('r', 'd');
                 marley.put('s', 'e');
                 marley.put('t', 'y');
                 marley.put('u', 'm');
                 marley.put('v', 'v');
                 marley.put('w', 'u');
                 marley.put('x', 'p');
                 marley.put('y', 'q');
                 marley.put('z', 'r');
                 marley.put('$', ' ');
                 marley.put(',', ',');

                 MarleyWordConverter changemarley = new MarleyWordConverter();

                 String jadi = changemarley.reverseParentheses(marleysc, marleysc.length());
                 //System.out.println(jadi);

                 for (int j = 0; j < jadi.length(); j++) {
                     char translated = marley.get(jadi.charAt(j));
                     temp += translated;
                 }
                 System.out.println(temp);
                 //scanplay.close();
                 System.out.println();

             }
             continue Titan;

             case "F": {
                 System.out.println("------Protecting Wall of Maria------");
                 System.out.println();

                 System.out.println("Scanning Weakest part of Wall Maria....\n\n\n");

                 WallOfMaria wall = new WallOfMaria();

                 List<List<Integer>> layer = new ArrayList<>();
                 List<Integer> brick1 = new ArrayList<>();
                 List<Integer> brick2 = new ArrayList<>();
                 ArrayList<Integer> arr = new ArrayList<>();

                 brick1.add(1);
                 brick1.add(2);
                 brick1.add(3);
                 layer.add(brick1);
                 brick2.add(2);
                 brick2.add(5);
                 layer.add(brick2);
                 int i = 0;

                 arr = wall.ConvertToOneList(layer);
                 int test = wall.mostFrequentArrayList(arr, arr.size());
                 System.out.println("Weakest part of Wall Maria is " + test + " part");
                 System.out.println();

             }
             continue Titan;

             default: {
                 System.out.println("Thank you for playing!");
                 break;
             }
         }
     }




    }
}
