enum Converter {
    HUNDRED("C", 100), NINTY("XC",90),FIFTY("L", 50),
    FOURTY("XL", 40), TEN("X", 10), NINE("IX", 9),
    EIGHT("VIII", 8), SEVEN("VII", 7), SIX("VI", 6),
    FIVE("V", 5), FOUR("IV", 4), THREE("III", 3),
    TWO("II", 2), ONE("I", 1);





    String romanNum;
    int arabianNum;
    Converter(String romanNum, int arabianNum) {
        this.romanNum = romanNum;
        this.arabianNum = arabianNum;
    }
    int getArabianNum() {
        return arabianNum;
    }

    String getRomanNum() {
        return romanNum;
    }

}
