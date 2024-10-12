-- 회원정보
CREATE TABLE users (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nickname VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY uk_users_nickname(nickname),
  UNIQUE KEY uk_users_email(email)
);

-- 활동
CREATE TABLE activities (
  id INT UNSIGNED  AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
  date DATE NOT NULL,
  start_time TIME NULL,
  end_time TIME NULL,
  description TEXT,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE evaluations (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  activity_id INT UNSIGNED NOT NULL,
  score UNSIGNED TINYINT NOT NULL CHECK (score BETWEEN 1 AND 10),
  comment varchar(500),
  FOREIGN KEY (activity_id) REFERENCES activities(id)
);

-- 일단위 평가 저장 테이블
CREATE TABLE daily_evaluations (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
  date DATE NOT NULL,
  score DECIMAL(3,1) NOT NULL DEFAULT 0.0,
  comment TEXT,
  UNIQUE KEY uk_daily_evaluations (user_id, date),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 주단위 평가 저장 테이블
CREATE TABLE weekly_evaluations (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
  week_start_date DATE NOT NULL,  -- 주의 첫 번째 날 (월요일)
  score DECIMAL(3,1) NOT NULL DEFAULT 0.0,
  comment TEXT,
  UNIQUE KEY uk_weekly_evaluations (user_id, week_start_date),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 월단위 평가 저장 테이블
CREATE TABLE monthly_evaluations (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
  month DATE NOT NULL,
  score DECIMAL(3,1) NOT NULL DEFAULT 0.0,
  comment TEXT,
  UNIQUE KEY uk_monthly_evaluations (user_id, month),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 년단위 평가 저장 테이블
CREATE TABLE yearly_evaluations (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
  year DATE NOT NULL,
  score DECIMAL(3,1) NOT NULL DEFAULT 0.0,
  comment TEXT,
  UNIQUE KEY uk_yearly_evaluations (user_id, year),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 일단위 평가 그룹 테이블
create table daily_evaluations_group (
  evaluation_id INT UNSIGNED not null,
  daily_evaluation_id INT UNSIGNED not null,
  PRIMARY KEY (evaluation_id, daily_evaluation_id)
  FOREIGN KEY (evaluation_id) REFERENCES evaluations(id)
  FOREIGN KEY (daily_evaluation_id) REFERENCES daily_evaluations(id)
);

-- 주 단위 평가 그룹
CREATE TABLE weekly_evaluations_group (
  daily_evaluations_group_id INT UNSIGNED NOT NULL,
  weekly_evaluation_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (daily_evaluations_group_id, weekly_evaluation_id),
  FOREIGN KEY (daily_evaluations_group_id) REFERENCES daily_evaluations_group(id),
  FOREIGN KEY (weekly_evaluation_id) REFERENCES Weekly_Evaluations(id)
);

-- 월 단위 평가 그룹
CREATE TABLE monthly_evaluations_group (
  weekly_evaluations_group_id INT UNSIGNED NOT NULL,
  monthly_evaluation_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (weekly_evaluations_group_id, monthly_evaluation_id),
  FOREIGN KEY (weekly_evaluations_group_id) REFERENCES weekly_evaluations_group(id),
  FOREIGN KEY (monthly_evaluation_id) REFERENCES monthly_evaluations(id)
);

-- 연 단위 평가 그룹
CREATE TABLE yearly_evaluations_group (
  monthly_evaluations_group_id INT UNSIGNED NOT NULL,
  yearly_evaluation_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (monthly_evaluations_group_id, yearly_evaluation_id),
  FOREIGN KEY (monthly_evaluations_group_id) REFERENCES monthly_evaluations_group(id),
  FOREIGN KEY (yearly_evaluation_id) REFERENCES yearly_evaluations(id)
);