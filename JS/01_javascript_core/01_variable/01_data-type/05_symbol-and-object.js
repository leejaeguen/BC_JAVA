// 첫 글자가 대문자인 Symbol이라는 함수를 호출하면 Symbol 타입이 생성
var sym1 = Symbol();
var sym2 = Symbol();
console.log(sym1 == sym2);  // 다른 symbol 타입이다.

var sym3 = Symbol('설명');
var sym4 = Symbol('설명');
console.log(sym3 == sym4);
console.log(sym3.description);  // Symbol 타입의 description 속성(property)에 접근
console.log(sym4.description);
console.log(typeof sym3);

// 리터럴 객체({})를 생성 추후에 동적으로 프로퍼티(속성)을 추가 및 제거할 수 있다.
var obj = {}; // 리터럴 객체
console.log(typeof obj);    // object
obj['일반속성'] = '일반';   // 대괄호([])는 객체의 속성에 접근 또는 없으면 추가하는 개념
console.log(obj);
obj['일반속성'] = '일반2';
console.log(obj);

// Symbol 타입 사용 이후
// 1. 같은 값을 가진 symbol 타입은 다른 프로퍼티로 인지한다.
obj[sym3] = '값1';
obj[sym4] = '값2';
console.log(obj);
console.log(obj[sym3]);

// 2. 숨김 프로퍼티를 적용하기 위해
var hidden = Symbol('숨김 프로퍼티');
obj[hidden] = '비밀 값';
obj['name'] = '홍길동';
console.log(obj);
console.log(Object.keys(obj));  // Object.keys()에 던저진 인수(obj)가 가진 프로퍼티 키값을 배열로 반환
                                // (Symbol 타입은 제외)