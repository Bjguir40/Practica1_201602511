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

        System.out.println(" BYRON JOSUÉ GÜIR GONZÁLEZ");
        System.out.println("        201602511");
        System.out.println("    IPC1 A PRACTICA 1");
        System.out.println("     ! BUSCAMINAS !");
        System.out.println("Presione enter para continuar.");

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
        System.out.println("     ! BUSCAMINAS !");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Experto");
        System.out.println("4. Salir");
        System.out.println("Ingrese opcion");
        Scanner sc2 = new Scanner(System.in);
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
                System.out.println("Opcion no valida");
                menu2();

        }
    }

    void principiante() {

        System.out.println("NIVEL PRINCIPIANTE");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matriz01[i][j] + "\t");

            }
            System.out.println();
        }

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matriz1[i][j] + "\t");

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
            case "R":
                reiniciar1();
                principiante();
                break;
            case "S":
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
                matriz1[i][j] = "[X]";
            }
        }

        Random rn = new Random();
        matriz01 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz01[i][j] = "[ ]";

            }
        }
        for (t = 0; t < 4; t++) { // NUMERO DE MINAS
            fila = rn.nextInt(3);
            columna = rn.nextInt(3);
            if (matriz01[fila][columna].equals("[*]")) {
                t--;
            }
            matriz01[fila][columna] = "[*]";
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
                    System.out.print(matriz1[h][k] + "[ ]");

                }
                System.out.println();
            }
            if (matriz01[Integer.parseInt(coordenada[0]) - 1][Integer.parseInt(coordenada[1]) - 1].equals("[*]")) {
                System.out.println("!!!!HAS PERDIDO!!!");
                System.out.println("Las minas estaban en...");
                for (int h = 0; h <= 3; h++) {
                    for (int k = 0; k <= 3; k++) {
                        System.out.print(matriz01[h][k] + "[ ]");

                    }
                    System.out.println();
                }

                reiniciar1();
                principiante();

            }
        }

        principiante();

    }

    int verificar_si_mina(int i, int j) {
        try {
            if (matriz01[i][j].equals("[*]")) {
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
                System.out.print(matriz02[i][j] + "\t");

            }
            System.out.println();
        }

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                System.out.print(matriz2[i][j] + "\t");

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
            case "R":
                reiniciar2();
                intermedio();
                break;
            case "S":
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
                matriz2[i][j] = "[X]";
            }
        }

        Random rn = new Random();
        matriz02 = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriz02[i][j] = "[ ]";
            }
        }
        for (t = 0; t < 8; t++) { // NUMERO DE MINAS
            fila = rn.nextInt(5);
            columna = rn.nextInt(5);
            if (matriz02[fila][columna].equals("[*]")) {
                t--;
            }

            matriz02[fila][columna] = "[*]";
        }

    }

    private void voltear2() {
        System.out.println("Ingrese una fila , columna");
        Scanner lector1;
        lector1 = new Scanner(System.in);
        String coor = lector1.nextLine();
        String[] coordenada = coor.split(",");
        if (coordenada.length != 2) {
            System.out.println("Ingrese coordenadas validas");
        } else {

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
                    System.out.print(matriz2[h][k] + "[ ]");

                }
                System.out.println();
            }
            if (matriz02[Integer.parseInt(coordenada[0]) - 1][Integer.parseInt(coordenada[1]) - 1].equals("[*]")) {
                System.out.println("!!!!HAS PERDIDO!!!");
                System.out.println("Las minas estaban en...");
                for (int h = 0; h <= 5; h++) {
                    for (int k = 0; k <= 5; k++) {
                        System.out.print(matriz02[h][k] + "[ ]");

                    }
                    System.out.println();
                }

                reiniciar2();
                intermedio();

            }
        }

        intermedio();

    }

    int verificar_si_mina2(int i, int j) {
        try {
            if (matriz02[i][j].equals("[*]")) {
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
                System.out.print(matriz03[i][j] + "\t");

            }
            System.out.println();
        }

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                System.out.print(matriz3[i][j] + "\t");

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
            case "R":
                reiniciar3();
                experto();
                break;
            case "S":
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
                matriz3[i][j] = "[X]";
            }
        }

        Random rn = new Random();
        matriz03 = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz03[i][j] = "[ ]";

            }
        }
        for (t = 0; t < 12; t++) { // NUMERO DE MINAS
            fila = rn.nextInt(7);
            columna = rn.nextInt(7);
            if (matriz03[fila][columna].equals("[*]")) {
                t--;
            }

            matriz03[fila][columna] = "[*]";
        }

    }

    private void voltear3() {
        System.out.println("Ingrese una fila , columna");
        Scanner lector1;
        lector1 = new Scanner(System.in);
        String coor = lector1.nextLine();
        String[] coordenada = coor.split(",");
        if (coordenada.length != 2) {
            System.out.println("Ingrese coordenadas validas");
        } else {

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
                    System.out.print(matriz3[h][k] + "[ ]");

                }
                System.out.println();
            }
            if (matriz03[Integer.parseInt(coordenada[0]) - 1][Integer.parseInt(coordenada[1]) - 1].equals("[*]")) {
                System.out.println("!!!!HAS PERDIDO!!!");
                System.out.println("Las minas estaban en...");
                for (int h = 0; h <= 7; h++) {
                    for (int k = 0; k <= 7; k++) {
                        System.out.print(matriz03[h][k] + "[ ]");

                    }
                    System.out.println();
                }

                reiniciar3();
                experto();

            }
        }

        experto();

    }

    int verificar_si_mina3(int i, int j) {
        try {
            if (matriz03[i][j].equals("[*]")) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
