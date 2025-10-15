var dog = {
    name: '뽀삐',
    eat: function(food) {

        // 메서드의 this는 메서드를 호출한 객체(나의 객체), 매개변수와 일치하는 변수는 지역변수
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요.`)
    }
}

// 매개변수 1인 메서드라도 인수가 없이도, 혹은 더 추가로 주어져도 호출됨(동작함)
dog.eat();
dog.eat('사료');
dog.eat('사료', '딸기');