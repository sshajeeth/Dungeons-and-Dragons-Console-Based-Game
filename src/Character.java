import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Character {
    public static int levelMethod() {
        Scanner input = new Scanner(System.in);
        int level = 0;
        do {
            System.out.print("Enter the Level: ");
            level = input.nextInt();// Level getting from the user
        } while (!(level > 0 && level < 21));
        return level;
    }

    public static int dicetype2() {// type of a rolling method
        int finalRoll = 0;
        int[] roll = new int[4];
        int min = roll[0];
        int sum = 0;
        for (int i = 0; i < roll.length; i++) {
            roll[i] = (int) ((Math.random() * 1000 % 6 + 1));// random number rolling
            sum += roll[i];
            // finding the minimum value
            if (roll[i] < min) {
                min = roll[i];
            }

            finalRoll = sum - min;// substracting the minimum value from sum

        }
        return finalRoll;

    }

    public static int[] dicerollTxMethod() {// type of a dice roll method
        int i = 0;
        int n = 10;// initializing the n
        int[] finalSum = new int[6];
        int sum = 0;
        for (i = 0; i < 6; i++) {
            --n;// substracting one from the n
            int[] roll = new int[n];
            for (int j = 0; j < n; j++) {
                roll[j] = (int) ((Math.random() * 1000 % 6 + 1));
                sum += roll[j];

            }
            finalSum[i] = sum;// sum is assign to final sum
        }
        return finalSum;
    }

    public static void dicerollMethod(int level, int[] finalSum) throws IOException {// dicroll method
        Scanner input = new Scanner(System.in);
        File file = new File("C:\\Users\\Shajeeth\\Desktop\\CW 02\\src\\Characterclass.txt");
        Scanner sc = new Scanner(file);// character class names reading from the text file
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        System.out.print("Enter your Character Class From This Character Classes: ");
        String characterClass = input.nextLine().toLowerCase();
        // initializing
        int i = 0;
        int hitdice = 0;
        int hitpoints = 0;
        double bab = 0;
        double skillPointsAdd = 0;
        int[] attributes = new int[6];
        int[] bonus = new int[6];
        int[] roll = new int[4];
        int min = 0;
        char option = 0;
        // displaying dice selection option for the user
        System.out.println("What Type of Dice Roll Do you Want?");
        System.out.println("1.Enter the Attributes Directly\n2.Roll 4d6 and discard the lowest value.\n"
                + "3.Roll 4d6 and discard the lowest value and if the attribute is 16 or higher, add the value of an additional 1d6 "
                + "\n4.tRoll Method IX");
        System.out.print("Enter the number of the Dice Type: ");
        String diceroll = input.nextLine();
        System.out.println("[Character Class]" + "[" + characterClass + "]");
        String attributesNames[] = { "[Strength]", "[Dexterity]", "[Consitution]", "[Intelligence]", "[Wisdom]",
                "[Charisma]" };
        do {
            // dice rolling option
            switch (diceroll) {
                case "1":
                    for (i = 0; i < 6; i++) {
                        System.out.print(attributesNames[i] + ":");
                        attributes[i] = input.nextInt();
                        if (attributes[i] > 10) {
                            bonus[i] = (attributes[i] - 10) / 2;
                        } else
                            bonus[i] = (attributes[i] - 11) / 2;
                        System.out.println(attributesNames[i] + "[" + attributes[i] + "]" + "[" + bonus[i] + "]");
                    }
                    break;
                case "2":
                    for (i = 0; i < attributes.length; i++) {
                        attributes[i] = dicetype2();
                        if (attributes[i] > 10) {
                            bonus[i] = (attributes[i] - 10) / 2;
                        } else
                            bonus[i] = (attributes[i] - 11) / 2;
                        System.out.println(attributesNames[i] + "[" + attributes[i] + "]" + "[" + bonus[i] + "]");
                    }
                    break;
                case "3":
                    for (i = 0; i < attributes.length; i++) {
                        System.out.print(attributesNames[i] + ":");
                        attributes[i] = dicetype2();
                        if (attributes[i] >= 16) {
                            attributes[i] += (int) ((Math.random() * 1000 % 6 + 1));
                        }
                        if (attributes[i] > 10) {
                            bonus[i] = (attributes[i] - 10) / 2;
                        } else
                            bonus[i] = (attributes[i] - 11) / 2;
                        System.out.println(attributesNames[i] + "[" + attributes[i] + "]" + "[" + bonus[i] + "]");
                    }
                case "4":
                    for (i = 0; i < attributes.length; i++) {
                        System.out.print(attributesNames[i]);
                        attributes[0] = finalSum[0];
                        attributes[1] = finalSum[1];
                        attributes[2] = finalSum[2];
                        attributes[3] = finalSum[3];
                        attributes[4] = finalSum[4];
                        attributes[5] = finalSum[5];
                        if (attributes[i] > 10) {
                            bonus[i] = (attributes[i] - 10) / 2;
                        } else
                            bonus[i] = (attributes[i] - 11) / 2;
                        System.out.println(attributesNames[i] + "[" + attributes[i] + "]" + "[" + bonus[i] + "]");
                    }
            }
            System.out.println(
                    "If this value is ok then press Letter Y and Enter.\nIf you want to re-roll press any other letter key and Enter.");
            option = input.next().toLowerCase().charAt(0);
        } while (option != 'y');

        switch (characterClass) {
            case "barbarian":
                hitdice = (int) (Math.random() * 1000 % 12 + 1);
                hitpoints = hitdice + bonus[2];
                bab = level;
                skillPointsAdd += 4;
                break;
            case "bard":
                hitdice = (int) (Math.random() * 1000 % 8 + 1);
                hitpoints = hitdice + bonus[2];
                bab = level / 2;
                skillPointsAdd += 6;
                break;
            case "cleric":
                hitdice = (int) (Math.random() * 1000 % 8 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod() / 2;
                skillPointsAdd += 2;
                break;
            case "druid":
                hitdice = (int) (Math.random() * 1000 % 8 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod() / 2;
                skillPointsAdd += 4;
                break;
            case "fighter":
                hitdice = (int) (Math.random() * 1000 % 10 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod();
                skillPointsAdd += 2;
                break;
            case "monk":
                hitdice = (int) (Math.random() * 1000 % 8 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod();
                skillPointsAdd += 4;
                break;
            case "paladin":
                hitdice = (int) (Math.random() * 1000 % 10 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod();
                skillPointsAdd += 2;
                break;
            case "ranger":
                hitdice = (int) (Math.random() * 1000 % 10 + 1);
                hitpoints = hitdice + bonus[2];
                bab = (levelMethod() * 3) / 2;
                skillPointsAdd += 6;
                break;
            case "rougue":
                hitdice = (int) (Math.random() * 1000 % 8 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod() / 2;
                skillPointsAdd += 8;
                break;
            case "sorcerer":
                hitdice = (int) (Math.random() * 1000 % 6 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod() / 2;
                skillPointsAdd += 2;
                break;
            case "warlock":
                hitdice = (int) (Math.random() * 1000 % 8 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod() / 2;
                skillPointsAdd += 2;
                break;
            case "wizard":
                hitdice = (int) (Math.random() * 1000 % 6 + 1);
                hitpoints = hitdice + bonus[2];
                bab = levelMethod() / 2;
                skillPointsAdd += 2;
                break;
            default:
                characterClass = input.nextLine();
                break;
        }
        if (level == 1) {
            skillPointsAdd = (skillPointsAdd + bonus[3]) * 4;
        } else
            skillPointsAdd += bonus[3];
        double compactAndDamage = bab + bonus[0];
        System.out.println("[Hitpoints]" + "[" + hitpoints + "]");
        System.out.println("Base Attack Bonus " + "= " + bab);
        System.out.println("Compact and Damage " + "= " + compactAndDamage);
        System.out.println("Skill Points " + "= " + skillPointsAdd);
        Skills cw2ii = new Skills();
        cw2ii.skillsMethod(level, bonus, characterClass, attributes, attributesNames, bab, compactAndDamage,
                skillPointsAdd, hitpoints);
        Character cw2i = new Character();
        cw2i.dicerollTxMethod();

    }

}
