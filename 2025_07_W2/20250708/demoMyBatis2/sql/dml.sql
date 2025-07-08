-- 個別会員照会
SELECT * FROM test_tbl WHERE id = 'ayqi8103';

-- 個別会員情報装入（生成）
INSERT INTO test_tbl (id, name, address)
VALUES ('kkk666', 'VIVID', 'home town');