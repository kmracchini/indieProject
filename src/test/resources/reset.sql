delete from user;
delete from designer;
delete from pattern;
delete from favorites;
INSERT INTO user VALUES (1,'kracchini@madisoncollege.edu','kmracchini','Kristin Racchini', true),(2,'rey@macarthurpark.com','ReyTheCat','Rey Hinnendael', false), (3,'maleficent@macarthurpark.com','QueenOfMean','Maleficent Racchini', false);
INSERT INTO designer VALUES(1,'Subversive Cross Stitch', 'https://subversivecrossstitch.com/','SCSlogo.jpg',5460739), (2,'The Witchy Stitcher','https://www.thewitchystitcher.com/','witchystitcher.jpg',16747586);
INSERT INTO pattern VALUES(1, 'Blood Moon', 86, 101, 5, 'Spooky, Halloween, Moon', 'Full Stitches Only', 'No', 'witchy-stitcher-blood-moon.jpg', 'https://www.thewitchystitcher.com/freebies', 2), (2, 'Fancy Font', 15, 15, 1, 'Font', 'Full Stitches Only', 'No', 'scs-fancy-font.jpg', 'https://subversivecrossstitch.com/products/free-fancy-font-pdf-version', 1);
INSERT INTO favorites VALUES (1,1,1), (2,1,2), (3,2,1);