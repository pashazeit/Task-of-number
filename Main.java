package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String output = "";
    public static String edin[] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    public static String edin_tis[] = {"ноль", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    public static String desyat[] = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    public static String desyat1[] = {"", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    public static String sotka[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шетьсот", "семьсот", "восемьсот", "девятьсот"};


    public static String edinici_tis(String ed) {  //единицы для тысяч

        int index = Integer.parseInt(ed);

        String stroka = edin_tis[index];
        return stroka;
    }


    public static String edinici(String ed) {  //единицы

        int index = Integer.parseInt(ed);

        String stroka = edin[index];
        return stroka;
    }


    public static String desyatki(String dec, int flag) {                   //десятки

        int des = Integer.parseInt(dec);

        int ed = 0;
        String stroka = "";

        if (des == 0) stroka = "";
        else {
            if (des % 10 == 0) {                                               //10 20 30 40
                stroka = desyat[des / 10];

            } else {
                if ((des > 10) && (des < 20)) stroka = desyat1[des - 10];   //11 12 13 14
                else {                                                     //25 94 38
                    ed = des % 10;
                    des = (des - des % 10) / 10;
                    stroka = desyat[des] + " ";
                    switch (flag) {
                        case 0:
                            stroka += edinici(ed + "");
                            break;
                        default:
                            stroka += edinici_tis(ed + "");
                            break;
                    }

                }
            }
        }

        return stroka;
    }

    public static String sotki(String sotn, int flag) {

        int sot = Integer.parseInt(sotn);

        String stroka = "";
        if (sot == 0) stroka = "";
        else {
            int des = 0;

            if (sot % 100 == 0) {                     //100 200 300 400
                stroka = sotka[sot / 100];

            } else {

                des = sot % 100;                //110 111 112 113
                sot = (sot - sot % 100) / 100;
                stroka = sotka[sot] + " ";
                switch (flag) {
                    case 0:
                        stroka += desyatki(des + "", 0);
                        break;
                    default:
                        stroka += desyatki(des + "", 1);
                        break;
                }

            }
        }
        return stroka;
    }

    public static String tisyachi(String kos) {               // 1000

            String[] konch = {"тысяч", "тысяча", "тысячи", ""};

        String stroka;
        String tis;
        int konch_index = 3;
        int kosar = Integer.parseInt(kos);

        if (kosar == 0) stroka = "";
        else {

            tis = "" + kos;                                   //отделяем тысячи

            tis = tis.substring(0, tis.length() - 3);
            int tisy = Integer.parseInt(tis);
            stroka = sotki (tisy + "", 1) + " ";


            int dlina = tis.length();


            if (tisy == 0) konch_index = 3;
            else {
                switch (dlina) {
                    case 1:
                        int a = Integer.parseInt(tis);
                        switch (a) {
                            case 1:
                                konch_index = 1;
                                break;
                            case 2:
                            case 3:
                            case 4:
                                konch_index = 2;
                                break;
                            default:
                                konch_index = 0;
                                break;
                        }

                        break;
                    default:
                        int b = Integer.parseInt(tis);

                        if (b % 10 == 0) konch_index = 0;
                        else if (b > 10 && b < 20) konch_index = 0;

                        else {
                            String s = ""+b;


                            b = b % 10;
                            switch (b) {
                                case 1:
                                    konch_index = 1;
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                    konch_index = 2;
                                    break;
                                default:
                                    konch_index = 0;
                                    break;
                            }
                            s = s.substring(1,s.length());
                            int i = Integer.parseInt(s);
                            if (i > 10 && i < 20) konch_index = 0;
                        }

                        break;

                }
            }


            stroka = stroka + konch[konch_index] + " ";

            String razr = "" + kos;                             //отделяем сотни
            razr = razr.substring(razr.length() - 3, razr.length());
            int sotni_iz_tisyach = Integer.parseInt(razr);
            stroka = stroka + sotki(sotni_iz_tisyach + "", 0);
        }
        return stroka;
    }


    public static String millions(String mil) {               // 1 000 000

        String[] konch = {"миллион", "миллиона", "миллионов",""};

        String stroka = "";
        String tis = "";
        int konch_index = 3;
        int millins = Integer.parseInt(mil);

        if (millins == 0) stroka = "";
        else {
            String mils = "" + mil;                                   //отделяем миллион
            mils = mils.substring(0, mils.length() - 6);
            int mi = Integer.parseInt(mils);
            stroka = sotki(mi + "", 0) + " ";

            int dlina = mils.length();

            switch (dlina) {
                case 1:
                    int a = Integer.parseInt(mils);
                    switch (a) {
                        case 1:
                            konch_index = 0;
                            break;
                        case 2:
                        case 3:
                        case 4:
                            konch_index = 1;
                            break;
                        default:
                            konch_index = 2;
                            break;
                    }

                    break;
                default:
                    int b = Integer.parseInt(mils);

                    if (b % 10 == 0) konch_index = 2;
                    else if (b > 10 && b < 20) konch_index = 2;
                    else {
                        String s = "" + b;
                        b = b % 10;
                        switch (b) {
                            case 1:
                                konch_index = 0;
                                break;
                            case 2:
                            case 3:
                            case 4:
                                konch_index = 1;
                                break;
                            default:
                                konch_index = 2;
                                break;
                        }
                        s = s.substring(1, s.length());
                        int i = Integer.parseInt(s);
                        if (i > 10 && i < 20) konch_index = 2;
                    }

                    break;

            }

            if (mi == 0) konch_index = 3;
            stroka = stroka + konch[konch_index] + " ";


            //stroka = mils + " ";


            tis = "" + mil;                                   //отделяем тысячи
            tis = tis.substring(tis.length() - 6, tis.length());

            //int tisy = Integer.parseInt(tis);
            stroka = stroka + tisyachi(tis + "") + "";
        }
        return stroka;
    }


    public static String milliards(String mil) {               // 1 000 000 000

        String[] konch = {"миллиард", "миллиарда", "миллиардов",""};

        String stroka = "";
        String tis = "";
        int konch_index = 3;
        Long milliars = Long.parseLong(mil);

        if (milliars == 0) stroka = "";
        else {

            String mils = "" + mil;                                   //отделяем миллиарды
            mils = mils.substring(0, mils.length() - 9);
            int mi = Integer.parseInt(mils);
            stroka = sotki(mi + "", 0) + " ";

            int dlina = mils.length();

            switch (dlina) {
                case 1:
                    int a = Integer.parseInt(mils);
                    switch (a) {
                        case 1:
                            konch_index = 0;
                            break;
                        case 2:
                        case 3:
                        case 4:
                            konch_index = 1;
                            break;
                        default:
                            konch_index = 2;
                            break;
                    }

                    break;
                default:
                    int b = Integer.parseInt(mils);

                    if (b % 10 == 0) konch_index = 2;
                    else if (b > 10 && b < 20) konch_index = 2;
                    else {
                        String s = "" + b;
                        b = b % 10;
                        switch (b) {
                            case 1:
                                konch_index = 0;
                                break;
                            case 2:
                            case 3:
                            case 4:
                                konch_index = 1;
                                break;
                            default:
                                konch_index = 2;
                                break;
                        }
                        s = s.substring(1, s.length());
                        int i = Integer.parseInt(s);
                        if (i > 10 && i < 20) konch_index = 2;
                    }

                    break;

            }
            if (mi == 0) konch_index = 3;
            stroka = stroka + konch[konch_index] + " ";


            //stroka = mils + " ";


            tis = "" + mil;                                   //отделяем миллионы
            tis = tis.substring(tis.length() - 9, tis.length());

            //int tisy = Integer.parseInt(tis);
            stroka = stroka + millions(tis + "") + "";
        }
        return stroka;
    }

    public static String trillions(String mil) {               // 1 000 000 000 000

        String[] konch = {"триллион", "триллиона", "триллионов",""};

        String stroka = "";
        String tis = "";
        int konch_index = 3;
        long milliars = Long.parseLong(mil);

        if (milliars == 0) stroka = "";
        else {

            String mils = "" + mil;                                   //отделяем триллионы
            mils = mils.substring(0, mils.length() - 12);
            int mi = Integer.parseInt(mils);
            stroka = sotki(mi + "", 0) + " ";

            int dlina = mils.length();

            switch (dlina) {
                case 1:
                    int a = Integer.parseInt(mils);
                    switch (a) {
                        case 1:
                            konch_index = 0;
                            break;
                        case 2:
                        case 3:
                        case 4:
                            konch_index = 1;
                            break;
                        default:
                            konch_index = 2;
                            break;
                    }

                    break;
                default:
                    int b = Integer.parseInt(mils);

                    if (b % 10 == 0) konch_index = 2;
                    else if (b > 10 && b < 20) konch_index = 2;
                    else {
                        String s = "" + b;
                        b = b % 10;
                        switch (b) {
                            case 1:
                                konch_index = 0;
                                break;
                            case 2:
                            case 3:
                            case 4:
                                konch_index = 1;
                                break;
                            default:
                                konch_index = 2;
                                break;
                        }
                        s = s.substring(1, s.length());
                        int i = Integer.parseInt(s);
                        if (i > 10 && i < 20) konch_index = 2;
                    }

                    break;

            }
            if (mi == 0) konch_index = 3;
            stroka = stroka + konch[konch_index] + " ";


            //stroka = mils + " ";


            tis = "" + mil;                                   //отделяем миллиарды
            tis = tis.substring(tis.length() - 12, tis.length());

            //int tisy = Integer.parseInt(tis);
            stroka = stroka + milliards(tis + "");
        }
        return stroka;
    }

    public static void main(String[] args) throws IOException {         //MAIN


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(reader.readLine());

        String s = a+ "";

        int length = s.length();

        switch (length) {
            case 0:
                System.out.println("введите число");
            case 1:
                output = edinici(s);
                break;
            case 2:
                output = desyatki(s, 0);
                break;
            case 3:
                output = sotki(s, 0);
                break;
            case 4:
            case 5:
            case 6:
                output = tisyachi(s);
                break;
            case 7:
            case 8:
            case 9:
                output = millions(s);
                break;
            case 10:
            case 11:
            case 12:
                output = milliards(s);
                break;
            case 13:
            case 14:
            case 15:
                output = trillions(s);
                break;
            default:
                System.out.println("сам считай.");
                break;

        }

        System.out.println(output.replaceAll("\\s{2,}", " "));
    }
}
