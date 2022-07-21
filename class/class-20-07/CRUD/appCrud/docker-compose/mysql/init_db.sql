DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `pessoas`;

CREATE TABLE `pessoas` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `pessoas` (nome) VALUES ('João'),('Maria');

DROP TABLE IF EXISTS `contas`;

CREATE TABLE `contas` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `idPessoa` bigint(20) NOT NULL,
  `numeroConta` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `movimentacoes`;

CREATE TABLE `movimentacoes` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `idConta` bigint(20) NOT NULL,
  `operacao` char(1) NOT NULL,
  `valor` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;