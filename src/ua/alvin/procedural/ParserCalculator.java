package ua.alvin.procedural;

public class ParserCalculator {
    public static void main(String[] args) {
        System.out.println(evaluate("1 23"));
        System.out.println(evaluate("2*3"));
        System.out.println(evaluate("2*(1 +3)"));
        System.out.println(evaluate("1+(5-2*(13/6))"));
        System.out.println(evaluate1("(1+3)*2"));
        System.out.println(evaluate1("((13/6)*2-5)+1"));
    }

    static double evaluate(String inputExpr){
        String expr = inputExpr.replace(" ", "");
        if (expr.startsWith("(") && expr.endsWith(")")) {
            return evaluate(expr.substring(1, expr.length() - 1));
        } else if (expr.startsWith("(") && !expr.endsWith(")")) {
            throw new RuntimeException("If expr starts with \"(\" than...");
        } else {
            int pos = 0;
            while (pos < expr.length() - 1) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    double leftOperand = Integer.parseInt(expr.substring(0, pos));
                    char operation = expr.charAt(pos);
                    double rightOperand = evaluate(expr.substring(pos + 1));
                    switch (operation) {
                        case '+' : return leftOperand + rightOperand;
                        case '-' : return leftOperand - rightOperand;
                        case '*' : return leftOperand * rightOperand;
                        case '/' : return leftOperand / rightOperand;
                        default : throw new IllegalArgumentException("Not math operator");
                    }
                }
            }
            return Double.parseDouble(expr);
        }
    }

    /*FIXME DOES NOT WORK*/
    static double evaluate1(String inputExpr){
        String expr = inputExpr.replace(" ", "");
        if (expr.startsWith("(") && !expr.endsWith(")")) {
            int pos = 0;
            int barrier = 0;

            for (int i = 0; i < expr.length(); i++) {
                if (expr.charAt(pos) == '(') {
                    pos++;
                } else if (expr.charAt(pos) == ')'){
                    pos--;
                }
                barrier++;
            }

            char operation = expr.charAt(pos+1);
            switch (operation) {
                case '+' : return evaluate1(expr.substring(1, barrier)) + evaluate1(expr.substring(barrier));
                case '-' : return evaluate1(expr.substring(1, barrier)) - evaluate1(expr.substring(barrier));
                case '*' : return evaluate1(expr.substring(1, barrier)) * evaluate1(expr.substring(barrier));
                case '/' : return evaluate1(expr.substring(1, barrier)) / evaluate1(expr.substring(barrier));
                default : throw new IllegalArgumentException("Not math operator");
            }

//            return evaluate1(expr.substring(1, pos)) ;
        } else if (!expr.startsWith("(") && expr.endsWith(")")) {
            throw new RuntimeException("If expr starts with \"(\" than...");
        } else {
            int pos = 0;
            while (pos < expr.length() - 1) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    double leftOperand = Integer.parseInt(expr.substring(0, pos));
                    char operation = expr.charAt(pos);
//                    double rightOperand = Integer.parseInt(expr.substring(pos, expr.length() + 1));
                    double rightOperand = Integer.parseInt(expr.substring(pos + 1));
                    switch (operation) {
                        case '+' : return leftOperand + rightOperand;
                        case '-' : return leftOperand - rightOperand;
                        case '*' : return leftOperand * rightOperand;
                        case '/' : return leftOperand / rightOperand;
                        default : throw new IllegalArgumentException("Not math operator");
                    }
                }
            }
            return Double.parseDouble(expr);
        }
    }
}
