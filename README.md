# Unit Testing의 7.2절의 샘플을 응용해보는 공간입니다.

`블라디미르 코리코프`의 [Unit Testing](https://product.kyobobook.co.kr/detail/S000001805070)의 `7.2 가치 있는 단위 테스트를 위한 리팩터링하기`내 예제인 `CRM 시스템의 초기 구현`을 따라해보고 응용해보는 공간입니다.

## 유스케이스

사용자 이메일을 변경한다.

## 비즈니스 규칙

- 사용자 이메일이 회사 도메인에 속한 경우 해당 사용자는 직원으로 표시된다. 그렇지 않으면 고객으로 간주한다.
- 시스템은 회사의 직원 수를 추적해야 한다. 사용자 유형이 직원에서 고객으로, 또는 그 반대로 변겨오디면 이 숫자도 변경해야 한다.
- 이메일이 변경되면 시스템은 메시지 버스로 메시지를 보내 외부 시스템에 알려야 한다.

## 패키지 소개

- com.ho.study.unit.testing.changeemail.example7_1 : 예제 7.1 `CRM 시스템의 초기 구현`을 자바 스타일로 변경한다.
- com.ho.study.unit.testing.changeemail.example7_2 : 예제 7.2 `애플리케이션 서비스, 버전 1`을 자바 스타일로 변경한다.
- com.ho.study.unit.testing.changeemail.example7_3 : 예제 7.3 `User 팩토리 클래스`을 자바 스타일로 변경한다.

## 느낌

### 예제 7.1

User 라는 클래스가 실무에서 사용하는 JPA 의 엔티티로 인식되는데 그 로직안에 데이터베이스 객체와 메시지버스 객체가 들어있는데 어색하게 느껴졌습니다.

그래서 임의로 데이터베이스 객체와 메시지 버스 객체를 구현하여 코드 스타일을 맞추고자 했습니다.

추가적으로 도메인 레이어를 테스트하려고 하는데 외부 의존성인 데이터베이스에 데이터를 입력해야해서 통합 테스트 느낌으로 다가왔습니다.

### 예제 7.2

확실히 험블 컨트롤러를 정의하여 외부 의존성을 할당하고 도메인 모델에 비즈니스 로직만 남기니 이메일을 변경하는 비즈니스 로직을 테스트 하기가 편해졌습니다.

그리고 험블 컨트롤러는 마땅한 비즈니스 로직이 없으므로 테스트를 할 가치가 사라졌습니다.

`예제 7.1` 과 비교하여 테스트 복잡도는 낮아졌지만 테스트 유효성은 동일하다는 느낌이 듭니다.

## 예제 7.3

사용자 팩토리를 만듬으로 인해서 스크립트형 로직을 의미단위로 묶을 수 있어 인지적으로 읽기 편해졌습니다.

그리고 사용자 팩토리로 외부 의존성이 격리된 공간이 생김으로 인해 데이터 정합성을 위한 테스트로 쉬워졌습니다.