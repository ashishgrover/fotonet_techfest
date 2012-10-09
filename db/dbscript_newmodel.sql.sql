delimiter $$

CREATE DATABASE `fotonet_db` /*!40100 DEFAULT CHARACTER SET latin1 */$$

delimiter $$

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `published` tinyint(4) NOT NULL DEFAULT '0',
  `sharing_status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `share_status` (`sharing_status`),
  KEY `sharingstatus_fk` (`sharing_status`),
  CONSTRAINT `sharingstatus_fk` FOREIGN KEY (`sharing_status`) REFERENCES `sharingstatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `album_photos` (
  `id` int(11) NOT NULL,
  `albumid` int(11) NOT NULL,
  `photoid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `container_fk` (`albumid`),
  KEY `photos_fk` (`photoid`),
  CONSTRAINT `container_fk` FOREIGN KEY (`albumid`) REFERENCES `album` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `photos_fk` FOREIGN KEY (`photoid`) REFERENCES `photo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `buddygroup` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `buddygroups_albums` (
  `id` int(11) NOT NULL,
  `groupid` int(11) NOT NULL,
  `albumid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bgroup_fk` (`groupid`),
  KEY `albums_fk` (`albumid`),
  CONSTRAINT `bgroup_fk` FOREIGN KEY (`groupid`) REFERENCES `buddygroup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `albums_fk` FOREIGN KEY (`albumid`) REFERENCES `album` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `buddygroups_users` (
  `id` int(11) NOT NULL,
  `groupid` int(11) NOT NULL,
  `memberid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grou_fk` (`groupid`),
  KEY `member_fk` (`memberid`),
  CONSTRAINT `grou_fk` FOREIGN KEY (`groupid`) REFERENCES `buddygroup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `member_fk` FOREIGN KEY (`memberid`) REFERENCES `fotonet_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `content` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `fotonet_user` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `subscription_id` int(11) NOT NULL,
  `user_role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role` (`user_role`),
  CONSTRAINT `user_role` FOREIGN KEY (`user_role`) REFERENCES `userrole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `photo` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `physical_path` varchar(1000) NOT NULL,
  `comments_allowed` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `photo_comments` (
  `id` int(11) NOT NULL,
  `photoid` int(11) NOT NULL,
  `commentid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `photocontainer_fk` (`photoid`),
  KEY `comment_fk` (`commentid`),
  CONSTRAINT `photocontainer_fk` FOREIGN KEY (`photoid`) REFERENCES `photo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_fk` FOREIGN KEY (`commentid`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `photos_tags` (
  `id` int(11) NOT NULL,
  `photoid` int(11) NOT NULL,
  `tagid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `photo_fk` (`photoid`),
  KEY `tag_fk` (`tagid`),
  CONSTRAINT `photo_fk` FOREIGN KEY (`photoid`) REFERENCES `photo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tag_fk` FOREIGN KEY (`tagid`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `sharingstatus` (
  `id` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `content` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `user_albums` (
  `id` int(11) NOT NULL,
  `album_owner` int(11) NOT NULL,
  `albumid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_fk` (`album_owner`),
  KEY `album_fk` (`albumid`),
  CONSTRAINT `owner_fk` FOREIGN KEY (`album_owner`) REFERENCES `fotonet_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `album_fk` FOREIGN KEY (`albumid`) REFERENCES `album` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `user_buddygroups` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `groupid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_fk` (`userid`),
  KEY `group_fk` (`groupid`),
  CONSTRAINT `user_fk` FOREIGN KEY (`userid`) REFERENCES `fotonet_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `group_fk` FOREIGN KEY (`groupid`) REFERENCES `buddygroup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `userrole` (
  `id` int(11) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$




