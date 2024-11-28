package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int aulas = sc.nextInt();

        for (int i = 1; i <= aulas; i++) {
            System.out.println("Dados da " + i + "ª aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine(); // Consumir quebra de linha
            System.out.print("Título: ");
            String titulo = sc.nextLine();

            if (ch == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha
                list.add(new Video(titulo, url, seconds));
            } else {
                System.out.print("Descrição: ");
                String desc = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int quant = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha
                list.add(new Task(titulo, desc, quant));
            }
        }

        // Calcular duração total
        int totalDuration = 0;
        for (Lesson lesson : list) {
            totalDuration += lesson.duration();
        }

        System.out.println("DURAÇÃO TOTAL DO CURSO: " + totalDuration + " segundos");

        sc.close();
    }
}
