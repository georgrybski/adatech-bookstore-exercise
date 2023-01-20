package br.com.ada.georg.bookstore.models.distribuitor;

import java.math.BigDecimal;

public class GameData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String distribuitor, String studio, int quantity}
                {"Games", "Game 1", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},
                {"Games", "Game 2", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},

                {"Games", "Game 3", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},
                {"Games", "Game 4", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},

                {"Games", "Game 5", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},
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
