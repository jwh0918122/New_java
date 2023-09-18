// 댓글 등록시 bno, writer, content
document.getElementById('cmtAddBtn').addEventListener('click', () => {
    const cmtText = document.getElementById('cmtText').value;
    console.log(cmtText);
    if (cmtText == null || cmtText == "") {
        alert('댓글을 입력해주세요.');
        return false;
    } else {
        let cmtData = {
            bno: bnoVal,
            writer: document.getElementById('cmtWriter').value,
            content: cmtText
        };
        //전송 function 호출
        postCommentToServer(cmtData).then(result => { //isOk가 result임 (0 또는 1)
            if (result > 0) {
                alert("댓글 등록 성공~!!");
            } else {
                alert("댓글 등록 실패~!!");
            }
            printCommentList(cmtData.bno);
        });
    }
})

async function postCommentToServer(cmtData) {
    try {
        const url = "/cmt/post";
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text(); //0 또는 1 (isOk)
        return result;
    } catch (error) {
        console.log(error);
    }
}

function spreadCommentList(result) { //result 댓글 list
    console.log(result);
    let div = document.getElementById('accordionExample');
    div.innerHTML = "";
    for (let i = 0; i < result.length; i++) {
        let str = `<div class="accordion-item">`;
        str += `<h2 class="accordion-header" id="heading${i}">`;
        str += `<button class="accordion-button" type="button"`;
        str += `data-bs-toggle="collapse" data-bs-target="#collapse${i}"`;
        str += `aria-expanded="true" aria-controls="collapse${i}">`;
        str += `${result[i].cno}, ${result[i].writer}, ${result[i].regdate}`;
        str += `</button> </h2>`;
        str += `<div id="collapse${i}" class="accordion-collapse collapse show"`;
        str += `data-bs-parent="#accordionExample">`;
        str += `<div class="accordion-body">`;
        str += `<input type="text" class="form-control" id="cmtText" value="${result[i].content}">`;
        str += `<button type="button" data-cno="${result[i].cno}" data-writer="${result[i].writer}" class="btn btn-outline-warning cmtModBtn">%</button>`;
        str += `<button type="button" data-cno="${result[i].cno}" class="btn btn-outline-danger cmtDelBtn">X</button>`;
        str += `</div> </div> </div>`;
        div.innerHTML += str; //누적해서 담기
    }

}
/*수정,삭제 버튼 확인*/
document.addEventListener('click', (e) => { //화면 전체에 리스너를 주고 클릭되는 애를 매개변수(e)로 받음
    console.log(e.target);
    if (e.target.classList.contains('cmtModBtn')) { //e.target이 cmtModBtn 클래스를 포함하고 있다면
        let cno = e.target.dataset.cno; //dataset : 데이터 추출 => 콘솔창 : <button type="button" data-cno="1" class="cmtModBtn">%</button> 
        console.log(cno)

        //수정 구현 (수정할 데이터를 객체로 생성 -> 컨트롤러에서 수정 요청)
        let div = e.target.closest('div'); //target을 기준으로 가장 가까운 div를 찾아라★★★★★(잘씀)
        let cmtText1 = div.querySelector('#cmtText').value; // div 에서 'cmtText'의 아이디를 가지고 있는 것의 벨류를 가져오세요
        let writer = e.target.dataset.writer;

        //비동기 통신 함수 호출 => 처리
        updateCommentFromServer(cno, writer, cmtText1).then(result => {
            if (result > 0) {
                alert('댓글 수정 성공');
                printCommentList(bnoVal); //jsp에서 보낸 bnoVal
            } else {
                alert('댓글 수정 실패')
            }
        })

    }
    if (e.target.classList.contains('cmtDelBtn')) {
        let cno = e.target.dataset.cno;
        console.log(cno)
        //삭제 구현
        deleteCommentFromServer(cno).then(result => {
            if (result > 0) {
                alert('댓글 삭제 성공');
                printCommentList(bnoVal);
            } else {
                alert('댓글 삭제 실패')
            }
        })

    }

})
//삭제 함수
async function deleteCommentFromServer(cnoVal) {
    try {
        const resp = await fetch('/cmt/remove/' + cnoVal, { method: 'post' }); // mathod:'post' 안적으면 기본은 get방식.사실 안써도 됨
        const result = await resp.text();//0또는 1(isOk) //얘는 잘 됐는지 결과만 받아오는거니까 text로
        return result


    } catch (error) {
        console.log(error)
    }
}
//수정 함수
async function updateCommentFromServer(cnoVal, cmtWriter, cmtText) {
    try {
        const url = '/cmt/modify';
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify({ cno: cnoVal, writer: cmtWriter, content: cmtText })
        }
        const resp = await fetch(url, config);
        const result = await resp.text(); //0또는 1(isOk)//얘는 잘 됐는지 결과만 받아오는거니까 text로
        return result;

    } catch (error) {
        console.log(error);
    }
}

//서버에 댓글 리스트를 달라고 요청 함수
async function getCommentListFromServer(bno) {
    try {
        const resp = await fetch('/cmt/list/' + bno);  // /cmt/list/151
        const result = await resp.json(); //리스트이니까 json으로 
        return result;
    } catch (error) {
        console.log(error);
    }
}

function printCommentList(bno) {
    //함수 호출
    getCommentListFromServer(bno).then(result => {
        console.log(result);
        if (result.length > 0) {
            spreadCommentList(result);
        } else {
            let div = document.getElementById('accordionExample');
            div.innerHTML = `comment가 없습니다.`;
        }
    })
}
