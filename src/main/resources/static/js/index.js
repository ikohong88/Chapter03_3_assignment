$(document).ready(function () {
    // $.removeCookie("1P_JAR");
    // let grade = rank();
    listing();

    if ($.cookie('token')) {
        $.ajaxSetup({
            headers:{
                'Authorization': $.cookie('token')
            }
        })
    } else {
        window.location.href = '/user/loginView';
    }

    $.ajax({
        type: "POST",
        url: `/user/userinfo`,
        contentType: "application/json",
        success: function (response) {
            const username = response.username;
            const isAdmin = !!response.admin;
            const isOwner = !!response.owner;
            console.log(username);
            $('#username').text(username);
            if (isAdmin) {
                showProduct(true);
            } else {
                showProduct();
            }
        },
        error: function() {
            alert("로그인에 실패하였습니다.")
        }
    })
});

function showProduct(isAdmin = false) {
    // 1. GET /api/products 요청
    // 2. #product-container(관심상품 목록), #search-result-box(검색결과 목록) 비우기
    // 3. for 문 마다 addProductItem 함수 실행시키고 HTML 만들어서 #product-container 에 붙이기
    $.ajax({
        type: 'GET',
        url: isAdmin ? '/api/admin/products' : '/api/products',
        success: function (response) {
            $('#product-container').empty();
            $('#search-result-box').empty();
            for (let i = 0; i < response.length; i++) {
                let product = response[i];
                let tempHtml = addProductItem(product);
                $('#product-container').append(tempHtml);
            }
        }
    })
}

function member_info() {

}

function signup() {
    window.location.href = '/user/signup'
}

function login() {
    window.location.href = "/user/loginView"
}

// 로그아웃 버튼
// 로그아웃은 내가 가지고 있는 토큰만 쿠키에서 없애면 됩니다.
function logout() {
    $.removeCookie('mytoken');
    alert('로그아웃!')
    window.location.reload();
}

function restaurantRegister() {
    window.location.href = "/restaurant/registration"
}

function foodRegister() {
    window.location.href = "/restaurant/1/foods"
}

// function change() {
//     $('#cards-box').empty()
//     let grade = rank();
//     listing(grade);
// }

// function rank() {
//     let val = $('#select_certificate').val()
//     return val
// }

// 첫 로딩시 데이터베이스 받아와서 뿌려주기
function listing() {
    $.ajax({
        type: 'GET',
        url: '/restaurants',
        data: {},
        success: function (response) {
            console.log(response)

            for (let i = 0; i < response.length; i++) {
                let name = response[i]['name']
                let minOrderPrice = response[i]['minOrderPrice']
                let restaurantId = response[i]['id']
                let deliveryFee = response[i]['deliveryFee']

                if (name != null) {
                    let temp_html = `<div class="col">
                                            <div class="card h-100" onclick="cert_info(${restaurantId})" id="card">
                                                <img src="https://cdn-icons-png.flaticon.com/512/5983/5983508.png" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">점표명 : ${name}</h5>
                                                    <h5 class="card-title">주문 최소금액 : ${minOrderPrice} 원</h5>
                                                    <h5 class="card-title">배달비 : ${deliveryFee} 원</h5>
                                                </div>
                                            </div>
                                        </div>`
                    $('#cards-box').append(temp_html);
                }
            }
        }
    })
}

// 검색 버튼
function search_button() {
    let user_input = $("#search").val()
    $('#cards-box').empty()
    $.ajax({
        type: "POST",
        url: "/certificate/search",
        data: {
            input_give:user_input
        },
        success: function (response) {
            // console.log(response)
            let rows = response['result']
            for (let i = 0; i < rows.length; i++) {
                let name = rows[i]['jmNm']
                let num = rows[i]['certificateNum']
                let index = rows[i]['index']

                if (name != null) {
                    let temp_html = `<div class="col">
                                            <div class="card h-100" onclick="cert_info(${num}, ${index})" id="card">
                                                <img src="https://cdn-icons-png.flaticon.com/512/5983/5983508.png" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">${name}</h5>
                                                </div>
                                            </div>
                                        </div>`
                    $('#cards-box').append(temp_html)
                }
            }
        }
    })
}

// 클라이언트에서 서버에 값 넘겨주기
function cert_info(index) {
    window.location.href = "/restaurant/"+index+"/foods"
}