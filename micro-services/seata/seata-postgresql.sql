-- 建立 Undo Log 表 undo_log
CREATE TABLE IF NOT EXISTS public.undo_log (
    id SERIAL PRIMARY KEY,
    branch_id BIGINT NOT NULL,
    xid VARCHAR(100) NOT NULL,
    context TEXT,
    rollback_info BYTEA,
    log_status INT NOT NULL,
    log_created TIMESTAMP NOT NULL,
    log_modified TIMESTAMP NOT NULL
);
