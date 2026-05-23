import java.util.Scanner;

import br.com.mediahub.engine.utilities.TimeCalculator;
import br.com.mediahub.engine.content.Movie;
import br.com.mediahub.engine.content.TVSeries;

public class MediaHub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Movie Information
        Movie movie1 = new Movie();
        System.out.println("Digite o nome do filme:");
        movie1.setTitle(scanner.nextLine());
        System.out.println("Digite o nome do diretor do filme:");
        movie1.setDirector(scanner.nextLine());
        System.out.println("Digite o ano de lançamento do filme:");
        movie1.setReleaseYear(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a duração do filme em minutos:");
        movie1.setTotalDuration(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a quantidade de avaliações:");
        int qtd = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < qtd; i++) {
            System.out.println("Digite a nota da avaliação " + (i + 1) + ":");
            movie1.recordRating(Double.parseDouble(scanner.nextLine().trim()));
        }

        // TV Series Information
        TVSeries series1 = new TVSeries();
        System.out.println("Digite o nome da série:");
        series1.setTitle(scanner.nextLine());
        System.out.println("Digite o ano de lançamento da série:");
        series1.setReleaseYear(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a quantidade de temporadas da série:");
        series1.setTotalSeasons(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a quantidade de episódios por temporada:");
        series1.setEpisodesPerSeason(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a duração de cada episódio em minutos:");
        series1.setEpisodeDuration(Integer.parseInt(scanner.nextLine().trim()));

        scanner.close();

        movie1.displayDetails();
        series1.displayDetails();

        System.out.println("Soma das avaliações: " + movie1.getRatingSum());
        System.out.println("Total de avaliações: " + movie1.getRatingCount());
        System.out.println("Média das avaliações: " + movie1.calculateAverageRating());

        // Time Calculator
        TimeCalculator timeCalc = new TimeCalculator();
        timeCalc.addContent(movie1);
        timeCalc.addContent(series1);
        System.out.println("Tempo total: " + timeCalc.getAccumulatedTime());
    }
}
