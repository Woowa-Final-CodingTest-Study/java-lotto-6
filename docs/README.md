# 기능 구현 목록

## 절차적 기능
1. `구입금액을 입력해 주세요.`를 출력하고 구입 금액을 입력받는다.
2. 구매한 로또 개수와 발행한 로또 번호를 출력한다.
3. `당첨 번호를 입력해 주세요.`를 출력하고 당첨 번호를 입력받는다.
4. `보너스 번호를 입력해 주세요.`를 출력하고 보너스 번호를 입력받는다.
5. 당첨 통계와 수익률을 출력한다.

## 세부 기능

### 구입 금액 입력
- 구입 금액을 천 원 단위로 입력받는다.
- 구입 금액에 대한 예외는 다음과 같이 처리한다.
  - 숫자가 아닌 경우: `IllegalArgumentException`
  - 양수가 아닌 경우: `IllegalArgumentException`
  - 천 원 단위가 아닌 경우: `IllegalArgumentException`

### 로또 번호 생성
- 로또 번호는 1-45 사이에서 중복 숫자가 없이 6개를 생성한다.
- 로또 번호에 대한 예외는 다음과 같이 처리한다.
  - 6개가 아닌 경우: `IllegalArgumentException`
  - 범위 밖의 숫자가 있는 경우: `IllegalArgumentException`
  - 중복된 숫자가 있는 경우: `IllegalArgumentException`

### 로또 번호 입력
- 로또 번호는 1-45 사이에서 중복 숫자가 없이 6개를 입력받는다.
- 로또 번호에 대한 예외는 다음과 같이 처리한다.
  - 6개가 아닌 경우: `IllegalArgumentException`
  - 숫자가 아닌 경우: `IllegalArgumentException`
  - 범위 밖의 숫자가 있는 경우: `IllegalArgumentException`
  - 중복된 숫자가 있는 경우: `IllegalArgumentException`

### 보너스 번호 입력
- 보너스 번호는 1-45 사이에서 중복 숫자가 없이 입력받는다.
- 보너스 번호에 대한 예외는 다음과 같이 처리한다.
  - 숫자가 아닌 경우: `IllegalArgumentException`
  - 범위 밖의 숫자가 있는 경우: `IllegalArgumentException`
  - 로또 번호와 중복된 숫자가 있는 경우: `IllegalArgumentException`

### 당첨 통계 및 수익률 출력
- 당첨 통계는 5등부터 역순으로 출력한다.
- 수익률은 [수익 금액]/[구입 금액]으로 계산한다.
- 수익률은 소숫점 아래 1자리까지, %단위로 출력한다.

