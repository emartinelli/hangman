CREATE TABLE hangman_db.player (
  idplayer INT,
  nickname VARCHAR(45),
  password VARCHAR(45),
  isAdmin INT,
  PRIMARY KEY (idplayer) );

CREATE  TABLE hangman_db.session (
  idSession INT,
  time INT ,
  score INT ,
  idPlayer INT ,
  idWord INT ,
  PRIMARY KEY (idSession) );

CREATE  TABLE hangman_db.word (
  idword INT,
  word VARCHAR(45) ,
  errorFrequency VARCHAR(45) ,
  PRIMARY KEY (idword) );

CREATE  TABLE hangman_db.tip (
  idtip INT,
  information VARCHAR(45) ,
  idWord INT ,
  PRIMARY KEY (idtip) );