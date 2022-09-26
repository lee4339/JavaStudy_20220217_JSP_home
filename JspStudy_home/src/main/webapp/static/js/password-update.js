const itemInputs = document.querySelectorAll(".item-input");
const originPasswordHidden = document.querySelector(".origin-password");
const passwordUpdateBtn = document.querySelector(".password-update-btn");
const profileUpdateBtn = document.querySelector(".profile-update-btn");

function isEmpty(str) {
	return str == "" || str == null || typeof str == "undefined";
}

passwordUpdateBtn.onclick = () => {
	let originPasswordInput = itemInputs[0].value;
	let newPasswordInput = itemInputs[1].value;
	let newRePasswordInput = itemInputs[2].value;
	
	if(isEmpty(originPasswordInput)){
		alert("이전 비밀번호를 입력해 주세요.");
	} else if(isEmpty(newPasswordInput)) {
		alert("새 비밀번호를 입력해 주세요.");
	} else if(newPasswordInput != newRePasswordInput) {
		alert("새 비밀번호가 일치하지 않습니다.");
	} else if(originPasswordInput != originPasswordHidden.value){
		alert("이전 비밀번호를 확인해 주세요.");
	} else if(originPasswordInput == newPasswordInput) {
		alert("이전 비밀번호와 동일한 비밀번호는 사용하실 수 없습니다.");
	} else {
		document.querySelector("form").submit();
	}
}