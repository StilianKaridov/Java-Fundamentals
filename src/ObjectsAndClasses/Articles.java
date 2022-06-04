package ObjectsAndClasses;

import java.util.*;

public class Articles {

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        while (numberOfCommands > 0) {
            String[] readArticle = scanner.nextLine().split(", ");
            articles.add(new Article(readArticle[0], readArticle[1], readArticle[2]));
            numberOfCommands--;
        }
        String input = scanner.nextLine();
        if (input.equals("title")) {
            articles.sort(Comparator.comparing(o -> o.title));
        } else if (input.equals("content")) {
            articles.sort(Comparator.comparing(o -> o.content));
        } else if (input.equals("author")) {
            articles.sort(Comparator.comparing(o -> o.author));
        }

        for (Article article : articles) {
            System.out.println(article.toString());
        }
    }
}
