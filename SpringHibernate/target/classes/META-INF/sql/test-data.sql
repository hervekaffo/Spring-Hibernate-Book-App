INSERT INTO `author` (`ID`, `FIRST_NAME`, `LAST_NAME`, `DESCRIPTION`) VALUES
(1, 'John ', 'Smith', 'very young and popular author'),
(2, 'Daniel ', 'Perkins ', 'new and revolutionary author'),
(3, 'Jet', 'Li', 'From China and very well established in the authors list'),
(4, 'Marcus', 'Wall', 'specialized in Mysql and brought a huge plus to this community');


INSERT INTO `category` (`ID`, `NAME`) VALUES
(1, 'Java'),
(2, 'Mysql');

INSERT INTO `book` (`ID`, `CATEGORY_ID`, `ISBN`, `TITLE`, `PRICE`) VALUES
(1, 1, '1457896545', 'Beegining Java', '61'),
(2, 1, '5485632322', 'Java Entreprise Edit', '70'),
(3, 2, '5765522262', 'Mysql Concepts ', '46'),
(4, 2, '7523232223', 'Beegining Mysql ', '49'),
(5, 1, '4875656565', 'Java for non program', '86'),
(6, 1, '457565656', 'Advanced Java Concep', '66');

INSERT INTO `author_book` (`AUTHOR_ID`, `BOOK_ID`) VALUES
(1, 1),
(1, 2),
(1, 7),
(2, 1),
(2, 2),
(2, 7),
(3, 1),
(3, 2),
(3, 3),
(3, 5),
(3, 6),
(4, 2),
(4, 4),
(4, 6);





