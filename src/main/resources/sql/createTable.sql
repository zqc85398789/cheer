-- ---
-- Table 'i_staff'
-- 员工信息表
-- ---

DROP TABLE IF EXISTS `i_staff`;
		
CREATE TABLE `i_staff` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `staff_name` VARCHAR(20) NOT NULL,
  `birth_date` DATE NULL,
  `telephone_no` VARCHAR(15) NULL,
  `id_card` VARCHAR(20) NOT NULL,
  `gender` CHAR(1),
  `emergency_contact` VARCHAR(20) NULL COMMENT '紧急联系人',
  `emergency_tel` VARCHAR(15) NULL COMMENT '紧急联系电话',
  `created_time` DATETIME NOT NULL,
  `created_by` VARCHAR(20) NOT NULL,
  `update_time` DATETIME,
  `update_by` VARCHAR(20),
  `version` INTEGER DEFAULT 1,
  PRIMARY KEY (`id`)
) COMMENT '员工信息表';

-- ---
-- Table 'i_account_staff'
-- 
-- ---

DROP TABLE IF EXISTS `i_account_staff`;
		
CREATE TABLE `i_account_staff` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `account_id` INTEGER NOT NULL,
  `staff_id` INTEGER NOT NULL,
  `created_time` DATETIME NOT NULL,
  `created_by` VARCHAR(20) NOT NULL,
  `update_time` DATETIME,
  `update_by` VARCHAR(20),
  `version` INTEGER DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'i_account_privilege'
-- 
-- ---

DROP TABLE IF EXISTS `i_account_privilege`;
		
CREATE TABLE `i_account_privilege` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `account_id` INTEGER NOT NULL,
  `privilege_id` INTEGER NOT NULL,
  `created_time` DATETIME NOT NULL,
  `created_by` VARCHAR(20) NOT NULL,
  `update_time` DATETIME,
  `update_by` VARCHAR(20),
  `version` INTEGER DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'i_account'
-- 账户表
-- ---

DROP TABLE IF EXISTS `i_account`;
		
CREATE TABLE `i_account` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `account_name` VARCHAR(20) NOT NULL,
  `account_password` VARCHAR(20) NOT NULL,
  `created_time` DATETIME NOT NULL,
  `created_by` VARCHAR(20) NOT NULL,
  `update_time` DATETIME,
  `update_by` VARCHAR(20),
  `version` INTEGER DEFAULT 1,
  PRIMARY KEY (`id`)
) COMMENT '账户表';

-- ---
-- Table 'i_privilege'
-- 权限表
-- ---

DROP TABLE IF EXISTS `i_privilege`;
		
CREATE TABLE `i_privilege` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `privilege_name` VARCHAR(20) NULL,
  `privilege_url` VARCHAR(20) NULL,
  `created_time` DATETIME NOT NULL,
  `created_by` VARCHAR(20) NOT NULL,
  `update_time` DATETIME,
  `update_by` VARCHAR(20),
  `version` INTEGER DEFAULT 1,
  PRIMARY KEY (`id`)
) COMMENT '权限表';
