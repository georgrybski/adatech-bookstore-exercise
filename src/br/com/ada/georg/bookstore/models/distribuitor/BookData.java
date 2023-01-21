package br.com.ada.georg.bookstore.models.distribuitor;

import java.math.BigDecimal;

public class BookData implements ProductData {
    @Override
    public Object[][] getData() {
        return new Object[][] {
//              {String name, BigDecimal price, String genre, String author, String publisher, int quantity}

                {"Books", "Journey to the Center of the Earth", BigDecimal.valueOf(169.99), "Adventure stories", "Jules Verne", "Publisher", 100},
                {"Books", "Neuromancer", BigDecimal.valueOf(30.87), "Adventure stories", "Author", "Publisher", 100},

                {"Books", "Frankenstein", BigDecimal.valueOf(7.79), "Classics", "Mary Shelley", "Lackington, Hughes, Harding, Mavor & Jones", 100},
                {"Books", "Wuthering Heights", BigDecimal.valueOf(10.59), "Classics", "Emily Brontë", "Thomas Cautley Newby", 100},

                {"Books", "The Silent Patient", BigDecimal.valueOf(12.99), "Crime", "Alex Michaelides", "Celadon Books", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Crime", "Author", "Publisher", 100},

                {"Books", "Grimm's Complete Fairy Tales", BigDecimal.valueOf(13.99), "Fairy tales, fables, and folk tales", "Jacob & Wilhelm Grimm ", "Canterbury Classics", 100},
                {"Books", "Aesop's Fables Hardcover", BigDecimal.valueOf(13.29), "Fairy tales, fables, and folk tales", "Aesop", "Publisher", 100},

                {"Books", "Dune Saga 6-Book Boxed Set", BigDecimal.valueOf(59.37), "Fantasy", "Frank Herbert", "Ace", 100},
                {"Books", "J.R.R. Tolkien 4-Book Boxed Set", BigDecimal.valueOf(71.99), "Fantasy", "J.R.R. Tolkien ", "Del Rey", 100},

                {"Books", "Metro 2033", BigDecimal.valueOf(15.27), "Historical fiction", "Dmitry Glukhovsky", "Gollancz", 100},
                {"Books", "Roadside Picnic", BigDecimal.valueOf(14.99), "Historical fiction", " Arkady & Boris Strugatsky", "Chicago Review Press", 100},

                {"Books", "Complete Cthulhu Mythos Tales", BigDecimal.valueOf(25.00), "Horror", "H. P. Lovecraft", "Barnes & Noble", 100},
                {"Books", "Three-Body Problem Boxed Set", BigDecimal.valueOf(40.99), "Horror", "Cixin Liu", "Tor Books", 100},

                {"Books", "OOF: An Online Outrage Fiesta for the ages", BigDecimal.valueOf(10.99), "Humour and satire", "Strobe Witherspoon", "Marginal Books", 100},
                {"Books", "Star Cat - Infinity Claws (Book 1)", BigDecimal.valueOf(14.99), "Humour and satire", "Andrew Mackay", "Independently published", 100},

                {"Books", "If You Tell", BigDecimal.valueOf(169.99), "Mystery", "Gregg Olsen", "Thomas & Mercer", 100},
                {"Books", "Unknown Book 10", BigDecimal.valueOf(169.99), "Mystery", "Author", "Publisher", 100},

                {"Books", "Unknown Book 11", BigDecimal.valueOf(169.99), "Poetry", "Author", "Publisher", 100},
                {"Books", "Unknown Book 12", BigDecimal.valueOf(169.99), "Poetry", "Author", "Publisher", 100},

                {"Books", "Unknown Book 13", BigDecimal.valueOf(169.99), "Plays", "Author", "Publisher", 100},
                {"Books", "Unknown Book 14", BigDecimal.valueOf(169.99), "Plays", "Author", "Publisher", 100},

                {"Books", "Unknown Book 15", BigDecimal.valueOf(169.99), "Romance", "Author", "Publisher", 100},
                {"Books", "Unknown Book 16", BigDecimal.valueOf(169.99), "Romance", "Author", "Publisher", 100},

                {"Books", "Neuromancer", BigDecimal.valueOf(30.87), "Science fiction", "William Gibson", "Ace", 100},
                {"Books", "Children of Time", BigDecimal.valueOf(12.59), "Science fiction", "Adrian Tchaikovsky", "Tor UK", 100},

                {"Books", "The World's Greatest Short Stories", BigDecimal.valueOf(5.99), "Short stories", "James Daley", "Dover Publications", 100},
                {"Books", "Fifty Great Short Stories", BigDecimal.valueOf(12.88), "Short stories", "Milton Crane", "Bantam Classics", 100},

                {"Books", "The Institute", BigDecimal.valueOf(13.79), "Thrillers", "Stephen King", "Scribner", 100},
                {"Books", "Axiom's End: Noumena Series 01", BigDecimal.valueOf(12.18), "Thrillers", "Lindsay Ellis", "St. Martin's Press", 100},

                {"Books", "Unknown Book 17", BigDecimal.valueOf(169.99), "War", "Author", "Publisher", 100},
                {"Books", "Unknown Book 18", BigDecimal.valueOf(169.99), "War", "Author", "Publisher", 100},

                {"Books", "Unknown Book 19", BigDecimal.valueOf(169.99), "Women’s fiction", "Author", "Publisher", 100},
                {"Books", "Unknown Book 20", BigDecimal.valueOf(169.99), "Women’s fiction", "Author", "Publisher", 100},

                {"Books", "Unknown Book 21", BigDecimal.valueOf(169.99), "Young adult", "Author", "Publisher", 100},
                {"Books", "Unknown Book 22", BigDecimal.valueOf(169.99), "Young adult", "Author", "Publisher", 100},

                {"Books", "Unknown Book 23", BigDecimal.valueOf(169.99), "Autobiography and memoir", "Author", "Publisher", 100},
                {"Books", "Unknown Book 24", BigDecimal.valueOf(169.99), "Autobiography and memoir", "Author", "Publisher", 100},

                {"Books", "Unknown Book 25", BigDecimal.valueOf(169.99), "Biography", "Author", "Publisher", 100},
                {"Books", "Unknown Book 26", BigDecimal.valueOf(169.99), "Biography", "Author", "Publisher", 100},

                {"Books", "Unknown Book 27", BigDecimal.valueOf(169.99), "Essays", "Author", "Publisher", 100},
                {"Books", "Unknown Book 28", BigDecimal.valueOf(169.99), "Essays", "Author", "Publisher", 100},

                {"Books", "Unknown Book 29", BigDecimal.valueOf(169.99), "Non-fiction novel", "Author", "Publisher", 100},
                {"Books", "Unknown Book 30", BigDecimal.valueOf(169.99), "Non-fiction novel", "Author", "Publisher", 100},

                {"Books", "Unknown Book 31", BigDecimal.valueOf(169.99), "Self-help", "Author", "Publisher", 100},
                {"Books", "Unknown Book 32", BigDecimal.valueOf(169.99), "Self-help", "Author", "Publisher", 100},

                {"Books", "Unknown Book 33", BigDecimal.valueOf(169.99), "Psychology", "Author", "Publisher", 100},
                {"Books", "Unknown Book 34", BigDecimal.valueOf(169.99), "Psychology", "Author", "Publisher", 100},

                {"Books", "Unknown Book 35", BigDecimal.valueOf(169.99), "Geology", "Author", "Publisher", 100},
                {"Books", "Unknown Book 36", BigDecimal.valueOf(169.99), "Geology", "Author", "Publisher", 100},

                {"Books", "Unknown Book 37", BigDecimal.valueOf(169.99), "Chemistry", "Author", "Publisher", 100},
                {"Books", "Unknown Book 38", BigDecimal.valueOf(169.99), "Chemistry", "Author", "Publisher", 100},

                {"Books", "Unknown Book 39", BigDecimal.valueOf(169.99), "Astronomy", "Author", "Publisher", 100},
                {"Books", "Unknown Book 40", BigDecimal.valueOf(169.99), "Astronomy", "Author", "Publisher", 100},

                {"Books", "Unknown Book 41", BigDecimal.valueOf(169.99), "Zoology", "Author", "Publisher", 100},
                {"Books", "Unknown Book 42", BigDecimal.valueOf(169.99), "Zoology", "Author", "Publisher", 100},

                {"Books", "Unknown Book 43", BigDecimal.valueOf(169.99), "Mathematics and logic", "Author", "Publisher", 100},
                {"Books", "Unknown Book 44", BigDecimal.valueOf(169.99), "Mathematics and logic", "Author", "Publisher", 100},

                {"Books", "The Pragmatic Programmer: Your Journey To Mastery", BigDecimal.valueOf(32.68), "Programming", "David Thomas & Andrew Hunt", "Addison-Wesley Professional", 100},
                {"Books", "Clean Code: A Handbook of Agile Software Craftsmanship", BigDecimal.valueOf(40.99), "Programming", "Robert Cecil Martin", "Pearson Education", 100},

                {"Books", "Data Science from Scratch: First Principles with Python", BigDecimal.valueOf(47.94), "Data Science", "Joel Grus", "O'Reilly Media, Inc.", 100},
                {"Books", "Designing Machine Learning Systems", BigDecimal.valueOf(28.25), "Data Science", "Chip Huyen", "O'Reilly Media, Inc.", 100},
        };
    }
}
