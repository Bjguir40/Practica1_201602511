package practica1_201602511;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Byron G
 */
public class Principal_201602511 {

    public Principal_201602511() {
        menu1();
    }
    public int fila;
    public int columna;
    String matriz1[][];
    String matriz01[][];
    String matriz2[][];
    String matriz02[][];
    String matriz3[][];
    String matriz03[][];

    public void menu1() {
        reiniciar1();
        reiniciar2();
        reiniciar3();
        System.out.println("|------------------------------------|");
        System.out.println("|------------------------------------|");
        System.out.println("|     BYRON JOSUÉ GÜIR GONZÁLEZ      |");
        System.out.println("|             201602511              |");
        System.out.println("|          IPC1 A PRACTICA 1         |");
        System.out.println("|          !!!BUSCAMINAS!!!          |");
        System.out.println("|------------------------------------|");
        System.out.println("|------------------------------------|");
        System.out.println(" ");
        System.out.println("Presione enter para continuar");

        Scanner sc1 = new Scanner(System.in);
        String opcion = sc1.nextLine();

        switch (opcion) {
            case "":
                menu2();
                break;
            default:
                menu1();
        }
    }

    public void menu2() {
        System.out.println("-----------------------");
        System.out.println("     ! BUSCAMINAS !");
        System.out.println("-----------------------");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Experto");
        System.out.println("4. Salir");
        System.out.println(" ");
        System.out.println("Ingrese opcion");

        Scanner sc2 = new Scanner(System.in);
        try {
            int a;
            a = sc2.nextInt();

            switch (a) {
                case 1:
                    principiante();
                    break;
                case 2:
                    intermedio();
                    break;
                case 3:
                    experto();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opción no valida");
                    menu2();
            }
        } catch (Exception e) {
            System.out.println("Opción no valida");
            menu2();
        }
    }

