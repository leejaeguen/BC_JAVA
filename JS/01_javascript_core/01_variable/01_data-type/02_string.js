var hello = "hello world!"
console.log(hello);

// Template Literal(템플릿 리터럴)
// 멀티라인, 변수삽입, 표현식 모두 템플릿 리터럴이라고 한다.

var str = `안녕하세요.
반갑습니다.`;
console.log("multiline: " + str);

var lastname = '길동';
var firstname = '홍';
console.log("제 이름은 " + lastname + " " + firstname + '입니다.');
console.log(`제 이름은 ${lastname} ${firstname} ${1 + 2}세 입니다.`)