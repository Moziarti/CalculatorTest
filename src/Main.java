import java.util.Scanner;

public class Main {

    // Конвертер арабских чисел в римские
    static String convertToRoman(int arabianNum) {
        StringBuilder result = new StringBuilder();
        for (Converter c : Converter.values()) {
            while (arabianNum >= c.arabianNum) {
                int d = arabianNum / c.arabianNum;
                arabianNum = arabianNum % c.arabianNum;
                for(int i = 0; i < d; i++) {
                    result.append(c.romanNum);
                }
            }
        }
        return result.toString();
    }
    public static String calc(String input) {
        String num1 = "", num2 = "";
        int a = 0, b = 0;
        char oper = ' ';
        boolean isArabian = false;
        String result = "";
           //Обрабатываем введенное пользователем арифметической выражение
           for(int i = 0; i < input.length(); i++) {
               if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                   oper = input.charAt(i);
                   int j = i;
                   for(i = 0; i < j ; i++) {
                       num1 += input.charAt(i);
                   }
                   for(j++; j < input.length(); j++) {
                           num2 += input.charAt(j);
                   }
                   break;
               }
           }
           //Удаляем все пробелы
           num1.replaceAll("\\s","");
           num1.replaceAll("\\s","");

           //Пытаемся записать первое число из string в int
           try {
               if(Integer.parseInt(num1) >= 1 && Integer.parseInt(num1) <= 10) {
                   a = Integer.parseInt(num1);
                   isArabian = true;
               }
               else {
                   return result = "Калькулятор принимает числа только от 1 до 10!";
               }
           }
           //Если не получилось, то пытаемся найти римское число в enum и переводим его в арабское
           catch (NumberFormatException nfe) {
               for(Converter c : Converter.values()) {
                   if(c.getRomanNum().equalsIgnoreCase(num1)) {
                       if(c.getArabianNum() >= 1 && c.getArabianNum() <=10) {
                           a = c.getArabianNum();
                       }
                       else {
                           return result = "Калькулятор примает числа только от 1 до 10!";
                       }
                       break;
                   }
               }
           }
           //Если пользователь ввел отсебятину кидаем исключение
           finally {
               if(a == 0) {
                   throw new NumberFormatException("Неверный формат данных!");
               }
           }
           //Проверяем не пытаеся ли пользователь сложить числа из разных систем счисления
           if(isArabian == true)
           {
               //Пытаемся записать второе число из string в int
               try {
                   if(Integer.parseInt(num2) >= 1 && Integer.parseInt(num2) <= 10) {
                       b = Integer.parseInt(num2);
                   }
                   else {
                       return result = "Калькулятор принимает числа только от 1 до 10!";
                   }
               }
               catch (NumberFormatException nfe) {
                   throw new NumberFormatException("Неверный формат данных!");
               }
           }
           //Если не получилось, то пытаемся найти римское число в enum и переводим его в арабское
           else {
               for(Converter c : Converter.values()) {
                   if(c.getRomanNum().equalsIgnoreCase(num2)) {
                       if(c.getArabianNum() >= 1 && c.getArabianNum() <= 10) {
                           b = c.getArabianNum();
                           break;
                       }
                       else {
                           return result = "Калькулятор принимает числла только от 1 до 10!";
                       }
                   }
               }
               //Если пользователь ввел отсебятину кидаем исключение
               if (b == 0)
               {
                   return result = "Неверный формат данных!";
               }
           }

           //Решаем введенный пользователем арифметическое выражение
           switch (oper) {
               case '+':
                   result = String.valueOf(a+b);
                   break;
               case '-':
                   result = String.valueOf(a-b);
                   break;
               case '*':
                   result = String.valueOf(a*b);
                   break;
               case '/':
                   result = String.valueOf(a/b);
                   break;
               default:
                   return result = "Неверный формат данных!";
           }

           //Если ариф. выражение было в арабской системе счисления выводим результат
           if(isArabian == true){
               return result;
           }
           //Иначе конвертируем результат в римскую систему счисления и выводим
           else {
               if(Integer.parseInt(result) <= 0) {
                   result = "В римской системе счисления нет отрицательных чисел!";
               }
               else {
                   return result = convertToRoman(Integer.parseInt(result));
               }
           }
           return result;
    }
    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение:");
        Scanner enteredData = new Scanner(System.in);
        String arithmeticExpression = enteredData.nextLine();
        System.out.println(calc(arithmeticExpression));

    }
}