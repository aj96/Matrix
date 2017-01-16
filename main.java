import java.util.Scanner;
import java.lang.Character;
import java.util.LinkedHashMap;

public class main { 
    /*
    This function checks for valid use of decimal points in the user
    input string. Having more than one decimal point in a number
    is not valid. And having a decimal point without a number
    to the right of the decimal point is not valid. If invalid
    use of decimal point is detected, the function returns false.
    Numbers like ".2" or ".123" are allowed.
    */
    public static boolean validDecimalPoint(String s) {
        int numDecimalPoints = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',' || s.charAt(i) == ' ') {
                numDecimalPoints = 0;
            }
            else {
                if (s.charAt(i) == '.') {
                    numDecimalPoints += 1;
                    if (!Character.isDigit(s.charAt(i+1))) {
                        return false;
                    }
                    if (numDecimalPoints > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
    This function checks if there are any commas next
    to spaces. If there are, it returns false.
    */
    public static boolean noCommaNextToSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == (s.length() - 1)) {
                break; // if at last index, do not check index i+1
            }
            else if (s.charAt(i) == ',' && s.charAt(i+1) == ' ') {
                return false;
            }
            else if (s.charAt(i) == ' ' && s.charAt(i+1) == ',') {
                return false;
            }
        }
        return true;
    }
    /*
    This function checks to make sure that two or
    more commas or not next to each other. If there
    are two or more commas next to each other, the
    function returns false.
    */
    public static boolean onlyOneCommaAtATime(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == (s.length() - 1)) {
                break; // if at last index, do not check index i+1
            }
            else if (s.charAt(i) == ',' && s.charAt(i+1) == ',') {
                return false;
            }
        }
        return true;
    } 

    /*
    This function checks to make sure that two or more
    spaces are not next to each other. If there are two
    or more spaces next to each other, the function returns
    false.
    */
    public static boolean onlyOneSpaceAtATime(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == (s.length() - 1)) {
                break; //If at last index, do not check index i+1
            }
            if (s.charAt(i) == ' ' && s.charAt(i+1) == ' ') {
                return false;
            }
        }
        return true;
    }
    /*
    This function returns an integer that represents
    the number of spaces in a String. This function will 
    be used to determine the number of rows in the matrix.
    Number of Rows = Number of Spaces + 1
    */
    public static int numSpaces(String s) {
        int sum = 0;
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                sum += 1;
            }
        }
        return sum;
    }
    /* This function returns true if all rows 
    are the same length. It will return false otherwise.
    */
    public static boolean allRowsSameLength(String s) {
        int oldRowLength = 0;
        int numCommas = 0;
        int numSpaces = 0;
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                numCommas += 1;
            }
            else if (s.charAt(i) == ' ') {
                numSpaces = numSpaces + 1;
                oldRowLength = numCommas + 1; // Row length of first row
                lastIndex = i;
                break;
            }
        }
        if (numSpaces == 0) {
            System.out.println("No Spaces found. Did you only mean to enter one row? Returning true...");
            return true;
        }
        int newRowLength = 0;
        /*Now that we have the length of the first row,
        Let's continue where we left off, and compare the
        first row's length to the lengths of the other rows
        */
        numCommas = 0;
        for (int i = lastIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                numCommas += 1;
            }
            else if (i == s.length() - 1) {
                newRowLength = numCommas + 1;
                if (oldRowLength != newRowLength) {
                    return false;
                }
            }
            else if (s.charAt(i) == ' ') {
                newRowLength = numCommas + 1;
                if (oldRowLength != newRowLength) {
                    return false;
                }
                else {
                    numCommas = 0;
                }
            }
        }
        return true;
    }
    /*
    This function checks if the final character in 
    the input string is valid. If the final character
    is a comma or a period, the function returns
    false.
    */
    public static boolean validFinalChar(String s) {
        if (s.charAt(s.length() - 1) == ',' || s.charAt(s.length() - 1) == '.') {
            return false;
        }
        return true;
    }
    /*
    This function checks if the initial character in the input
    string is valid. If the initial chracter is a comma, the function
    returns false.
    */
    public static boolean validInitialChar(String s) {
        if (s.charAt(0) == ',') {
            return false;
        }
        return true;
    }
    /*
    This function uses the above valid-input-checking functions
    to check if the input string is valid. If the input string
    is invalid, the function returns false.
    */
    public static boolean validInput(String s) {
        /* This for loop checks if only numbers, decimal points, 
        commas, and spaces are in the input string
        */
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '!' && s.charAt(i) <= '+') || (s.charAt(i) == '-' ) || (s.charAt(i) == '/') || (s.charAt(i) >= ':' && s.charAt(i) <= '@' ) || (s.charAt(i) >= '[' && s.charAt(i) <= '`' || (s.charAt(i) >= '{' && s.charAt(i) <= '~') || Character.isLetter(s.charAt(i))))  {
                System.out.println("Invalid Input: Only numbers, decimal points, commas, and spaces are allowed");
                return false;
            }
        }
        
        if (!onlyOneSpaceAtATime(s)) {
            System.out.println("Invalid Input: Two or more spaces may not be next to each other");
            return false;
        }
         
        if (!onlyOneCommaAtATime(s)) {
            System.out.println("Invalid Input: Two or more commas may not be next to each other");
            return false;
        }

        if (!noCommaNextToSpace(s)) {
            System.out.println("Invalid Input: A comma cannot be next to a space");
            return false;
        }

        if (!validInitialChar(s)) {
            System.out.println("Invalid Input: A decimal point or comma cannot be the initial character");
            return false;
        }

        if (!validFinalChar(s)) {
            System.out.println("Invalid Input: A decimal point or comma cannot be the final character");
            return false;
        }

        if (!validDecimalPoint(s)) {
            System.out.println("Invalid Input: Invalid Use of Decimal Point");
            return false;
        }
        
        if (!allRowsSameLength(s)) {
            System.out.println("Invalid Input: All rows must be the same length");
            return false;
        }

        return true;
    }
    /*
    This function prints a matrix of doubles.
    It was only used for debugging purposes.
    */
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    /*
    This function prints a matrix of Strings.
    */
    public static void printStrMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    /*
    This function returns a LinkedHashMap (dictionary) with Key and Value as type integer.
    The LinkedHashMap's keys represent the index of the column of the number of the matrix,
    not the column of each individual character in the matrix (numbers may be multiple characters
    long and still occupy one number column). The value represents the length of the longest 
    digit in that column.
    
    This function will be used to know how many zeroes to append to the end of numbers to
    make sure that all numbers in each column are of the same length, so that when
    the matrix is printed to the screen, it is neat, pretty, and easy to read.
    */
    public static LinkedHashMap<Integer, Integer> findLongestDigitPerColumn(String[][] matrix) {
        String tempStr = "";
        int tempLength = 0;
        int maxLength = 0;
        LinkedHashMap<Integer, Integer> dict = new LinkedHashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if (i == 0) {
                    tempStr = matrix[i][j];
                    maxLength = tempStr.length();
                    dict.put(j, maxLength);
                }
                else {
                    tempStr = matrix[i][j];
                    tempLength = tempStr.length();
                    if(tempLength > dict.get(j)) {
                        maxLength = tempLength;
                        dict.put(j, maxLength);
                    }

                }
            }
        }
        return dict;
    }
    /*
    This function prints a LinkedHashMap. 
    It was only used for debugging purposes.
    */
    public static void printDict (LinkedHashMap<Integer, Integer> dict) {
        for (int key: dict.keySet()) {
            System.out.println(key + ": " + dict.get(key));
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "";
        boolean invalid = true;
        
        while (invalid) {
            System.out.print("Enter matrix: ");
            input = in.nextLine();
            input = input.trim();
            System.out.println();
            if (validInput(input)) {
                invalid = false;
            }
        } 

        int row = numSpaces(input) + 1;

        int col = 0;
        int numCommas = 0;
        // Finding the number of columns;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                numCommas += 1;
            }
            else if (i == input.length() - 1) {
                col = numCommas + 1;
                break;
            }
            else if (input.charAt(i) == ' ') {
                col = numCommas + 1;
                break;
            }
        } 
        /*
        A matrix of doubles and its values are created, but the matrix is not used.
        A matrix of Strings that represent the numbers is printed to the screen instead.
        This is so that in the future, if I ever wish to perform mathemtical operations 
        on a matrix the user has inputed, I will have the matrix of doubles ready.
        */
        double[][] matrix = new double[row][col];
    
        int rowNum = 0;
        int colNum = 0;
        String tempStr;
        Double tempDouble;     
    
        String[][] matrixStr = new String[row][col];
        int i = 0;
        /*
        This combination of an outer while loop and inner for loops is used
        to create the matrix.
        */
        mainLoop:
        while (i < input.length()) {
            if (i == (input.length() - 1) && Character.isDigit(input.charAt(i)) && input.charAt(i-1) == ',') {
                StringBuilder sb = new StringBuilder();
                sb.append(input.charAt(i));
                tempStr = sb.toString();
                tempDouble = Double.parseDouble(tempStr);
                matrix[rowNum][colNum] = tempDouble;
                if (!tempStr.contains(".")) {
                    tempStr += ".0";
                }
                matrixStr[rowNum][colNum] = tempStr;
                break; //If at final index, do not check index i+1;
            }
            else if (i == (input.length() - 1) && Character.isDigit(input.charAt(i)) && input.charAt(i-1) != ',') {
                break; //If at final index, do not check index i+1;
            }
            else if (input.charAt(i) == '.') {
                StringBuilder sb = new StringBuilder();
                if (i == 0) {
                    sb.append('0');
                }
                else if (!Character.isDigit(input.charAt(i-1))) {
                    sb.append('0');
                }
                sb.append(input.charAt(i));
                //sb.append(input.charAt(i+1));
                for (int j = i+1; j < input.length(); j++) {
                    if (j == input.length() - 1 && Character.isDigit(input.charAt(j))) {
                        sb.append(input.charAt(j));
                        i = j; // This will end the while loop
                        break;
                    }
                    else if (!Character.isDigit(input.charAt(j))) {
                        i = j; //Update while loop index to continue where we left off
                        /* Remember, if a decimal number is the last number in the input,
                        then you will never reach a non-digit character and the loop will
                        go on forever. So you need to above if statement to check for that.
                        */
                        break; //If you've reached a non-digit character, stop appending characters
                    }
                    else {
                        sb.append(input.charAt(j));
                    }
                }
                tempStr = sb.toString();
                tempDouble = Double.parseDouble(tempStr);
                matrix[rowNum][colNum] = tempDouble;
                if (!tempStr.contains(".")) {
                    tempStr += ".0";
                }
                matrixStr[rowNum][colNum] = tempStr;
            }
            else if (Character.isDigit(input.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                sb.append(input.charAt(i));
                for (int j = i + 1; j < input.length(); j++) {
                    if (input.charAt(j) == ',' || input.charAt(j) == ' ') {
                        i = j;
                        break; //If you've reached a non-digit character, stop appending characters
                    }
    
                    else {
                        sb.append(input.charAt(j));
                        /* 
                        Without this if statement below, the input:
                        1,2,3 1,2,333
                        and others like it
                        will cause an infinite loop
                        */
                        if (j == input.length() - 1) {
                            tempStr = sb.toString();
                            tempDouble = Double.parseDouble(tempStr);
                            matrix[rowNum][colNum] = tempDouble;
                            if (!tempStr.contains(".")) {
                                tempStr += ".0";
                            }
                            matrixStr[rowNum][colNum] = tempStr;
                            break mainLoop;
                        }
                    }
                }
                tempStr = sb.toString();
                tempDouble = Double.parseDouble(tempStr);
                matrix[rowNum][colNum] = tempDouble;
                if (!tempStr.contains(".")) {
                    tempStr += ".0";
                }
                matrixStr[rowNum][colNum] = tempStr;
            }

            if (input.charAt(i) == ',') {
                colNum += 1;
                i += 1;
            }
            else if (input.charAt(i) == ' ') {
                colNum = 0;
                rowNum += 1;
                i += 1;
            }
        }        

        LinkedHashMap<Integer, Integer> dict = new LinkedHashMap<>();
        dict = findLongestDigitPerColumn(matrixStr);

        tempDouble = 0.0;
        tempStr = "";
        int tempLength = 0;
        /*
        These two for loops make sure that all numbers in each of the
        columns are of the same length by appending zeroes to the ends
        of the numbers.
        */
        for (i = 0; i < matrixStr.length; i++) {
            for (int j = 0; j < matrixStr[i].length; j++) {
                tempStr = matrixStr[i][j];
                tempLength = tempStr.length();
                /*
                If the if statement below is executed, then an error has occured.
                This if statement was only used for debugging purposes.
                */
                if (tempLength > dict.get(j)) {
                    break;
                }
                while (tempLength != dict.get(j)) {
                    tempStr += "0";
                    tempLength = tempStr.length();
                }
                matrixStr[i][j] = tempStr;
            }
        }
        System.out.println();
        printStrMatrix(matrixStr);
    }
}
