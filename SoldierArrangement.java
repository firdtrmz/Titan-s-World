import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class SoldierArrangement {
    public static void main(String[] args) throws IOException {
        SortList<Character> CList = new SortList<Character>();
        DoublyLinkedList<Character> List2 = new DoublyLinkedList<Character>();
        FileWriter out = new FileWriter("Eren's Allies.txt",true);
        PrintWriter outFile = new PrintWriter(out);
        DoublyLinkedList<String> listchar = new DoublyLinkedList<String>();
        DoublyLinkedList<Character> list = new DoublyLinkedList<Character>();
        Scanner sc = new Scanner(System.in);
        System.out.println("------Eren's Allies------");
        System.out.println("");
        while (true) {
            System.out.println("");

            System.out.println("Do you want to enter allies?");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                int i = 0;
                System.out.println("\nName (name and surname): ");
                String name = sc.nextLine();

                System.out.println("Enter Character (height, weight, strength, agility, intelligence, coordination, leadership) : ");
                String input1 = sc.nextLine();
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
                outFile.print(" "+height);
                outFile.print(" "+weight);
                outFile.print(" "+strength);
                outFile.print(" "+agility);
                outFile.print(" " +intel);
                outFile.print(" "+coor);
                outFile.print(" " +lead);
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
                int i= 0;
                listchar.clear();
                //System.out.println(data);

                for (String s : data.split(" ")) {


                    listchar.add(i, s);
                    i++;


                }
                String name = listchar.remove(0)+ " " + listchar.remove(0);

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
            String input1 = sc.nextLine();
            if (input1.equalsIgnoreCase("yes")) {
                System.out.print("\nSorting attribute: ");
                String attribute = sc.nextLine();
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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getHeight())){
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getWeight())){
                                    //String printed = "";
                                    //System.out.println(list.show(j));
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getStrength())){
                                    //String printed = "";
                                    //System.out.println(list.show(j));
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getAgility())){
                                    //String printed = "";
                                    //System.out.println(list.show(j));
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getIntel())){
                                    //String printed = "";
                                    //System.out.println(list.show(j));
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getCoor())){
                                    //String printed = "";
                                    //System.out.println(list.show(j));
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
                            for (int j = 0; j < list.size(); j++){
                                if(CList.show(i)==Integer.parseInt(list.show(j).getLead())){
                                    //String printed = "";
                                    //System.out.println(list.show(j));
                                    if(!List2.contains(list.show(j))){
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0,list.show(j));}

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
            String input1 = sc.nextLine();
            if (input1.equalsIgnoreCase("yes")) {

                System.out.print("Finding ability : ");
                String ability = sc.nextLine();
                System.out.print("Value: ");
                String valueAbility = sc.nextLine();
                System.out.println("");

                switch (ability) {
                    case "height":
                        System.out.println("Soldier: ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getHeight().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
                            System.out.println("Value not found.");
                        break;
                    case "weight":
                        System.out.println("Soldier: ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getWeight().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
                            System.out.println("Value not found.");
                        break;
                    case "strength":
                        System.out.println("Soldier: ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getStrength().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
                            System.out.println("Value not found.");
                        break;
                    case "agility":
                        System.out.println("Soldier: ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getAgility().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
                            System.out.println("Value not found.");
                        break;
                    case "intelligence":
                        System.out.println("Soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getIntel().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
                            System.out.println("Value not found.");
                        break;
                    case "coordination":
                        System.out.println("Soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getCoor().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
                            System.out.println("Value not found.");
                        break;
                    case "Leadership":
                        System.out.println("Soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getLead().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0,list.show(i));
                            }
                        }
                        if(List2.isEmpty())
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
    }

}