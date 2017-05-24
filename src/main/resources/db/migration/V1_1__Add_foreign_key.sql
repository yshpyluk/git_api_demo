--ALTER TABLE git_projects ADD FOREIGN KEY (owner_id) REFERENCES git_users;

ALTER TABLE `git_projects`
ADD INDEX `owner_id_idx` (`owner_id` ASC);

ALTER TABLE `git_projects`
ADD CONSTRAINT `owner_id`
  FOREIGN KEY (`owner_id`)
  REFERENCES `git_users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
