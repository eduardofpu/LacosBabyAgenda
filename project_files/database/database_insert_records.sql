
INSERT INTO `lacosbaby`.`tb_permission` (`pk_id`, `role`) 
VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `lacosbaby`.`tb_permission` (`pk_id`, `role`) 
VALUES ('2', 'ROLE_USER');
INSERT INTO `lacosbaby`.`tb_permission` (`pk_id`, `role`) 
VALUES ('3', 'ROLE_VISITANTE');

INSERT INTO `lacosbaby`.`tb_user` (`pk_id`, `name`, `email`, `password`) 
VALUES ('1', 'Admin', 'admin@admin.com', '9fe76e18dd29100230680fa6c812e26c4da4b3cf48a85850910e6f4400a6b3ff9ec05190c175f592');
INSERT INTO `lacosbaby`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('1', '1');

