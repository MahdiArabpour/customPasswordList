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
        String keyword;
        int i = 1;
        int counter = 0;

        System.out.println(
                "Create your own password list!\n" +
                "Enter your keywords then enter \"\\finished\":"
        );

        while(true){ // this will break when user enters \finished as keyword
            System.out.print(i + ": ");
            keyword = input.nextLine();

            if(keyword.equals("")){
                System.out.println("Please Enter Something!");
                continue;
            }
            else if(keyword.equals("\\finished")) break;

            i++;

            keywords.add(keyword);
        }

        try {
            PrintWriter writer = new PrintWriter("customPasswords.list", StandardCharsets.UTF_8);

            for (String first: keywords) {
                writer.println(first);
                counter++;
            }

            for (String firstLoop: keywords) {

                for (String secondLoop: keywords) {
                    if(!firstLoop.equals(secondLoop)) {
                        writer.println(firstLoop + secondLoop);
                        counter++;
                    }
                }
            }


            for (String firstLoop: keywords) {

                for (String secondLoop: keywords) {

                    for (String thirdLoop: keywords) {

                        if(
                                !firstLoop.equals(secondLoop) &&
                                !firstLoop.equals(thirdLoop) &&
                                !secondLoop.equals(thirdLoop)
                        ) {
                            writer.println(firstLoop + secondLoop + thirdLoop);
                            counter++;
                        }
                    }
                }
            }


            for (String firstLoop: keywords) {

                for (String secondLoop: keywords) {

                    for (String thirdLoop: keywords) {

                        for (String forthLoop: keywords) {

                            if(
                                    !firstLoop.equals(secondLoop) &&
                                    !firstLoop.equals(thirdLoop) &&
                                    !firstLoop.equals(forthLoop) &&
                                    !secondLoop.equals(thirdLoop) &&
                                    !secondLoop.equals(forthLoop) &&
                                    !thirdLoop.equals(forthLoop)
                            ) {
                                writer.println(firstLoop+secondLoop+thirdLoop+forthLoop);
                                counter++;
                            }
                        }
                    }
                }
            }

//          for (String firstLoop : keywords) {
//
//              for (String secondLoop : keywords) {
//
//                  for (String thirdLoop : keywords) {
//
//                      for (String forthLoop : keywords) {
//
//                          for (String fifthLoop : keywords) {
//
//                              if(!firstLoop.equals(secondLoop) &&
//                                      !firstLoop.equals(thirdLoop) &&
//                                      !firstLoop.equals(forthLoop) &&
//                                      !firstLoop.equals(fifthLoop) &&
//                                      !secondLoop.equals(thirdLoop) &&
//                                      !secondLoop.equals(forthLoop) &&
//                                      !secondLoop.equals(fifthLoop) &&
//                                      !thirdLoop.equals(forthLoop) &&
//                                      !thirdLoop.equals(fifthLoop) &&
//                                      !forthLoop.equals(fifthLoop)
//                              ) {
//                                  writer.println(firstLoop+secondLoop+thirdLoop+forthLoop+fifthLoop);
//                                  counter++;
//                              }
//                          }
//                      }
//                  }
//              }
//          }
            writer.close();

          System.out.println("Number of created passwords: " + counter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
