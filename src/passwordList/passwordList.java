package passwordList;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class passwordList {
    public static void main(String[] args) {

        List<String> keywords = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String filename = "customPasswords.list";
        String keyword;
        String generatedPassword;
        int i = 1;
        int counter = 0;
        int minimumPossibleLength = 6;
        int maximumPossibleLength;

        System.out.println(
                "Create your own password list!\n" +
                        "Enter your keywords then enter \"\\finished\":"
        );

        while (true) { // this will break when user enters \finished as keyword
            System.out.print(i + ": ");
            keyword = input.nextLine();

            if (keyword.equals("")) {
                System.out.println("Please Enter Something!");
                continue;
            } else if (keyword.equals("\\finished")) break;

            i++;

            keywords.add(keyword);
        }

        System.out.print("Please enter the maximum possible length of the password: ");
        while (true) { // this will break when user enters a valid integer!
            try {
                maximumPossibleLength = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Please enter an integer for maximum possible length: ");
            }
        }

        try {
            PrintWriter writer = new PrintWriter(filename, StandardCharsets.UTF_8); // if a file with the same name exists, it'll override the previous file

            for (String firstLoop : keywords) {
                generatedPassword = firstLoop;
                if (generatedPassword.length() >= minimumPossibleLength && generatedPassword.length() <= maximumPossibleLength) {
                    writer.println(generatedPassword);
                    counter++;
                }
            }


            for (String firstLoop : keywords) {
                for (String secondLoop : keywords) {
                    if (!firstLoop.equals(secondLoop)) {
                        generatedPassword = firstLoop + secondLoop;
                        if (generatedPassword.length() >= minimumPossibleLength && generatedPassword.length() <= maximumPossibleLength) {
                            writer.println(generatedPassword);
                            counter++;
                        }
                    }
                }
            }


            for (String firstLoop : keywords) {
                for (String secondLoop : keywords) {
                    for (String thirdLoop : keywords) {
                        if (
                                !firstLoop.equals(secondLoop) &&
                                        !firstLoop.equals(thirdLoop) &&
                                        !secondLoop.equals(thirdLoop)
                        ) {
                            generatedPassword = firstLoop + secondLoop + thirdLoop;
                            if (generatedPassword.length() >= minimumPossibleLength && generatedPassword.length() <= maximumPossibleLength) {
                                writer.println(generatedPassword);
                                counter++;
                            }
                        }
                    }
                }
            }


            for (String firstLoop : keywords) {
                for (String secondLoop : keywords) {
                    for (String thirdLoop : keywords) {
                        for (String forthLoop : keywords) {
                            if (
                                    !firstLoop.equals(secondLoop) &&
                                            !firstLoop.equals(thirdLoop) &&
                                            !firstLoop.equals(forthLoop) &&
                                            !secondLoop.equals(thirdLoop) &&
                                            !secondLoop.equals(forthLoop) &&
                                            !thirdLoop.equals(forthLoop)
                            ) {
                                generatedPassword = firstLoop + secondLoop + thirdLoop + forthLoop;
                                if (generatedPassword.length() >= minimumPossibleLength && generatedPassword.length() <= maximumPossibleLength) {
                                    writer.println(generatedPassword);
                                    counter++;
                                }
                            }
                        }
                    }
                }
            }

            /*
            * If you use less than 10 keywords, it's recommended to uncomment these lines to generate more possible passwords!
            */
//            for (String firstLoop : keywords) {
//                for (String secondLoop : keywords) {
//                    for (String thirdLoop : keywords) {
//                        for (String forthLoop : keywords) {
//                            for (String fifthLoop : keywords) {
//                                if (
//                                        !firstLoop.equals(secondLoop) &&
//                                                !firstLoop.equals(thirdLoop) &&
//                                                !firstLoop.equals(forthLoop) &&
//                                                !firstLoop.equals(fifthLoop) &&
//                                                !secondLoop.equals(thirdLoop) &&
//                                                !secondLoop.equals(forthLoop) &&
//                                                !secondLoop.equals(fifthLoop) &&
//                                                !thirdLoop.equals(forthLoop) &&
//                                                !thirdLoop.equals(fifthLoop) &&
//                                                !forthLoop.equals(fifthLoop)
//                                ) {
//                                    generatedPassword = firstLoop + secondLoop + thirdLoop + forthLoop + fifthLoop;
//                                    if (generatedPassword.length() >= minimumPossibleLength && generatedPassword.length() <= maximumPossibleLength) {
//                                        writer.println(generatedPassword);
//                                        counter++;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }

            writer.close();

            System.out.println("Number of created passwords: " + counter);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
