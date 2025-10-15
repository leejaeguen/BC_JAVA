
// 함수 선언문 형태는 함수 호이스팅(function hoisting)이 발생한다.
console.log(hello('이순신'));

function hello(name) {
    return `${name}님 반갑소!`;
}

// 함수 표현식 형태는 함수 호이스팅이 발생하지 않는다.(에러가 발생)
console.log(hi('피카츄'));

var hi = function(name) {
    return `${name} 안녕!!`;
};

/*
    함수 선언문은 런타임 이전 자바스크립트 엔진(node.js)에 의해 먼저 해석된다.(컴파일적 요소)
    따라서 함수 선언문 이전에 함수를 참조할 수 있으며 호출할 수도 console.error('있다',있다)
    함수 선언문이 코드의 선두로 끌어올려진 것처럼 동작하는 자바스크립트 고유의 특징을
    '호이스팅'이라고 한다.
*/