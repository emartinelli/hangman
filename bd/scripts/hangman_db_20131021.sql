SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`player`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`player` (
  `idplayer` INT NOT NULL AUTO_INCREMENT ,
  `nickname` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `isAdmin` BINARY NOT NULL ,
  PRIMARY KEY (`idplayer`) ,
  UNIQUE INDEX `playercol_UNIQUE` (`nickname` ASC) )
ENGINE = InnoDB
COMMENT = '\n';


-- -----------------------------------------------------
-- Table `mydb`.`session`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`session` (
  `idSession` INT NOT NULL ,
  `time` INT NULL ,
  `score` INT NULL ,
  `idPlayer` INT NULL ,
  `idWord` INT NULL ,
  PRIMARY KEY (`idSession`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`word`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`word` (
  `idword` INT NOT NULL ,
  `word` VARCHAR(45) NOT NULL ,
  `errorFrequency` VARCHAR(45) NULL ,
  PRIMARY KEY (`idword`) ,
  UNIQUE INDEX `word_UNIQUE` (`word` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tip`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`tip` (
  `idtip` INT NOT NULL ,
  `information` VARCHAR(45) NULL ,
  `idWord` INT NULL ,
  PRIMARY KEY (`idtip`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
