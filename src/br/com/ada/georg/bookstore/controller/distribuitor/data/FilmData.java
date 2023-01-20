package br.com.ada.georg.bookstore.controller.distribuitor.data;

import java.math.BigDecimal;

public class FilmData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String studio, String director, String producer, int quantity}
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
        };
    }
}
