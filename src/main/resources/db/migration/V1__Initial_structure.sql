CREATE TABLE git_projects (
  `id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `full_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner_id` BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE `git_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

