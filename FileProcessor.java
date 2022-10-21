import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                Expression cur_express = takeline(line);
                if (cur_express.getOperator().equals("+")) {
                    NumList finlist_add = Calculator.big_add(cur_express.getOperand(), cur_express.getOperand2());
                    System.out.println("= " + NumList.toString(finlist_add));
                }
                else if (cur_express.getOperator().equals("*")) {
                    NumList finlist = Calculator.big_mult(cur_express.getOperand(), cur_express.getOperand2());
                    System.out.println("= " +  NumList.toString(finlist) + "\n");
                }
                else {
                    NumList l = Calculator.big_exp(cur_express.getOperand(), cur_express.getexp());
                    System.out.println("= " + NumList.toString(l));
//                System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    public static Expression takeline(String line) {
        String[] arr = line.split(" ");

        NumList list1 = new NumList();
        NumList list2 = new NumList();
        Expression operator = null;
        boolean bool = false;
        String op = "";
        for (String i : arr) {
            if (i.equals("+") || i.equals("^") || i.equals("*")) {

                bool = true;
                op = i;



            }
            else if(i.equals("")){

            }

            else
                if (!bool)
                    list1.insert(Integer.parseInt(i));
                else
                    list2.insert(Integer.parseInt(i));
        }
        int exp = (list2.getSize() > 0) ? list2.head.data : 0;
        operator = new Expression(list1, list2, op, exp);
        return operator;
    }
}