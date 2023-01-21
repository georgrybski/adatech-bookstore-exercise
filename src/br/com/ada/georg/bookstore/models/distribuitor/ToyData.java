package br.com.ada.georg.bookstore.models.distribuitor;

import java.math.BigDecimal;

public class ToyData implements ProductData{
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, int quantity, String genre}

                {"Toys", "Tamashi Nations - Star Wars: Ronin Mandalorian & Grougu", BigDecimal.valueOf(129.53), "Action figure", 100},
                {"Toys", "Tamashi Nations - Star Wars: Daimyo Boba Fett", BigDecimal.valueOf(169.99), "Action figure", 100},

                {"Toys", "Safari Animals Figures Toys", BigDecimal.valueOf(38.99), "Animal", 100},
                {"Toys", "Talking Hamster", BigDecimal.valueOf(25.67), "Animal", 100},

                {"Toys", "VOLANTEXRC Brushless Remote Control Boat VectorSR80", BigDecimal.valueOf(339.99), "Car and radio controlled", 100},
                {"Toys", "Deejoy RC Gesture Sensor Double Sided Car", BigDecimal.valueOf(42.99), "Car and radio controlled", 100},

                {"Toys", "LEGO Architecture Great Pyramid of Giza", BigDecimal.valueOf(129.99), "Construction", 100},
                {"Toys", "LEGO Architecture Great Wall of China", BigDecimal.valueOf(109.95), "Construction", 100},

                {"Toys", "Lego Porche 911 RSR - 42096", BigDecimal.valueOf(169.99), "Creative", 100},
                {"Toys", "Lego Hogwarts Castle - 71043 ", BigDecimal.valueOf(469.99), "Creative", 100},

                {"Toys", "Barbie 60th Celebration Dreamhouse Playset", BigDecimal.valueOf(274.99), "Doll", 100},
                {"Toys", "Lottie Dolls Toy Horse Pony Pals", BigDecimal.valueOf(169.99), "Doll", 100},

                {"Toys", "ABC Monster", BigDecimal.valueOf(65.98), "Educational", 100},
                {"Toys", "Cell Shape Sorter", BigDecimal.valueOf(39.95), "Educational", 100},

                {"Toys", "Elenco Jr. SC-100 Electronics Exploration Kit", BigDecimal.valueOf(19.59), "Electronic", 100},
                {"Toys", "Star Wars The Child Animatronic Edition", BigDecimal.valueOf(66.99), "Electronic", 100},

                {"Toys", "Perpetual Motion Desktop Gadget", BigDecimal.valueOf(35.36), "Executive", 100},
                {"Toys", "Golden Winged Fidget Spinner", BigDecimal.valueOf(57.99), "Executive", 100},

                {"Toys", "Theo Klein Miele Petit Gourmet Play Kitchen", BigDecimal.valueOf(89.99), "Food-related", 100},
                {"Toys", "So Slime DIY Slimelicious Factory", BigDecimal.valueOf(31.99), "Food-related", 100},

                {"Toys", "CubicFun Titanic 3D", BigDecimal.valueOf(36.99), "Puzzle", 100},
                {"Toys", "Starry Night Vincent Van Gogh Jigsaw - 5070cm", BigDecimal.valueOf(12.99), "Puzzle", 100},

                {"Toys", "KidzLab Anti-Gravity Maglev", BigDecimal.valueOf(43.99), "Science and optical", 100},
                {"Toys", "NATIONAL GEOGRAPHIC Break Open 10 Premium Geodes", BigDecimal.valueOf(34.99), "Science and optical", 100},

                {"Toys", "Baby Einstein Take Along Tunes", BigDecimal.valueOf(9.99), "Sound and music", 100},
                {"Toys", "Hape Mighty Echo Microphone", BigDecimal.valueOf(11.99), "Sound and music", 100}
        };
    }
}
