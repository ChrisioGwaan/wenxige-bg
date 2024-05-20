CREATE TABLE `sys_user` (
  `id` VARCHAR ( 255 ) NOT NULL COMMENT 'User UUID',
  `username` VARCHAR ( 64 ) NOT NULL COMMENT 'Username',
  `firstname` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'User first name',
  `lastname` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'User last name',
  `password` VARCHAR ( 512 ) NOT NULL COMMENT 'User password',
  `email` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'User email',
  `is_del` CHAR ( 1 ) DEFAULT '0' COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'System User Info';

ALTER TABLE sys_user ADD COLUMN create_time DATETIME NOT NULL COMMENT 'Creation Datetime' AFTER email;
ALTER TABLE sys_user ADD COLUMN modified_time DATETIME DEFAULT NULL COMMENT 'Modified Datetime' AFTER create_time;
ALTER TABLE sys_user ADD COLUMN role VARCHAR(64) DEFAULT NULL COMMENT 'Account Role' AFTER email;

ALTER TABLE sys_user ADD create_user VARCHAR ( 64 ) NOT NULL COMMENT 'Create user 創建的用戶名' AFTER role,
ADD modified_user VARCHAR ( 64 ) DEFAULT NULL COMMENT 'Modified user 修改的用戶名' AFTER create_user;

CREATE TABLE `product` (
  `id` BIGINT ( 20 ) NOT NULL COMMENT 'Product ID 產品ID',
  `brand_type_id` BIGINT ( 20 ) NOT NULL COMMENT 'Type ID of the specific brand 產品所在品牌的種類id',
  `product_name` VARCHAR ( 255 ) NOT NULL COMMENT 'Name of the product 產品名稱',
  `specification` VARCHAR ( 255 ) NOT NULL COMMENT 'Specification of the product 產品規格',
  `manufacture_date` DATE DEFAULT NULL COMMENT 'Manufacture date of the product 產品生產日期',
  `has_specific_day` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'If the manufacture date has a specific day 生產日期是否精確到天',
  `retail_price` DECIMAL ( 32, 2 ) DEFAULT 0 NOT NULL COMMENT 'National uniform retail price 全國統一零售價',
  `sell_price` DECIMAL ( 32, 2 ) DEFAULT 0 NOT NULL COMMENT 'Sell price (Take retail price if sell price is not specifically set) 銷售價格（如無特殊情況，取統一零售價）',
  `unit_type` INT ( 3 ) DEFAULT NULL COMMENT 'Unit type of the product 單位類型',
  `current_quantity` INT ( 12 ) DEFAULT 0 NOT NULL COMMENT 'Current quantity of the product 產品現有數量',
  `comment` VARCHAR ( 512 ) DEFAULT NULL COMMENT 'Comment 備註',
  `create_user` VARCHAR ( 64 ) NOT NULL COMMENT 'Create user 創建的用戶名',
  `modified_user` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'Modified user 修改的用戶名',
  `create_time` DATETIME NOT NULL COMMENT 'Create time 創建時間',
  `modified_time` DATETIME DEFAULT NULL COMMENT 'Modified time 修改時間',
  `is_lock` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Lock status 禁用狀態 0-啟用 1-禁用',
  `is_del` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8mb4 COMMENT = 'Product 產品表';

CREATE TABLE `brand` (
  `id` BIGINT ( 20 ) NOT NULL COMMENT 'Brand ID 品牌ID',
  `brand_name` VARCHAR ( 255 ) NOT NULL COMMENT 'Name of the brand 品牌名稱',
  `origin_year` YEAR DEFAULT NULL COMMENT 'Origin year of the brand 品牌起源年',
  `comment` VARCHAR ( 512 ) DEFAULT NULL COMMENT 'Comment 備註',
  `create_user` VARCHAR ( 64 ) NOT NULL COMMENT 'Create user 創建的用戶名',
  `modified_user` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'Modified user 修改的用戶名',
  `create_time` DATETIME NOT NULL COMMENT 'Create time 創建時間',
  `modified_time` DATETIME DEFAULT NULL COMMENT 'Modified time 修改時間',
  `is_lock` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Lock status 禁用狀態 0-啟用 1-禁用',
  `is_del` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8mb4 COMMENT = 'Brand 品牌表';

CREATE TABLE `brand_type` (
  `id` BIGINT ( 20 ) NOT NULL COMMENT 'Brand Type ID 品牌種類ID',
  `brand_id` BIGINT ( 20 ) NOT NULL COMMENT 'Brand ID 品牌ID',
  `brand_type_name` VARCHAR ( 255 ) NOT NULL COMMENT 'Name of the brand type 品牌種類名稱',
  `comment` VARCHAR ( 512 ) DEFAULT NULL COMMENT 'Comment 備註',
  `create_user` VARCHAR ( 64 ) NOT NULL COMMENT 'Create user 創建的用戶名',
  `modified_user` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'Modified user 修改的用戶名',
  `create_time` DATETIME NOT NULL COMMENT 'Create time 創建時間',
  `modified_time` DATETIME DEFAULT NULL COMMENT 'Modified time 修改時間',
  `is_lock` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Lock status 禁用狀態 0-啟用 1-禁用',
  `is_del` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8mb4 COMMENT = 'Brand Type 品牌種類表';

CREATE TABLE `sys_file` (
  `id` BIGINT ( 20 ) NOT NULL COMMENT 'File ID 文件ID',
  `file_name` VARCHAR ( 512 ) DEFAULT NULL COMMENT 'File name 文件名稱',
  `bucket_name` VARCHAR ( 512 ) DEFAULT NULL COMMENT 'Bucket name 桶名',
  `path` VARCHAR ( 512 ) DEFAULT NULL COMMENT 'Path of the file 文件路徑',
  `type` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'Type of the file 文件類型',
  `size` BIGINT ( 64 ) DEFAULT NULL COMMENT 'Size of the file 文件大小 (KB)',
  `create_user` VARCHAR ( 64 ) NOT NULL COMMENT 'Create user 創建的用戶名',
  `modified_user` VARCHAR ( 64 ) DEFAULT NULL COMMENT 'Modified user 修改的用戶名',
  `create_time` DATETIME NOT NULL COMMENT 'Create time 創建時間',
  `modified_time` DATETIME DEFAULT NULL COMMENT 'Modified time 修改時間',
  `is_del` CHAR ( 1 ) DEFAULT '0' NOT NULL COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'sys_file 文件管理表';