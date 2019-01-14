CREATE TABLE product
(
  `id`          BIGINT           NOT NULL    AUTO_INCREMENT COMMENT 'id',
  `title`       VARCHAR(1000)    DEFAULT NULL        COMMENT 'title',
  `time`     DATETIME         NOT NULL     COMMENT 'time',
  PRIMARY KEY (id)
);
