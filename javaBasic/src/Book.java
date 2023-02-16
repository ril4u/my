public class Book {
    public String title;
    public int year;
    public int rating = 3;
    public String text = null;

    public Book(String title, String lastname, String name, int year) {
        this.title = title;
        this.year = year;

    }


    public void up() {
        if (rating < 5) {
            rating++;
        }
    }

    public void down() {
        if (rating > 0) {
            rating--;
        }
    }

    public void append(String moreText) {
        if (text == null) {
            this.text = moreText;
        } else {
        text += moreText;
        }
    }
}
