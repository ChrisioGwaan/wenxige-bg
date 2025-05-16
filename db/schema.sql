CREATE TABLE `sys_user` (
    `id`                    VARCHAR     ( 256 )     NOT NULL                    COMMENT 'User UUID',
    `avatar_file_id`        BIGINT      ( 20 )      DEFAULT NULL                COMMENT 'Avatar file ID 头像文件ID',
    `username`              VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Username 用戶名',
    `firstname`             VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'User first name 名字',
    `lastname`              VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'User last name 姓氏',
    `password`              VARCHAR     ( 128 )     NOT NULL                    COMMENT 'User password 密码（加密）',
    `email`                 VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'User email 电子邮箱',
    `sys_role_id`           INT         ( 8 )       DEFAULT NULL                COMMENT 'User role ID 用戶角色ID',
    `create_user`           VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                NOT NULL                    COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                DEFAULT NULL                COMMENT 'Modified time 修改時間',
    `is_locked`             CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Lock status 禁用狀態 0-啟用 1-禁用',
    `is_del`                CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'System User Info 系統用戶信息表';

CREATE TABLE `sys_file` (
    `id`                    BIGINT      ( 20 )      NOT NULL                    COMMENT 'File ID 文件ID',
    `file_name`             VARCHAR     ( 256 )     NOT NULL                    COMMENT 'File name 文件名稱',
    `bucket_name`           VARCHAR     ( 256 )     NOT NULL                    COMMENT 'Bucket name 桶名',
    `path`                  VARCHAR     ( 256 )     NOT NULL                    COMMENT 'Path of the file 文件路徑',
    `type`                  VARCHAR     ( 256 )     NOT NULL                    COMMENT 'Type of the file 文件類型',
    `size`                  BIGINT      ( 20 )      NOT NULL                    COMMENT 'Size of the file 文件大小 (KB)',
    `create_user`           VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                NOT NULL                    COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                DEFAULT NULL                COMMENT 'Modified time 修改時間',
    `is_del`                CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'System File Info 系統文件信息表';

CREATE TABLE `sys_role` (
    `id`                    BIGINT      ( 20 )      NOT NULL                    COMMENT 'Role ID 角色ID',
    `role_name`             VARCHAR     ( 256 )     NOT NULL                    COMMENT 'Role name 角色名稱',
    `create_user`           VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                NOT NULL                    COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                DEFAULT NULL                COMMENT 'Modified time 修改時間',
    `is_del`                CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'System Role Info 系統角色信息表';

CREATE TABLE `sys_tenant` (
    `id`                    BIGINT      ( 20 )      NOT NULL                    COMMENT 'Tenant ID 租戶ID',
    `tenant_name`           VARCHAR     ( 128 )     NOT NULL                    COMMENT 'Tenant name 租戶名稱',
    `currency`              VARCHAR     ( 128 )     NOT NULL                    COMMENT 'Currency of the tenant 租戶貨幣',
    `country`               VARCHAR     ( 128 )     NOT NULL                    COMMENT 'Country of the tenant 租戶國家',
    `status`                INT         ( 8 )       NOT NULL                    COMMENT 'Tenant status 租戶狀態',
    `create_user`           VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                NOT NULL                    COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                DEFAULT NULL                COMMENT 'Modified time 修改時間',
    `is_del`                CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'System Tenant Info 系統租戶信息表';

CREATE TABLE `brand` (
    `id`                    BIGINT      ( 20 )      NOT NULL                    COMMENT 'Brand ID 品牌ID',
    `brand_name`            VARCHAR     ( 256 )     NOT NULL                    COMMENT 'Name of the brand 品牌名稱',
    `origin_year`           INT         ( 8 )       NOT NULL                    COMMENT 'Origin year of the brand 品牌起源年',
    `brand_description`     VARCHAR     ( 512 )     DEFAULT NULL                COMMENT 'Brand description 品牌描述',
    `create_user`           VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                NOT NULL                    COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                DEFAULT NULL                COMMENT 'Modified time 修改時間',
    `is_del`                CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'Brand Info 品牌信息表';

CREATE TABLE `brand_file` (
    `brand_id`              BIGINT      ( 20 )      NOT NULL                    COMMENT 'Brand ID 品牌ID',
    `sys_file_id`           BIGINT      ( 20 )      NOT NULL                    COMMENT 'File ID 文件ID'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'Brand File Info 品牌文件信息表';

CREATE TABLE `category` (
    `id`                    BIGINT      ( 20 )      NOT NULL                    COMMENT 'Category ID 類別ID',
    `brand_id`              BIGINT      ( 20 )      NOT NULL                    COMMENT 'Brand ID 品牌ID',
    `category_name`         VARCHAR     ( 256 )     NOT NULL                    COMMENT 'Name of the category 類別名稱',
    `category_description`  VARCHAR     ( 512 )     DEFAULT NULL                COMMENT 'Category description 類別描述',
    `create_user`           VARCHAR     ( 64 )      NOT NULL                    COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )      DEFAULT NULL                COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                NOT NULL                    COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                DEFAULT NULL                COMMENT 'Modified time 修改時間',
    `is_del`                CHAR        ( 1 )       DEFAULT '0' NOT NULL        COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'Category Info 類別信息表';

CREATE TABLE `product` (
    `id`                    BIGINT      ( 20 )          NOT NULL                COMMENT 'Product ID 產品ID',
    `category_id`           BIGINT      ( 20 )          NOT NULL                COMMENT 'Category ID 類別ID',
    `product_name`          VARCHAR     ( 256 )         NOT NULL                COMMENT 'Name of the product 產品名稱',
    `product_description`   VARCHAR     ( 512 )         DEFAULT NULL            COMMENT 'Description of the product 產品描述',
    `cost_price`            DECIMAL     ( 16, 2 )       NOT NULL                COMMENT 'Cost price 成本價格',
    `sell_price`            DECIMAL     ( 16, 2 )       NOT NULL                COMMENT 'Sell price 銷售價格',
    `product_weight`        DECIMAL     ( 16, 2 )       NOT NULL                COMMENT 'Weight of the product 產品重量',
    `sku`                   VARCHAR     ( 64 )          NOT NULL                COMMENT 'SKU of the product 產品SKU',
    `barcode`               VARCHAR     ( 64 )          DEFAULT NULL            COMMENT 'Barcode of the product 產品條形碼',
    `stock`                 INT         ( 16 )          DEFAULT 0 NOT NULL      COMMENT 'Stock of the product 產品庫存',
    `stock_threshold`       INT         ( 16 )          DEFAULT 0 NOT NULL      COMMENT 'Stock threshold 庫存閾值',
    `unit_id`               BIGINT      ( 20 )          NOT NULL                COMMENT 'Unit ID 單位ID',
    `create_user`           VARCHAR     ( 64 )          NOT NULL                COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )          DEFAULT NULL            COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                    NOT NULL                COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                    DEFAULT NULL            COMMENT 'Modified time 修改時間',
    `is_lock`               CHAR        ( 1 )           DEFAULT '0' NOT NULL    COMMENT 'Lock status 禁用狀態 0-啟用 1-禁用',
    `is_del`                CHAR        ( 1 )           DEFAULT '0' NOT NULL    COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8mb4 COMMENT = 'Product Info 產品信息表';

CREATE TABLE `product_file` (
    `product_id`            BIGINT      ( 20 )          NOT NULL                COMMENT 'Product ID 產品ID',
    `sys_file_id`           BIGINT      ( 20 )          NOT NULL                COMMENT 'File ID 文件ID'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'Product File Info 產品文件信息表';

CREATE TABLE `product_unit` (
    `id`                    BIGINT      ( 20 )          NOT NULL                COMMENT 'Product unit ID 產品單位ID',
    `unit_name`             VARCHAR     ( 32 )          NOT NULL                COMMENT 'Name of the unit 單位名稱',
    `create_user`           VARCHAR     ( 64 )          NOT NULL                COMMENT 'Create user 創建的用戶名',
    `modified_user`         VARCHAR     ( 64 )          DEFAULT NULL            COMMENT 'Modified user 修改的用戶名',
    `create_time`           DATETIME                    NOT NULL                COMMENT 'Create time 創建時間',
    `modified_time`         DATETIME                    DEFAULT NULL            COMMENT 'Modified time 修改時間',
    `is_del`                CHAR        ( 1 )           DEFAULT '0' NOT NULL    COMMENT 'Deletion status 刪除狀態 0-正常 1-已刪除',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = 'Product Unit Info 產品單位信息表';
