package string;

public class RecomId2 {
    public static void main(String[] args) {
        String answer = "z-+.^.";

        answer = answer.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9-._]", "");

        answer = answer.replaceAll("[.]{2,}", ".");

        answer = answer.replaceAll("^[.]|[.]$", "");

        if (answer.isEmpty()) {
            answer += 'a';
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        System.out.println(answer);

    }
}
