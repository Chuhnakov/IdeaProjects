package ru.oshkina;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final String[] words = "кит кобра лось".split(" ");
    private String secretWord;
    private final String[] hangmanPictures = {
            "game-1.txt",
            "game-2.txt",
            "game-3.txt",
            "game-4.txt",
            "game-5.txt",
            "game-6.txt",
            "game-7.txt",
    };
    private StringBuilder alreadyGuessed = new StringBuilder();
    private StringBuilder missedLetters = new StringBuilder();
    private StringBuilder correctLetters = new StringBuilder();
    private Scanner sc = new Scanner(System.in);

    /**
     * Считываем картинку из файла
     * и выводим на экран
     */
    public void readFileData(String name) throws FileNotFoundException {
        String path = "./src/main/resources/GameData/";
        File file = new File(path + name);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }

    /**
     * Возвращаем случайное слово - оно же загаданное
     */
    private String getRandomWord() {
        int wordIndex = getRandomValueBetweenRange(0, words.length - 1);
        return words[wordIndex];
    }

    public int getRandomValueBetweenRange(int min, int max) {
        return new Random().nextInt( ((max - min) + 1) + min);

    }

    /**
     * Возвращает true, если игрок будет продолжать игру,
     * иначе возвращаем false
     */
    private boolean playAgain() {
        System.out.println("Хотите играть еще раз?(да или нет)");
        return sc.nextLine().toLowerCase().startsWith("д");
    }

    private String getGuess() {
        while (true) {
            System.out.print("Введите букву: ");
            String guess = sc.nextLine().toLowerCase();
            if (guess.length() != 1) {
                System.out.println("Пожалуйста, введите одну букву ");
            } else if ((int) guess.charAt(0) - 1072 + 1105 - (int) guess.charAt(0) != 33) {
                // 1105-1072 (Диапозон рус букв) 1072 = 'a'; 1103= 'я'; 1104= 'ѐ'; 1105= 'ё'
                System.out.println("Пожалуйста, введите БУКВУ!");
            } else if (alreadyGuessed.toString().contains(guess)) {
                System.out.println("Вы уже указывали эту букву, введите другую:");
            } else {
                return guess;
            }
        }
    }

    private void displayBoard() throws FileNotFoundException {
        String hangmanPicture = hangmanPictures[missedLetters.length()];
        readFileData(hangmanPicture);
        System.out.println("Ошибочные буквы: ");
        for (int i = 0; i < missedLetters.length(); i++) {
            System.out.print(missedLetters.charAt(i) + " ");
        }
        System.out.println();

        //_ _ _ _ _
        StringBuilder blanks = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            blanks.append("_");
        }
        //кит
        // _ _ _
        // _ и _
        //нужно заменить пропуски на отгаданные буквы
        for (int i = 0; i < secretWord.length(); i++) {
            if (correctLetters.toString().contains(String.valueOf(secretWord.charAt(i)))) {
                blanks = new StringBuilder(blanks.substring(0, i) + secretWord.charAt(i) + blanks.substring(i + 1, secretWord.length()));
            }
        }

        for (int i = 0; i < blanks.length(); i++) {
            System.out.print(blanks.charAt(i) + " ");
        }
        System.out.println();
    }


    public void start() throws FileNotFoundException {
        System.out.println("В И С Е Л И Ц А");
        secretWord = getRandomWord();
        boolean gameIsDone = false;
        do {
            displayBoard();

            alreadyGuessed = correctLetters.append(missedLetters);
            //позволяем игроку ввести одну букву
            String guess = getGuess();
            if (secretWord.contains(guess)) {
                correctLetters.append(guess);
                //проверка, а не выиграл ли игрок?
                boolean foundAllLetters = true;
                for (int i = 0; i < secretWord.length(); i++) {
                    if (!correctLetters.toString().contains(String.valueOf(secretWord.charAt(i)))) {
                        foundAllLetters = false;
                        break;
                    }
                }
                if (foundAllLetters) {
                    System.out.println("Да! Секретное слово: " + secretWord + ". Вы угадали!");
                    gameIsDone = true;
                }
            } else {

                missedLetters.append(guess);
                if (missedLetters.length() == (hangmanPictures.length - 1)) {
                    displayBoard();
                    System.out.println("Вы исчерпали все попытки!");
                    System.out.println("Не угадали " + missedLetters.length() + " букв");
                    System.out.println("Угадано букв: " + correctLetters.length());
                    System.out.println("Загаданное слово: " + secretWord);
                    gameIsDone = true;
                }
            }
            if (gameIsDone) {
                if (playAgain()) {
                    missedLetters = new StringBuilder();
                    correctLetters = new StringBuilder();
                    gameIsDone = false;
                    secretWord = getRandomWord();
                } else {
                    break;
                }
            }
        } while (true);
    }
}
