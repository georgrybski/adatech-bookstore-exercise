package br.com.ada.georg.bookstore.models.distribuitor;

import java.math.BigDecimal;

public class FilmData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String studio, String director, String producer, int quantity}
                {"Films", "Film 1", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},
                {"Films", "Film 2", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},

                {"Films", "Film 3", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},
                {"Films", "Film 4", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},

                {"Films", "Film 5", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},
                {"Films", "Film 6", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},

                {"Films", "Film 7", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},
                {"Films", "Film 8", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},

                {"Films", "Film 9", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},
                {"Films", "Film 10", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},

                {"Films", "Film 11", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},
                {"Films", "Film 12", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},

                {"Films", "Film 13", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},
                {"Films", "Film 14", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},

                {"Films", "Film 15", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},
                {"Films", "Film 16", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},

                {"Films", "Film 17", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},
                {"Films", "Film 18", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},

                {"Films", "Film 19", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},
                {"Films", "Film 20", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},

                {"Films", "Film 21", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
                {"Films", "Film 22", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
        };
    }
}
