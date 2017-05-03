-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lacosbaby
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lacosbaby
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lacosbaby` DEFAULT CHARACTER SET utf8 ;
USE `lacosbaby` ;

-- -----------------------------------------------------
-- Table `lacosbaby`.`tb_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lacosbaby`.`tb_clientes` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_bairro` VARCHAR(255) NOT NULL,
  `tb_endereco` VARCHAR(255) NOT NULL,
  `tb_nome` VARCHAR(255) NOT NULL,
  `tb_numero` VARCHAR(10) NOT NULL,
  `tb_telefone` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_dgeg7qo8dfdrgpp021rf9sj6x` (`tb_telefone` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lacosbaby`.`tb_modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lacosbaby`.`tb_modelo` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_cor` VARCHAR(255) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `tb_modelo` VARCHAR(255) NOT NULL,
  `tb_tamanho` VARCHAR(255) NOT NULL,
  `tb_valor` DECIMAL(19,2) NOT NULL,
  PRIMARY KEY (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lacosbaby`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lacosbaby`.`tb_pedido` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_data_entrega` DATETIME NOT NULL,
  `tb_descricao` VARCHAR(500) NOT NULL,
  `register_date` DATETIME NOT NULL,
  `tb_total` DECIMAL(19,2) NOT NULL,
  `id_clientes` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_6atc41u8xs9ghp019g0fohrpf` (`id_clientes` ASC),
  CONSTRAINT `FK_6atc41u8xs9ghp019g0fohrpf`
    FOREIGN KEY (`id_clientes`)
    REFERENCES `lacosbaby`.`tb_clientes` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lacosbaby`.`tb_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lacosbaby`.`tb_permission` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_rwvnf9dhenmknvljgery79idd` (`role` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lacosbaby`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lacosbaby`.`tb_user` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(120) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_4vih17mube9j7cqyjlfbcrk4m` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lacosbaby`.`tb_user_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lacosbaby`.`tb_user_permission` (
  `permission_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`permission_id`, `user_id`),
  INDEX `FK_l6cvhr5w2r9ff429fa5eqxmyo` (`user_id` ASC),
  CONSTRAINT `FK_44w3gaqxmtfvn2xslng1a5pi0`
    FOREIGN KEY (`permission_id`)
    REFERENCES `lacosbaby`.`tb_permission` (`pk_id`),
  CONSTRAINT `FK_l6cvhr5w2r9ff429fa5eqxmyo`
    FOREIGN KEY (`user_id`)
    REFERENCES `lacosbaby`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
