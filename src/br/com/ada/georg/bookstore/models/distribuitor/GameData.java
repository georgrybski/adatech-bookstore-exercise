package br.com.ada.georg.bookstore.models.distribuitor;

import java.math.BigDecimal;

public class GameData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String distribuitor, String studio, int quantity}
                {"Games", "BioShock", BigDecimal.valueOf(37.97), "First Person Shooter", "2K Games", "2K Boston", 100},
                {"Games", "Halo 3", BigDecimal.valueOf(19.69 ), "First Person Shooter", "Microsoft", "Bungie", 100},

                {"Games", "Elden Ring", BigDecimal.valueOf(44.95), "Action-Adventure", "Bandai", "FromSoftware", 100},
                {"Games", "Game 4", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},

                {"Games", "Project Zomboid", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "The Indie Stone", 100},
                {"Games", "Game 6", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},

                {"Games", "Game 7", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},
                {"Games", "Game 8", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},

                {"Games", "Game 9", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},
                {"Games", "Game 10", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},

                {"Games", "Game 11", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},
                {"Games", "Game 12", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},

                {"Games", "Game 13", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},
                {"Games", "Game 14", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},

                {"Games", "Game 15", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},
                {"Games", "Game 16", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},

                {"Games", "Game 17", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100},
                {"Games", "Game 18", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100}
        };
    }
}
