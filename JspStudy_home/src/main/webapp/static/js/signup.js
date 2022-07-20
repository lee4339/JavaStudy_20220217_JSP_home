const itemInputs = document.querySelectorAll(".item-input");
const usernameInput = itemInputs[2].querySelector("input");
const signupBtn = document.querySelector(".signup-button");


let usernameCheckFlag = "true";

signupBtn.onclick = () => {
	let emptyFlag = true;
	for(let i = 0; i < itemInputs.length; i++) {
		let inputValue = itemInputs[i].querySelector("input").value;
		emptyFlag = isEmpty(inputValue) ? true : false;
		if(emptyFlag == true) {
			let inputLable = itemInputs[i].querySelector("label").textContent;
			alert(inputLable + "을(를) 입력해주세요.");
			return;
		}
	}
	
	if(usernameCheckFlag == "true"){
		alert("사용자 이름 중복확인을 해주세요.");
	} else {
		document.querySelector("form").submit();
	} 
}



function isEmpty(str) {
	let flag = true;

	if (str == "" || typeof str == "undefined" || str == null) {
		flag = true;
	} else {
		flag = false;
	}

	return flag;
}

usernameInput.onblur = () => {
	let username = usernameInput.value;

	if (isEmpty(username)) {
		alert("사용자 아이디를 입력해주세요.");
		usernameCheckFlag = "true";
	} else {
		$.ajax({ // ajax 기본 메소드 호출 / ({객체})}
			type: "get", //메소드
			url: "/JspStudy_home/signup-username-check", //요청주소
			data: {
				"username": username
			},
			dataType: "text", //응답을 받았을 때 데이터 타입
			success: function(data) { // 리스폰로 받아온 데이터 
				if (data == "true") {
					alert("이미 존재하는 사용자 이름입니다.");
					usernameCheckFlag = "true";
				} else {
					alert("가입 가능한 사용자 이름입니다.");
					usernameCheckFlag = "false";
				}
			},
			error: function(data) {
				alert("비동기 통신 오류");
			}

		});
	}

}