//댓글 등록시 bno, writer, content
document.getElementById('cmtAddBtn').addEventListener('click', () => {
	const cmtText = document.getElementById('cmtText').value;
	console.log(cmtText);
	if (cmtText == null || cmtText == '') {
		alert('댓글을 입력해주세요');
		return false;
	} else {
		let cmtData = {
			bno: bnoVal,
			writer: document.getElementById('cmtWriter').value,
			content: cmtText
		};
		//전송 function 호출(postCommentToServer()함수 호출)
		postCommentToServer(cmtData).then(result => {
			if (result > 0) {
				alert("댓글 등록 성공~!!");
			} else {
				alert("댓글 등록 실패~!!")
			}
			printCommentList(cmtData.bno);
		});
	}

})

//전송 function
async function postCommentToServer(cmtData) {
	try {
		const url = '/cmt/post';
		const config = {
			method: 'post', //post => 등록
			headers: {
				'Content-Type': 'application/json; charset=utf-8' //콘텐츠타입:제이슨
			},
			body: JSON.stringify(cmtData)
		};

		const resp = await fetch(url, config);
		const result = await resp.text(); //0 또는 1(isOk)
		return result;

	} catch (error) {
		console.log(error);
	}
}

//화면에 뿌리기
function spreadCommentList(result) {//result 컨트롤러에서 받아온 댓글 lsit {[],[],[]} 형태
	console.log(result);
	let div = document.getElementById('accordionExample');
	div.innerHTML = '';
	for (let i = 0; i < result.length; i++) {
		let str = `<div class="accordion-item">`;
		str += `<h2 class="accordion-header" id="heading${i}">`;
		str += `<button class="accordion-button" type="button"`;
		str += `data-bs-toggle="collapse" data-bs-target="#collapse${i}"`;
		str += `aria-expanded="true" aria-controls="collapse${i}">`;
		str += `${result[i].cno}, ${result[i].writer}, ${result[i].regdate} </button></h2>`;
		str += `<div id="collapse${i}" class="accordion-collapse collapse show"`;
		str += `data-bs-parent="#accordionExample">`;
		str += `<div class="accordion-body">`;
		str += `<input type="text" class="form-control" id="cmtText" value="${result[i].content}><br>`
		str += `<button type="button" data-cno="${result[i].cno}"  class="btn btn-outline-warning cmtModBtn">%</button>`;
		str += `<button type="button" data-cno="${result[i].cno}" class="btn btn-outline-danger cmtDelBtn">X</button>`;
		str += `</div></div></div>`;
		div.innerHTML += str; //누적해서 담기
	}

}


//서버에 댓글 리스트를 달라고 요청
async function getCommentListFromServer(bno) {
	try {
		const resp = await fetch('/cmt/list/' + bno); //=> /cmt/list/151
		const resutl = await resp.json();
		return result;
	} catch (error) {
		console.log(error);
	}
}

//댓글 요청 함수 호출(getCommentListFromServer() 호출 함수)
function printCommentList(bno) {
	getCommentListFromServer(bno).then(result => {
		console.log(result);
		if (result.length > 0) {
			spreadCommentList(result);
		} else {
			let div = document.getElementById('accordionExample');
			div.innerHTML = 'comment가 없습니다.';
		}
	})
}


