-- 如果表已經存在，先刪除它們
DROP TABLE IF EXISTS distributed_lock;
DROP TABLE IF EXISTS global_table;
DROP TABLE IF EXISTS branch_table;
DROP TABLE IF EXISTS lock_table;
DROP TABLE IF EXISTS undo_log;

-- 建立分布式鎖表 distributed_lock
CREATE TABLE distributed_lock (
    lock_key VARCHAR(64) NOT NULL PRIMARY KEY,
    lock_value VARCHAR(64),
    expire BIGINT
);

-- 建立全局事務表 global_table

CREATE TABLE global_table (
  xid VARCHAR(128) NOT NULL, -- 全局事務 ID
  transaction_id BIGSERIAL NOT NULL, -- 事務編號
  status INT NOT NULL, -- 事務狀態，使用 Seata 的事務狀態常數
  transaction_service_group VARCHAR(128) NOT NULL, -- 事務服務組
  transaction_name VARCHAR(128) NOT NULL, -- 事務名稱
  timeout INT NOT NULL, -- 事務超時時間，單位：秒
  begin_time BIGINT NOT NULL, -- 事務開始時間
  application_id VARCHAR(32) NOT NULL, -- 應用 ID
  client_id VARCHAR(128) NOT NULL, -- 客戶端 ID
  gmt_create TIMESTAMP NOT NULL, -- 創建時間
  gmt_modified TIMESTAMP NOT NULL, -- 最後修改時間
  PRIMARY KEY (xid)
);

-- 建立分支事務表 branch_table
CREATE TABLE branch_table (
    branch_id BIGINT NOT NULL PRIMARY KEY,
    xid VARCHAR(128) NOT NULL,
    transaction_id BIGINT,
    resource_group_id VARCHAR(32),
    resource_id VARCHAR(256),
    branch_type VARCHAR(8),
    status SMALLINT,
    client_id VARCHAR(64),
    application_data VARCHAR(2000),
    gmt_create TIMESTAMP,
    gmt_modified TIMESTAMP
);

-- 建立鎖表 lock_table
CREATE TABLE lock_table (
    row_key VARCHAR(128) NOT NULL PRIMARY KEY,
    xid VARCHAR(96),
    transaction_id BIGINT,
    branch_id BIGINT,
    resource_id VARCHAR(256),
    table_name VARCHAR(32),
    pk VARCHAR(36),
    gmt_create TIMESTAMP,
    gmt_modified TIMESTAMP
);

-- 建立 Undo Log 表 undo_log
CREATE TABLE undo_log (
    id SERIAL PRIMARY KEY,
    branch_id BIGINT NOT NULL,
    xid VARCHAR(100) NOT NULL,
    context TEXT,
    rollback_info BYTEA,
    log_status INT NOT NULL,
    log_created TIMESTAMP NOT NULL,
    log_modified TIMESTAMP NOT NULL
);
