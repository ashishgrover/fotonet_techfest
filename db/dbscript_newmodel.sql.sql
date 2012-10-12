

CREATE  TABLE IF NOT EXISTS `fotonet_db`.`effect` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `method` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB


ALTER TABLE `fotonet_db`.`album_photos` ADD COLUMN `effect` INT NULL  AFTER `photoid` , ADD COLUMN `effect_params` VARCHAR(2000) NULL  AFTER `effect` , 
  ADD CONSTRAINT `effect_fk`
  FOREIGN KEY (`effect` )
  REFERENCES `fotonet_db`.`effect` (`id` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `effect_fk` (`effect` ASC) ;

ALTER TABLE `fotonet_db`.`userrole` ADD COLUMN `quotas` BLOB NOT NULL  AFTER `role_name` ;