    void principiante() {

        System.out.println("NIVEL PRINCIPIANTE");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matriz01[i][j] + " ");

            }
            System.out.println();
        }

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matriz1[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("Voltear : V");
        System.out.println("Reiniciar : R");
        System.out.println("Salir : S");
        System.out.println("Ingresar Opcion");

        Scanner sc4 = new Scanner(System.in);
        String entrar = sc4.nextLine();

        switch (entrar) {
            case "V":
                voltear1();
                break;
            case "v":
                voltear1();
                break;
            case "R":
                reiniciar1();
                principiante();
                break;
            case "r":
                reiniciar1();
                principiante();
                break;
            case "S":
                menu2();
                break;
            case "s":
                menu2();
                break;
            default:
                System.out.println("Ingrese opción valida");
                principiante();

        }

    }

    private void reiniciar1() {

        int t;
        matriz1 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz1[i][j] = "X";
            }
        }

        Random rn = new Random();
        matriz01 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz01[i][j] = " ";

            }
        }
        for (t = 0; t < 4; t++) { // NUMERO DE MINAS
            fila = rn.nextInt(3);
            columna = rn.nextInt(3);
            if (matriz01[fila][columna].equals("*")) {
                t--;
            }
            matriz01[fila][columna] = "*";
        }

    }

    private void voltear1() {
        System.out.println("Ingrese una fila , columna");
        Scanner lector1;
        lector1 = new Scanner(System.in);
        String coor = lector1.nextLine();
        String[] coordenada = coor.split(",");
        if (coordenada.length != 2) {
            System.out.println("Ingrese coordenadas validas");
        } else {
            System.out.println("Usted seleccionó:(" + coordenada[0] + "," + coordenada[1] + ") Presione 1 para aceptar ó 0 para cancelar");

            int respuesta = lector1.nextInt();
            if (respuesta == 1) {
                int numero_a_mostrar;
                numero_a_mostrar = 0;

                int i = Integer.parseInt(coordenada[0]) - 1;
                int j = Integer.parseInt(coordenada[1]) - 1;

                if (this.verificar_si_mina(i, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j) == 1) {
                    numero_a_mostrar++;
                }

                matriz1[i][j] = Integer.toString(numero_a_mostrar);

                for (int h = 0; h <= 3; h++) {
                    for (int k = 0; k <= 3; k++) {
                        System.out.print(matriz1[h][k] + " ");

                    }
                    System.out.println();
                }
                if (matriz01[Integer.parseInt(coordenada[0]) - 1][Integer.parseInt(coordenada[1]) - 1].equals("*")) {
                    System.out.println("!!!!HAS PERDIDO!!!");
                    System.out.println("LAS MINAS ESTABAN EN...");
                    for (int h = 0; h <= 3; h++) {
                        for (int k = 0; k <= 3; k++) {
                            System.out.print(matriz01[h][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("LA SOLUCION ERA...");
                    String matriz11[][];
                    matriz11 = new String[4][4];
                    for (int a = 1; a <= 4; a++) {
                        for (int b = 1; b <= 4; b++) {
                            int numerito;
                            numerito = 0;
                            int x = a - 1;
                            int y = b - 1;

                            if (this.verificar_si_mina(x, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x + 1, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x + 1, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x - 1, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x - 1, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x - 1, y) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina(x + 1, y) == 1) {
                                numerito++;
                            }

                            matriz11[x][y] = Integer.toString(numerito);

                        }

                    }
                    for (int h = 0; h <= 3; h++) {
                        for (int k = 0; k <= 3; k++) {
                            if (matriz01[h][k] == "*") {
                                System.out.print(matriz01[h][k] + " ");
                            } else {

                                System.out.print(matriz11[h][k] + " ");
                            }

                        }
                        System.out.println();
                    }
                    reiniciar1();
                    principiante();

                }
            } else if (respuesta == 0) {
                voltear1();
            } else {
                System.out.println("Inválido");
                voltear1();
            }

        }

        principiante();

    }

    int verificar_si_mina(int i, int j) {
        try {
            if (matriz01[i][j].equals("*")) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    void intermedio() {

        System.out.println("NIVEL INTERMEDIO");
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                System.out.print(matriz02[i][j] + " ");

            }
            System.out.println();
        }

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                System.out.print(matriz2[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("Voltear : V");
        System.out.println("Reiniciar : R");
        System.out.println("Salir : S");
        System.out.println("Ingresar Opcion");

        Scanner sc5 = new Scanner(System.in);
        String entrar = sc5.nextLine();

        switch (entrar) {
            case "V":
                voltear2();
                break;
            case "v":
                voltear2();
                break;
            case "R":
                reiniciar2();
                intermedio();
                break;
            case "r":
                reiniciar2();
                intermedio();
                break;
            case "S":
                menu2();
                break;
            case "s":
                menu2();
                break;
            default:
                System.out.println("Ingrese opción valida");
                intermedio();

        }
    }

    private void reiniciar2() {
        int t;
        matriz2 = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriz2[i][j] = "X";
            }
        }

        Random rn = new Random();
        matriz02 = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriz02[i][j] = " ";
            }
        }
        for (t = 0; t < 8; t++) { // NUMERO DE MINAS
            fila = rn.nextInt(5);
            columna = rn.nextInt(5);
            if (matriz02[fila][columna].equals("*")) {
                t--;
            }

            matriz02[fila][columna] = "*";
        }

    }

    private void voltear2() {
        System.out.println("Ingrese una fila , columna");
        Scanner lector2;
        lector2 = new Scanner(System.in);
        String coor = lector2.nextLine();
        String[] coordenada = coor.split(",");
        if (coordenada.length != 2) {
            System.out.println("Ingrese coordenadas validas");
        } else {
            System.out.println("Usted seleccionó:(" + coordenada[0] + "," + coordenada[1] + ") Presione 1 para aceptar y 0 para cancelar");

            int respuesta = lector2.nextInt();
            if (respuesta == 1) {
                int numero_a_mostrar;
                numero_a_mostrar = 0;

                int i = Integer.parseInt(coordenada[0]) - 1;
                int j = Integer.parseInt(coordenada[1]) - 1;

                if (this.verificar_si_mina(i, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j) == 1) {
                    numero_a_mostrar++;
                }

                matriz2[i][j] = Integer.toString(numero_a_mostrar);

                for (int h = 0; h <= 5; h++) {
                    for (int k = 0; k <= 5; k++) {
                        System.out.print(matriz2[h][k] + " ");

                    }
                    System.out.println();
                }
                if (matriz02[Integer.parseInt(coordenada[0]) - 1][Integer.parseInt(coordenada[1]) - 1].equals("*")) {
                    System.out.println("!!!!HAS PERDIDO!!!");
                    System.out.println("LAS MINAS ESTABAN EN...");
                    for (int h = 0; h <= 5; h++) {
                        for (int k = 0; k <= 5; k++) {
                            System.out.print(matriz02[h][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("LA SOLUCION ERA...");
                    String matriz22[][];
                    matriz22 = new String[6][6];
                    for (int a = 1; a <= 6; a++) {
                        for (int b = 1; b <= 6; b++) {
                            int numerito;
                            numerito = 0;
                            int x = a - 1;
                            int y = b - 1;

                            if (this.verificar_si_mina2(x, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x + 1, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x + 1, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x - 1, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x - 1, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x - 1, y) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina2(x + 1, y) == 1) {
                                numerito++;
                            }

                            matriz22[x][y] = Integer.toString(numerito);

                        }

                    }
                    for (int h = 0; h <= 5; h++) {
                        for (int k = 0; k <= 5; k++) {
                            if (matriz02[h][k] == "*") {
                                System.out.print(matriz02[h][k] + " ");
                            } else {

                                System.out.print(matriz22[h][k] + " ");
                            }

                        }
                        System.out.println();
                    }
                    reiniciar2();
                    intermedio();

                }
            } else if (respuesta == 0) {
                voltear2();
            } else {
                System.out.println("Inválido");
                voltear2();
            }

        }

        intermedio();

    }

    int verificar_si_mina2(int i, int j) {
        try {
            if (matriz02[i][j].equals("*")) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    void experto() {
        System.out.println("NIVEL EXPERTO");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                System.out.print(matriz03[i][j] + " ");

            }
            System.out.println();
        }

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                System.out.print(matriz3[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("Voltear : V");
        System.out.println("Reiniciar : R");
        System.out.println("Salir : S");
        System.out.println("Ingresar Opcion");

        Scanner sc6 = new Scanner(System.in);
        String entrar = sc6.nextLine();

        switch (entrar) {
            case "V":
                voltear3();
                break;
            case "v":
                voltear3();
                break;
            case "R":
                reiniciar3();
                experto();
                break;
            case "r":
                reiniciar3();
                experto();
                break;
            case "S":
                menu2();
                break;
            case "s":
                menu2();
                break;
            default:
                System.out.println("Ingrese opción valida");
                experto();

        }

    }

    private void reiniciar3() {
        int t;
        matriz3 = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz3[i][j] = "X";
            }
        }

        Random rn = new Random();
        matriz03 = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz03[i][j] = " ";

            }
        }
        for (t = 0; t < 12; t++) { // NUMERO DE MINAS
            fila = rn.nextInt(7);
            columna = rn.nextInt(7);
            if (matriz03[fila][columna].equals("*")) {
                t--;
            }

            matriz03[fila][columna] = "*";
        }

    }

    private void voltear3() {
        System.out.println("Ingrese una fila , columna");
        Scanner lector3;
        lector3 = new Scanner(System.in);
        String coor = lector3.nextLine();
        String[] coordenada = coor.split(",");
        if (coordenada.length != 2) {
            System.out.println("Ingrese coordenadas validas");
        } else {
            System.out.println("Usted seleccionó:(" + coordenada[0] + "," + coordenada[1] + ") Presione 1 para aceptar ó 0 para cancelar");

            int respuesta = lector3.nextInt();
            if (respuesta == 1) {
                int numero_a_mostrar;
                numero_a_mostrar = 0;

                int i = Integer.parseInt(coordenada[0]) - 1;
                int j = Integer.parseInt(coordenada[1]) - 1;

                if (this.verificar_si_mina(i, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j - 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j + 1) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i - 1, j) == 1) {
                    numero_a_mostrar++;
                }
                if (this.verificar_si_mina(i + 1, j) == 1) {
                    numero_a_mostrar++;
                }

                matriz3[i][j] = Integer.toString(numero_a_mostrar);

                for (int h = 0; h <= 7; h++) {
                    for (int k = 0; k <= 7; k++) {
                        System.out.print(matriz3[h][k] + " ");

                    }
                    System.out.println();
                }
                if (matriz03[Integer.parseInt(coordenada[0]) - 1][Integer.parseInt(coordenada[1]) - 1].equals("*")) {
                    System.out.println("!!!!HAS PERDIDO!!!");
                    System.out.println("LAS MINAS ESTABAN EN...");
                    for (int h = 0; h <= 7; h++) {
                        for (int k = 0; k <= 7; k++) {
                            System.out.print(matriz03[h][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("LA SOLUCION ERA...");
                    String matriz33[][];
                    matriz33 = new String[8][8];
                    for (int a = 1; a <= 8; a++) {
                        for (int b = 1; b <= 8; b++) {
                            int numerito;
                            numerito = 0;
                            int x = a - 1;
                            int y = b - 1;

                            if (this.verificar_si_mina3(x, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x + 1, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x + 1, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x - 1, y - 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x - 1, y + 1) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x - 1, y) == 1) {
                                numerito++;
                            }
                            if (this.verificar_si_mina3(x + 1, y) == 1) {
                                numerito++;
                            }

                            matriz33[x][y] = Integer.toString(numerito);

                        }

                    }
                    for (int h = 0; h <= 7; h++) {
                        for (int k = 0; k <= 7; k++) {
                            if (matriz03[h][k] == "*") {
                                System.out.print(matriz03[h][k] + " ");
                            } else {

                                System.out.print(matriz33[h][k] + " ");
                            }

                        }
                        System.out.println();
                    }
                    reiniciar3();
                    experto();

                }
            } else if (respuesta == 0) {
                voltear3();
            } else {
                System.out.println("Inválido");
                voltear3();
            }

        }

        experto();

    }

    int verificar_si_mina3(int i, int j) {
        try {
            if (matriz03[i][j].equals("*")) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
