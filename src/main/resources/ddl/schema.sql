CREATE TABLE users (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  nickname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE activities (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  user_id UNSIGNED INT NOT NULL,
  date DATE NOT NULL,
  start_time DATETIME NULL,
  end_time DATETIME NULL,
  description TEXT,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE evaluations (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  activity_id UNSIGNED INT NOT NULL,
  score UNSIGNED TINYINT NOT NULL CHECK (score BETWEEN 1 AND 10),
  comment TEXT,
  FOREIGN KEY (activity_id) REFERENCES Activities(id)
);

-- 일단위 평가 저장 테이블
CREATE TABLE daily_evaluations (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  user_id UNSIGNED INT NOT NULL,
  date DATE NOT NULL,
  score FLOAT NOT NULL DEFAULT 0.0,
  UNIQUE KEY uk_daily_evaluations (user_id, date),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 주단위 평가 저장 테이블
CREATE TABLE weekly_evaluations (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  user_id UNSIGNED INT NOT NULL,
  week_start_date DATE NOT NULL,  -- 주의 첫 번째 날 (월요일)
  score FLOAT NOT NULL DEFAULT 0.0,
  UNIQUE KEY uk_weekly_evaluations (user_id, week_start_date),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 월단위 평가 저장 테이블
CREATE TABLE monthly_evaluations (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  user_id UNSIGNED INT NOT NULL,
  month DATE NOT NULL,
  score FLOAT NOT NULL DEFAULT 0.0,
  UNIQUE KEY uk_monthly_evaluations (user_id, month),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 년단위 평가 저장 테이블
CREATE TABLE yearly_evaluations (
  id UNSIGNED INT AUTO_INCREMENT PRIMARY KEY,
  user_id UNSIGNED INT NOT NULL,
  year DATE NOT NULL,
  score FLOAT NOT NULL DEFAULT 0.0,
  UNIQUE KEY uk_yearly_evaluations (user_id, year),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 일단위 평가 그룹 테이블
create table daily_evaluations_group (
  evaluation_id UNSIGNED INT not null,
  daily_evaluation_id UNSIGNED INT not null,
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