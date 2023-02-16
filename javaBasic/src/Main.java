import java.time.LocalDate;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //RecordBook book1 = new RecordBook("Detective of year", "David Gross", 1992);
        System.out.println("Введите Фамилию автора:");
        String lastname = scanner.nextLine();
        System.out.println("Введите Имя автора:");
        String name = scanner.nextLine();
        System.out.println("Введите название книги:");
        String title = scanner.nextLine();
        Author author1 = new Author(lastname, name);

        author1.numbersOfBook ++;
        Book book1 = new Book(title,lastname, name,LocalDate.now().getYear());
        // Author book2 = new newBook("hello");
        while (true) {
            System.out.println();
            System.out.println("------------------");
            System.out.println("Выберите действие:");

            System.out.println("1.Добавить текст");
            System.out.println("2.Изменить рейтинг");
            System.out.println("3.Вывести общие сведения");
            System.out.println("4.Выход");
            String num = scanner.nextLine();

            if ("1".equals(num)) {
                System.out.println("Введите добавляемый текст:");
                String input = scanner.nextLine();
                book1.append(input);
            } else if ("2".equals(num)) {
                System.out.println("Введите + для увеличения рейтинга, - для уменьшения");
                String inputRating = scanner.nextLine();
                if ("+".equals(inputRating)) {
                    book1.up();
                } else if ("-".equals(inputRating)){
                    book1.down();
                } else {
                    System.out.println("Введен некорректный параметр рейтинга.");
                }
            } else if ("3".equals(num)) {
                System.out.println("Книга: " + book1.title);
                System.out.println("Автор: " + author1.lastname + " " + author1.name);
                System.out.println("Количество книг: " + author1.numbersOfBook);
                System.out.println("Год: " + book1.year);
                System.out.println("Рейтинг: " + book1.rating);
                System.out.println("Текст книги: " + book1.text);
            } else if ("4".equals(num)) {
                System.out.println("Программа завершена!");
                break;
            } else {
                System.out.println("Вы ввели некорректное значение, попробуйте еще раз.");
            }
            }
        }





    }