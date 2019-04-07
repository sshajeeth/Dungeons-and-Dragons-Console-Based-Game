import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Skills {
    private static int proficiency_bonus(int level) {
        int proficiency_bonus = 0;
        if (level <= 4) {
            proficiency_bonus = 2;
        } else if (level <= 8) {
            proficiency_bonus = 3;
        } else if (level <= 12) {
            proficiency_bonus = 4;
        } else if (level <= 16) {
            proficiency_bonus = 5;
        } else {
            proficiency_bonus = 6;
        }
        return proficiency_bonus;
    }

    public static void skillsMethod(int level, int[] bonus, String characterClass, int[] attributes, String[] attributesNames, double bab, double compactAndDamage, double skillPointsAdd, int hitpoints) throws IOException {
        Scanner input = new Scanner(System.in);
        int i = 0;
        double[] rank = new double[level];
        int statAffinity = 0;
        // CharacterClass game = new CharacterClass();

        LinkedList<String> skill = new LinkedList<>();
        int[] numberOfSkills = new int[level];
        String[] selectedSkillsList = new String[level];
        BufferedReader skillsReader = null;
        try {
            skillsReader = new BufferedReader(new FileReader("C:\\Users\\Shajeeth\\Desktop\\CW 02\\src\\Skills.txt"));
            String skillsList;
            do {
                skillsList = skillsReader.readLine();
                skill.add(skillsList);
            } while (skillsList != null);
            System.out.println(skill);
            System.out.println(
                    "Which Skills Do You Want From This Skills? Type the Skill Number and Press the Enter Key");
            for (i = 0; i < level; i++) {
                numberOfSkills[i] = 1;
                numberOfSkills[i] = input.nextInt() - 1;
                selectedSkillsList[i] = (skill.get(numberOfSkills[i]));
                // System.out.println(selectedSkillsList[i]);
                switch (selectedSkillsList[i]) {
                    case "1. Acrobatics":
                        rank[i] += 0.5;
                        statAffinity += bonus[1];
                        if (characterClass.equals("bard") || characterClass.equals("fighter")
                                || characterClass.equals("monk") || characterClass.equals("rougue")) {
                            statAffinity += proficiency_bonus(level);
                            rank[i] += 0.5;
                        }
                        break;
                    case "2. Animal handling":
                        rank[i] += 0.5;
                        statAffinity += bonus[4];
                        if (characterClass.equals("bard") || characterClass.equals("barbarian")
                                || characterClass.equals("druid") || characterClass.equals("fighter")
                                || characterClass.equals("ranger")) {
                            statAffinity += proficiency_bonus(level);
                            rank[i] += 0.5;
                        }
                        break;
                    case "3. Arcana":
                        rank[i] += 0.5;
                        statAffinity += bonus[3];
                        if (characterClass.equals("bard") || characterClass.equals("monk")
                                || characterClass.equals("rougue") || characterClass.equals("ranger")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "4. Athletics":
                        rank[i] += 0.5;
                        statAffinity += bonus[0];
                        if (characterClass.equals("bard") || characterClass.equals("barbarian")
                                || characterClass.equals("fighter") || characterClass.equals("rougue")
                                || characterClass.equals("monk") || characterClass.equals("ranger")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "5. Deception":
                        rank[i] += 0.5;
                        statAffinity += bonus[5];
                        if (characterClass.equals("bard") || characterClass.equals("rougue")
                                || characterClass.equals("sorcerer") || characterClass.equals("warlock")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "6. History":
                        rank[i] += 0.5;
                        statAffinity += bonus[3];
                        if (characterClass.equals("bard") || characterClass.equals("cleric")
                                || characterClass.equals("fighter") || characterClass.equals("monk")
                                || characterClass.equals("wizard") || characterClass.equals("warlock")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "7. Insight":
                        rank[i] += 0.5;
                        statAffinity += bonus[4];
                        if (characterClass.equals("bard") || characterClass.equals("cleric")
                                || characterClass.equals("druid") || characterClass.equals("fighter")
                                || characterClass.equals("rougue") || characterClass.equals("monk")
                                || characterClass.equals("paladin") || characterClass.equals("ranger")
                                || characterClass.equals("sorcerer") || characterClass.equals("wizard")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "8. Intimidation":
                        rank[i] += 0.5;
                        statAffinity += bonus[5];
                        if (characterClass.equals("bard") || characterClass.equals("barbarian")
                                || characterClass.equals("fighter") || characterClass.equals("rougue")
                                || characterClass.equals("paladin") || characterClass.equals("sorcerer")
                                || characterClass.equals("warlock")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "9. Investigation":
                        rank[i] += 0.5;
                        statAffinity += bonus[3];
                        if (characterClass.equals("bard") || characterClass.equals("rougue")
                                || characterClass.equals("ranger") || characterClass.equals("wizard")
                                || characterClass.equals("warlock")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "10. Medicine":
                        rank[i] += 0.5;
                        statAffinity += bonus[4];
                        if (characterClass.equals("bard") || characterClass.equals("cleric")
                                || characterClass.equals("druid") || characterClass.equals("paladin")
                                || characterClass.equals("wizard")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "11. Nature":
                        rank[i] += 0.5;
                        statAffinity += bonus[3];
                        if (characterClass.equals("bard") || characterClass.equals("barbarian")
                                || characterClass.equals("druid") || characterClass.equals("ranger")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "12. Perception":
                        rank[i] += 0.5;
                        statAffinity += bonus[4];
                        if (characterClass.equals("bard") || characterClass.equals("barbarian")
                                || characterClass.equals("druid") || characterClass.equals("fighter")
                                || characterClass.equals("rougue") || characterClass.equals("ranger")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "13. Performance":
                        rank[i] += 0.5;
                        statAffinity += bonus[5];
                        if (characterClass.equals("bard") || characterClass.equals("rougue")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "14. Persuasion":
                        rank[i] += 0.5;
                        statAffinity += bonus[4];
                        if (characterClass.equals("bard") || characterClass.equals("sorcerer")
                                || characterClass.equals("paladin") || characterClass.equals("rougue")
                                || characterClass.equals("cleric")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "15. Religion":
                        rank[i] += 0.5;
                        statAffinity += bonus[3];
                        if (characterClass.equals("bard") || characterClass.equals("cleric")
                                || characterClass.equals("druid") || characterClass.equals("monk")
                                || characterClass.equals("paladin") || characterClass.equals("sorcerer")
                                || characterClass.equals("wizard")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "16. Sleight of hand":
                        rank[i] += 0.5;
                        statAffinity += bonus[1];
                        if (characterClass.equals("bard") || characterClass.equals("rogue")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "17. Stealth":
                        rank[i] += 0.5;
                        statAffinity += bonus[1];
                        if (characterClass.equals("bard") || characterClass.equals("monk")
                                || characterClass.equals("rougue") || characterClass.equals("ranger")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                    case "18. Survival":
                        rank[i] += 0.5;
                        statAffinity += bonus[4];
                        if (characterClass.equals("bard") || characterClass.equals("barbarian")
                                || characterClass.equals("druid") || characterClass.equals("fighter")
                                || characterClass.equals("ranger")) {
                            rank[i] += 0.5;
                            statAffinity += proficiency_bonus(level);
                        }
                        break;
                }

            }
            System.out.println("Level = " + level);

            for (i = 0; i < level; i++) {
                System.out.println("Selected Skills = " + selectedSkillsList[i]);
                System.out.println("Rank = " + rank[i]);
            }
            System.out.println("statAffinity" + "[" + statAffinity + "]");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("Print.txt");
        FileWriter cw2 = new FileWriter(file,true);
        PrintWriter pw = new PrintWriter(cw2,true);
        pw.println("Level = " + level);
        pw.println("Selected Character Class = " + characterClass);
        pw.println("Attribute Names = "+Arrays.toString(attributesNames));
        pw.println("Attribute Scores = "+Arrays.toString(attributes));
        pw.println("Bonus = " + Arrays.toString(bonus));
        pw.println("Hitpoints = " + hitpoints);
        pw.println("Base Attack Points = " + bab);
        pw.println("Skill Points = " + skillPointsAdd);
        pw.println("Selected Skills = " + Arrays.toString(selectedSkillsList) + "Rank = " + Arrays.toString(rank));
        pw.println("State Affinity = " + statAffinity);
    }
}