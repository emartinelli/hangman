CREATE SCHEMA hangman_db;

CREATE TABLE hangman_db.player (
  idplayer INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  nickname VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  isAdmin INTEGER NULL,
  PRIMARY KEY (idplayer) );
  
CREATE  TABLE hangman_db.word (
  idword INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  realWord VARCHAR(45) NOT NULL,
  errorFrequency VARCHAR(45) ,
  PRIMARY KEY (idword) );

CREATE  TABLE hangman_db.session (
  idSession INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  timeSession INTEGER,
  score INTEGER NOT NULL,
  idPlayer INTEGER NOT NULL,
  idWord INTEGER NOT NULL,
  FOREIGN KEY (idPlayer) REFERENCES hangman.player (idPlayer) ON DELETE CASCADE,
  FOREIGN KEY (idWord) REFERENCES hangman_db.word (idWord) ON DELETE CASCADE,
  PRIMARY KEY (idSession) );

CREATE  TABLE hangman_db.tip (
  idtip INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  information VARCHAR(45),
  idWord INTEGER,
  FOREIGN KEY (idWord) REFERENCES hangman_db.word (idWord) ON DELETE CASCADE,
  PRIMARY KEY (idtip) );