package br.com.ada.georg.bookstore.controller.distribuitor.data;

import java.math.BigDecimal;

public class GameData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String distribuitor, String studio, int quantity}
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100}
        };
    }
}
