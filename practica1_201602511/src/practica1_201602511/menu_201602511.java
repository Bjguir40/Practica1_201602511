package practica1_201602511;

import java.util.Scanner;
/**
 *
 * @author Byron G
 */
public class menu_201602511 {

    int a;

    public void menu1() {

        System.out.println(" BYRON JOSUÉ GÜIR GONZÁLEZ");
        System.out.println("        201602511");
        System.out.println("    IPC1 A PRACTICA 1");
        System.out.println("     ! BUSCAMINAS !");
        System.out.println("Presione enter para continuar.");

        Scanner sc1 = new Scanner(System.in);
        String opcion = sc1.nextLine();

        switch (opcion) {
            case "":
                System.out.println("     ! BUSCAMINAS !");
                System.out.println("1. Principiante");
                System.out.println("2. Intermedio");
                System.out.println("3. Experto");
                System.out.println("4. Salir");
                System.out.println("Ingrese opcion");
                Scanner sc2 = new Scanner(System.in);
                a = sc2.nextInt();
                break;
            default:
                menu1();

        }
        switch (a) {
            case 1:
                System.out.println("    NIVEL PRINCIPIANTE");
                principiante();
                break;
            case 2:
                System.out.println("             NIVEL INTERMEDIO");
                intermedio();
                break;
            case 3:
                System.out.println("                      NIVEL EXPERTO");
                experto();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Opcion no valida");
                menu1();

        }
    }

    void principiante() {

        int matriz[][] = new int[4][4];
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matriz[i][j] + "\t");

            }
            System.out.println();
        }
    }

    void intermedio() {
        int matriz[][] = new int[6][6];
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                System.out.print(matriz[i][j] + "\t");

            }
            System.out.println();
        }
    }

    void experto() {
        int matriz[][] = new int[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                System.out.print(matriz[i][j] + "\t");

            }
            System.out.println();
        }
    }
}

