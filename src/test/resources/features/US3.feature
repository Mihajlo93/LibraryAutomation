Feature: As a librarian, I want to know the genre of books are being borrowed the most
  Scenario: verify the common book genre that’s being borrowed
    Given Establish the database connection
    When I execute a query to find the most popular book genre
    Then verify that “Classic" is the most popular book genre.

    #select bc.name,count(*) from book_borrow bb
    #    inner  join books b on bb.book_id = b.id
    #    inner join book_categories bc on b.book_category_id=bc.id
    #group by name
    #order by 2 desc;