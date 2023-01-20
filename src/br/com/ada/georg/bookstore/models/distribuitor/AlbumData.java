package br.com.ada.georg.bookstore.models.distribuitor;

import java.math.BigDecimal;

public class AlbumData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String author, String recordLabel, int quantity}

                {"Albums", "Midnights", BigDecimal.valueOf(12.97), "Pop", "Taylor Swift", "Republic Records", 100},
                {"Albums", "Changes", BigDecimal.valueOf(17.90), "Pop", "Justin Bieber", "Def Jam Recordings", 100},

                {"Albums", "Illmatic", BigDecimal.valueOf(7.98), "Hip hop", "Nas", "Columbia Records", 100},
                {"Albums", "Ready to Die", BigDecimal.valueOf(12.41), "Hip hop", "The Notorious B.I.G.", "Bad Boy Records", 100},

                {"Albums", "Appetite for Destruction", BigDecimal.valueOf(8.77), "Rock", "Guns N' Roses", "Geffen Records", 100},
                {"Albums", "Highway to Hell", BigDecimal.valueOf(23.88), "Rock", "AC/DC", "Atlantic Records", 100},

                {"Albums", "Innervisions", BigDecimal.valueOf(10.97), "Soul", "Stevie Wonder", "Tamla", 100},
                {"Albums", "Young, Gifted and Black", BigDecimal.valueOf(19.43), "Soul", "Aretha Franklin", "Atlantic; Rhino", 100},

                {"Albums", "Funky Kingston", BigDecimal.valueOf(15.60), "Reggae", "Toots and the Maytals", "Dragon Records", 100},
                {"Albums", "African Herbsman", BigDecimal.valueOf(27.22), "Reggae", "Bob Marley and the Wailers", "Trojan Records", 100},

                {"Albums", "At Folsom Prison", BigDecimal.valueOf(18.13), "Country", "Johnny Cash", "Columbia Legacy", 100},
                {"Albums", "Palomino", BigDecimal.valueOf(11.97), "Country", "Miranda Lambert", "Vanner Records", 100},

                {"Albums", "The Payback", BigDecimal.valueOf(14.99), "Funk", "James Brown", "Polydor Records", 100},
                {"Albums", "The World Is a Ghetto", BigDecimal.valueOf(18.24), "Funk", "War", "United Artists Records", 100},

                {"Albums", "Five Leaves Left", BigDecimal.valueOf(13.99), "Folk", "Nick Drake", "Island Records", 100},
                {"Albums", "The Sorrow Songs", BigDecimal.valueOf(14.99), "Folk", "Angeline Morrison", "Topic Records", 100},

                {"Albums", "Kind of Blue", BigDecimal.valueOf(7.98), "Jazz", "Miles Davis", "Columbia Records", 100},
                {"Albums", "A Love Supreme", BigDecimal.valueOf(10.98), "Jazz", "John Coltrane", "Impulse! Records", 100},

                {"Albums", "Voyage", BigDecimal.valueOf(12.20), "Disco", "ABBA", "Capitol Records", 100},
                {"Albums", "She Works Hard for the Money", BigDecimal.valueOf(18.94), "Disco", "Donna Summer", "Record Label", 100},

                {"Albums", "The Complete Recordings on Deutsche Grammophon", BigDecimal.valueOf(162.11), "Classical", "Martha Argerich", "Orpheus", 100},
                {"Albums", "Symphony No. 3 (Symphony of Sorrowful Songs); 3 Olden Style Pieces", BigDecimal.valueOf(57.11), "Classical", "Henryk Mikołaj Górecki", "NAXOS", 100},

                {"Albums", "One Love", BigDecimal.valueOf(19.52), "Electronic", "David Guetta", "Virgin Records", 100},
                {"Albums", "Blue Stahli", BigDecimal.valueOf(12.07), "Electronic", "Blue Stahli", "FiXT", 100},

                {"Albums", "Terra Brasilis", BigDecimal.valueOf(15.57), "Latin American Music", "Antônio Carlos Jobim", "Record Label", 100},
                {"Albums", "Nibiru", BigDecimal.valueOf(11.98), "Latin American Music", "Ozuna", "Aura Music", 100},

                {"Albums", "Hoodoo Man Blues", BigDecimal.valueOf(12.09), "Blues", "Junior Wells", "Delmark", 100},
                {"Albums", "Hard Again", BigDecimal.valueOf(16.99), "Blues", "Muddy Waters", "Blue Sky Records", 100},

                {"Albums", "Deep Breakfast", BigDecimal.valueOf(11.98), "New-age", "Ray Lynch", "Music West", 100},
                {"Albums", "Shepherd Moons", BigDecimal.valueOf(14.25), "New-age", "Enya", "Reprise ", 100},

                {"Albums", "Memeza", BigDecimal.valueOf(19.99), "African music", "Brenda Fassie", "CCP Records", 100},
                {"Albums", "Zombie", BigDecimal.valueOf(23.53), "African music", "Fela Kuti", "Polydor Records", 100},

                {"Albums", "There Is More", BigDecimal.valueOf(8.19), "Christian music", "Hillsong Worship", "Hillsong Music", 100},
                {"Albums", "Dominion", BigDecimal.valueOf(11.90), "Christian music", "Skillet", "Atlantic Records", 100},

                {"Albums", "One", BigDecimal.valueOf(36.24), "Islamic music", "Maher Zain", "Awakening Records", 100},
                {"Albums", "Barakah", BigDecimal.valueOf(3.99), "Islamic music", "Sami Yusuf", "Andante Records", 100},

                {"Albums", "Wrongful Meeting", BigDecimal.valueOf(21.98), "Asian music", "Kim Gun-mo", "Line Production", 100},
                {"Albums", "BE", BigDecimal.valueOf(20.0), "Asian music", "BTS", "Big Hit Entertainment", 100},

                {"Albums", "More Specials", BigDecimal.valueOf(16.29), "Ska", "The Specials", "Chrysalis Records", 100},
                {"Albums", "New York Fever", BigDecimal.valueOf(9.49), "Ska", "The Toasters", "Moon Ska Records", 100},
        };
    }
}
